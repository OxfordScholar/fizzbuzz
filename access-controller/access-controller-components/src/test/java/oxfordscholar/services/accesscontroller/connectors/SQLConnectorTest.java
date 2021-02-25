package oxfordscholar.services.accesscontroller.connectors;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SQLConnectorTest {

	/**
	 * Testing getTypesForUser() function with valid data
	 * 
	 * 
	 */
	@Test
	public void testGetTypesForUserValid() 
	{
		SQLConnector connector = new SQLConnector();
		
		assert connector != null : "Connector was null"; // Null check
		
		// Testing for Bob user
		List<String> result = connector.getTypesForUser("Bob");
		assert result.get(0).strip().equals("admin") : "The output was wrong"; 
		
		// Testing for Helen user
		result = connector.getTypesForUser("Helen");
		assert result.get(0).strip().equals("admin") : "The output was wrong"; 
		
		// Testing for Mike user
		result = connector.getTypesForUser("Mike");
		assert result.get(0).strip().equals("analyst") : "The output was wrong"; 
				
		// Testing for Gregg user
		result = connector.getTypesForUser("Gregg");
		assert result.get(0).strip().equals("admin") : "The output was wrong"; 
		
		// Testing for Jess user
		result = connector.getTypesForUser("Jess");
		assert result.get(0).strip().equals("analyst") : "The output was wrong"; 
		
		// Testing for Brenda user
		result = connector.getTypesForUser("Brenda");
		assert result.get(0).strip().equals("analyst") : "The output was wrong"; 
	}
	
	/**
	 * Testing getTypesForUser() function with invalid data
	 */
	@Test
	public void testGetTypesForUserInvalid()
	{
		
		SQLConnector connector = new SQLConnector();
		
		assert connector != null : "Connector was null"; // Null check
		
		// Name that is not in the DB
		List<String> result = connector.getTypesForUser("Donny");
		assert result.isEmpty();
		
		// Empty name
		result = connector.getTypesForUser("");
		assert result.isEmpty();
		
		
		// Unsanitised inputs
		result = connector.getTypesForUser("nothing OR 1=1 ");
		assert result.isEmpty();
		
	}

}
