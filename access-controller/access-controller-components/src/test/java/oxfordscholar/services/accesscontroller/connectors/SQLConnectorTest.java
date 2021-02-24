package oxfordscholar.services.accesscontroller.connectors;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SQLConnectorTest {

	@Test
	public void test() 
	{
		SQLConnector connector = new SQLConnector();
		
		assert connector != null : "Connector was null"; // Null check
		
		List<String> result = connector.getTypesForUser("Bob");
		
		System.out.println(result.get(0));
		
		assert result.get(0).strip().equals("admin") : "The output was wrong"; // Assertion for correct output
	}

}
