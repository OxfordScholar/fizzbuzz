package oxfordscholar.services.accesscontroller.connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLConnector {

	private String sqlUrl = "jdbc:mysql://localhost:8090/data";
	private String username = "root";
	private String password = "IckyDitto9";
	
	/**
	 * Obtains all Roles associated with User.
	 * 
	 * @param User
	 * @return List<String> containing Roles associated with User
	 */
	public List<String> getRolesForUser(String user)
	{
		List<String> roles = new ArrayList<String>();
		
		try(Connection con = DriverManager.getConnection(sqlUrl, username, password))
		{
			String query = "SELECT Role.roleName FROM User JOIN User_roles ON User.userId=User_roles.userId JOIN Role on Role.roleId=User_roles.roleId WHERE User.userName= ?";
			PreparedStatement s = con.prepareStatement(query);
			s.setString(1, user);
			
			ResultSet res = s.executeQuery();
			
			while (res.next())
			{
				roles.add(res.getString("roleName"));
			}
		}
		
		// Error case - Cannot make connection to SQL server
		catch (SQLException err)
		{
			throw new IllegalStateException("An error occured with the DB", err);
		}
		
		// Success case - Close resultset, statement and connection
		finally
		{
			// Not sure why this is throwing an error
//			s.close();
//			res.close();
//			con.close();
		}
		
		return roles;
	}
	
	
	/**
	 * Obtains all Roles associated with User from given Application
	 * 
	 * @param user Name of user.
	 * @param appId Id of Application
	 * @return List<String> of Roles that User holds in Application
	 */
	public List<String> getRolesByUserInApp(String user, String appId)
	{
		List<String> roles = new ArrayList<String>();
		
		try(Connection con = DriverManager.getConnection(sqlUrl, username, password))
		{
			String query = "SELECT Role.roleName FROM Role JOIN User_roles ON Role.roleId=User_roles.roleId JOIN User ON User.userId=User_roles.userId WHERE User.userName=? AND Role.appId=?";
			
			PreparedStatement s = con.prepareStatement(query);
			s.setString(1, user);
			s.setString(2, appId);
			
			ResultSet res = s.executeQuery();
			
			
			while (res.next())
			{
				roles.add(res.getString("roleName"));
			}
		}
		
		catch(SQLException err)
		{
			throw new IllegalStateException("An error occured with the DB", err);
		}
		
		// Success case - Close resultset, statement and connection
		finally
		{
			// Not sure why this is throwing an error
//			s.close();
//			res.close();
//			con.close();
		}
		
		return roles;
	}
	
	
	/**
	 * Checks whether user holds specific Role in Application
	 * 
	 * @param dn Distinguished Name
	 * @param appId Application ID
	 * @param roleId Role ID
	 * @return Boolean of whether User holds Role in App
	 */
	public Boolean queryUserRoleInApp(String dn, String appId, int roleId)
	{
		Boolean roleFlag;
		
		try (Connection con = DriverManager.getConnection(sqlUrl, username, password))
		{
			
			String query = "SELECT 1 FROM Role JOIN User_roles ON Role.roleId=User_roles.roleId JOIN User ON User.userId=User_roles.userId WHERE User.userName=? AND Role.appId=? AND Role.roleId=?";
			
			PreparedStatement s = con.prepareStatement(query);
			s.setString(1, dn);
			s.setString(2, appId);
			s.setString(3, Integer.toString(roleId));
			
			ResultSet res = s.executeQuery();
			
			
			// ROle will be 
			roleFlag = res.next();
			
		}
		
		catch (SQLException err)
		{
			throw new IllegalStateException("An error occured with the DB", err);
		}
		
		// Success case - Close resultset, statement and connection
		finally
		{
			// Not sure why this is throwing an error
//					s.close();
//					res.close();
//					con.close();
		}
		
		
		return roleFlag;
			
	}
	
}
