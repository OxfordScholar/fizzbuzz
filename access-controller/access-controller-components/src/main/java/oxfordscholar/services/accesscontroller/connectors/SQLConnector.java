package oxfordscholar.services.accesscontroller.connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class SQLConnector {

	private String sqlUrl = "jdbc:mysql://localhost:8090/data";
	private String username = "root";
	private String password = "IckyDitto9";
	
	public List<String> getTypesForUser(String User)
	{
		List<String> types = new ArrayList<String>();
		
		try(Connection con = DriverManager.getConnection(sqlUrl, username, password))
		{
			String query = "SELECT Type.typeName FROM User JOIN User_types ON User.userId=User_types.userId JOIN Type on Type.typeId=User_types.typeId WHERE User.userName= ?";
			PreparedStatement s = con.prepareStatement(query);
			s.setString(1, User);
			
			ResultSet res = s.executeQuery();
			
			
			
			while (res.next())
			{
				types.add(res.getString("typeName"));
			}
		}
		
		// Error case - Cannot make connection to SQL server
		catch (SQLException err)
		{
			throw new IllegalStateException("Unable to connect to database", err);
		}
		
		// Success case - Close resultset, statement and connection
		finally
		{
			// Not sure why this is throwing an error
			s.close();
			res.close();
			con.close();
		}
		
		return types;
	}
	
	
}
