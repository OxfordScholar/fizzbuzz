package oxfordscholar.services.accesscontroller.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oxfordscholar.utilities.models.AppRole;
import oxfordscholar.utilities.models.UserRole;

/*
 * CRUD functions used when interfacing with GUI
 */
public class SQLCrud {

	private String sqlUrl = "jdbc:mysql://localhost:8090/data";
	private String username = "root";
	private String password = "IckyDitto9";
	
	// ---------- READ OPERATIONS -----------
	
	
	/**
	 * Returns all Applications currently in DB
	 * 
	 * @return List<String> of Applications
	 */
	private List<String> readApplications()
	{
		List<String> apps = new ArrayList<String>();
		String query = "SELECT appName from Application;";

		
		try (
				Connection con = DriverManager.getConnection(sqlUrl, username, password);
				PreparedStatement statement = con.prepareStatement(query);
				ResultSet res = statement.executeQuery();
		)
		{
			while(res.next())
			{
				apps.add(res.getString("appName"));
			}
		}
		
		catch (SQLException err)
		{
			throw new IllegalStateException("An error occured with the DB", err);
		}
		
		return apps;
	}
	
	
	
	private List<AppRole> readRoles()
	{
		List<AppRole> appRoles = new ArrayList<AppRole>();
		
		String query = "SELECT DISTINCT Role.roleName, Application.appName from Role JOIN Application on Application.appId=Role.appId;";
		
		try (
				Connection con = DriverManager.getConnection(sqlUrl, username, password);
				PreparedStatement statement = con.prepareStatement(query);
				ResultSet res = statement.executeQuery();
		)
		{
			while(res.next())
			{
				AppRole pair = new AppRole();
				pair.roleName = res.getString("roleName");
				pair.appName = res.getString("appName");
				appRoles.add(pair);
			}
		}
		
		catch (SQLException err)
		{
			throw new IllegalStateException("An error occured with the DB", err);
		}
		
		
		return appRoles;
	}
	
	/**
	 * Reads all Users within the database
	 * 
	 * @return List<String> of Users
	 */
	private List<String> readUsers()
	{
		List<String> users = new ArrayList<String>();
		String query = "SELECT userName from User;";

		
		try (
				Connection con = DriverManager.getConnection(sqlUrl, username, password);
				PreparedStatement statement = con.prepareStatement(query);
				ResultSet res = statement.executeQuery();
		)
		{
			while(res.next())
			{
				users.add(res.getString("userName"));
			}
		}
		
		catch (SQLException err)
		{
			throw new IllegalStateException("An error occured with the DB", err);
		}
		
		return users;
	}
	
	/**
	 * Reads all Role/User pairs within DB
	 * 
	 * @return List<UserRole> of User/Role pairs
	 */
	private List<UserRole> readUserRoles()
	{
		
		String query = "SELECT DISTINCT Role.roleName, User.userName from User_roles JOIN Role ON Role.roleId=User_roles.roleId JOIN User ON User.userId";
		
		List<UserRole> userRoles = new ArrayList<UserRole>();
				
		try (
				Connection con = DriverManager.getConnection(sqlUrl, username, password);
				PreparedStatement statement = con.prepareStatement(query);
				ResultSet res = statement.executeQuery();
		)
		{
			while(res.next())
			{
				UserRole pair = new UserRole();
				pair.roleName = res.getString("roleName");
				pair.userName = res.getString("userName");
				userRoles.add(pair);
			}
		}
		
		catch (SQLException err)
		{
			throw new IllegalStateException("An error occured with the DB", err);
		}
		
		
		return userRoles;
	}
	
	
	
	
	
}
