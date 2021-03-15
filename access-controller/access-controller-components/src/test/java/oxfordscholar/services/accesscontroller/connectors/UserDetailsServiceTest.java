package oxfordscholar.services.accesscontroller.connectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import oxfordscholar.services.accesscontroller.authorisation.IAuthorisationService;
import oxfordscholar.services.accesscontroller.authorisation.service.UserDetailsService;

public class UserDetailsServiceTest 
{

	/**
	 * Test UserDetailsService class using valid data
	 */
	@Test
	public void testUserDetailsServiceValid()
	{
		IAuthorisationService detailsService = new UserDetailsService("http://localhost:1000/restV2/webapi/rest/v3/users/%s");
		
		String results = "";
		try 
		{
			results = detailsService.getUserGroupsByApplication("cn=Hawk Bob (hawkb),ou=people,o=oxfordscholar,c=au", "App1");
		} 
		catch (Exception e) 
		{
			//Assert.fail("Unexpected Exception: " + e.getStackTrace());
			e.printStackTrace();
		}

		assertEquals("{\"groups\":[\"admin\"]}", results);
		System.out.println(results);
		
	}
	
	
	
}
