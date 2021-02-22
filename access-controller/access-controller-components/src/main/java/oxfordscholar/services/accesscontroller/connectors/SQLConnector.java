package oxfordscholar.services.accesscontroller.connectors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SQLConnector {

	private String sqlUrl = "localhost:8090";
	
	public List<String> getGroupsForUser(String User)
	{
		List<String> groups = new ArrayList<String>();
		
		try(Connection con = DriverManager.getConnection(sqlUrl))
		{
			Statement s = con.createStatement();
			String query = "Select * from Type;";
			Results res = s.executeQuery(query);
			
			while (res.next())
			{
				groups.add(res.getString("admin"));
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
			s.close();
			res.close();
			con.close();
		}
		
		return groups;
	}
	
}
