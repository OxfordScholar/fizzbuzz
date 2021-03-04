package oxfordscholar.services.accesscontroller.connectors;

import java.util.List;
import org.junit.Test;

public class SQLConnectorTest 
{

	/**
	 * Testing getRolesForUser() function with valid data
	 * 
	 * 
	 */
	@Test
	public void testgetRolesForUserValid() 
	{
		SQLConnector connector = new SQLConnector();
		
		assert connector != null : "Connector was null"; // Null check
		
		// Testing for Bob user
		List<String> result = connector.getRolesForUser("Bob");
		assert result.get(0).strip().equals("admin") : "The output was wrong"; 
		
		// Testing for Helen user
		result = connector.getRolesForUser("Helen");
		assert result.get(0).strip().equals("admin") : "The output was wrong"; 
		
		// Testing for Mike user
		result = connector.getRolesForUser("Mike");
		assert result.get(0).strip().equals("analyst") : "The output was wrong"; 
				
		// Testing for Gregg user
		result = connector.getRolesForUser("Gregg");
		assert result.get(0).strip().equals("admin") : "The output was wrong"; 
		
		// Testing for Jess user
		result = connector.getRolesForUser("Jess");
		assert result.get(0).strip().equals("analyst") : "The output was wrong"; 
		
		// Testing for Brenda user
		result = connector.getRolesForUser("Brenda");
		assert result.get(0).strip().equals("analyst") : "The output was wrong"; 
	}
	
	/**
	 * Testing getRolesForUser() function with invalid data
	 */
	@Test
	public void testgetRolesForUserInvalid()
	{
		
		SQLConnector connector = new SQLConnector();
		
		assert connector != null : "Connector was null"; // Null check
		
		// Name that is not in the DB
		List<String> result = connector.getRolesForUser("Donny");
		assert result.isEmpty();
		
		// Empty name
		result = connector.getRolesForUser("");
		assert result.isEmpty();
		
		
		// Unsanitised inputs
		result = connector.getRolesForUser("nothing OR 1=1 ");
		assert result.isEmpty();
		
	}
	
	/**
	 * Testing getRolesByUserInApp() with valid data
	 */
	@Test
	public void testGetRolesForUserInAppValid()
	{
		SQLConnector connector = new SQLConnector();
		
		assert connector != null : "Connector was null"; // Null check
		
		List<String> result = connector.getRolesByUserInApp("Bob", "111111111111111111111111111111111111");
		assert result.get(0).strip().equals("admin");
		
		result = connector.getRolesByUserInApp("Mike", "444444444444444444444444444444444444");
		assert result.get(0).strip().equals("analyst");
	}
	
	/**
	 * Testing getRolesByUserInApp() with invalid data
	 */
	@Test
	public void testGetRolesForUserInAppInvalid()
	{
		SQLConnector connector = new SQLConnector();
		
		assert connector != null : "Connector was null"; // Null check
		
		List<String> result = connector.getRolesByUserInApp("Bob", "hello");
		assert result.isEmpty();
		
		result = connector.getRolesByUserInApp("Mike", "test");
		assert result.isEmpty();
	}
	
	/**
	 * Testing queryUserRoleInApp() with valid data
	 */
	@Test
	public void testQueryUserRolesInAppValid()
	{
		SQLConnector connector = new SQLConnector();
		
		assert connector != null : "Connector was null";
		
		Boolean result = connector.queryUserRoleInApp("Bob", "111111111111111111111111111111111111", 1);
		assert result;
	}
	
	/**
	 * Testing queryUserRoleInApp() with valid data
	 */
	@Test
	public void testQueryUserRolesInAppInvalid()
	{
		SQLConnector connector = new SQLConnector();
		
		assert connector != null : "Connector was null";
		
		Boolean result = connector.queryUserRoleInApp("Bob", "111111111111111111111111111111111111", 2);
		assert !result;
		
		result = connector.queryUserRoleInApp("James", "111111111111111111111111111111111111", 2);
		assert !result;
		
		result = connector.queryUserRoleInApp("Bob", "hello", 3);
		assert !result;
		
	}

}
