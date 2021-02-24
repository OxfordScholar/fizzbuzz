package oxfordscholar.services.accesscontroller.connectors;

import java.sql.Connection;
import java.sql.DriverManager;
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
	
	public List<String> getTypesForUser(String User)
	{
		List<String> types = new ArrayList<String>();
		
		try(Connection con = DriverManager.getConnection(sqlUrl, "root", "IckyDitto9"))
		{
			Statement s = con.createStatement();
			String query = "Select * from Type;";
			ResultSet res = s.executeQuery(query);
			
			while (res.next())
			{
				types.add(res.getString("admin"));
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
//			s.close();
//			res.close();
//			con.close();
		}
		
		return types;
	}
	
}
