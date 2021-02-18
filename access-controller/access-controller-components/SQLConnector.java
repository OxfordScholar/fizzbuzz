import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import com.mysql.jdbc.Statement;

public class SQLConnector {

	private String sqlUrl = "localhost:8090";
	
	public List<String> getGroupsForUser(String User)
	{
		List<String> groups = new List<String>;
		
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
