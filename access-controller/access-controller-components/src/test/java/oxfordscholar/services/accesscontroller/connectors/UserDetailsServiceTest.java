package oxfordscholar.services.accesscontroller.connectors;

import java.util.List;
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
		
		String results = detailsService.getUserInfo("Bob");
		
		
	}
	
	
	
}
