package oxfordscholar.services.accesscontroller.app;


import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;
import oxfordscholar.services.accesscontroller.authorisation.AuthorisationServiceFactory;
import oxfordscholar.services.accesscontroller.authorisation.service.AuthorisationApplication;

@ApplicationPath("/")
public class AppConfig extends ResourceConfig
{
	
	private AuthorisationApplication authApp;
	
	public AppConfig()
	{
		
		AuthorisationServiceFactory factory = new AuthorisationServiceFactory();
		
		
		factory.buildAuthService("http://localhost:1000/restV2/webapi/rest/v3/users/", "userdetails");
		authApp = factory.getAuthorisationService();
		
		register(new AbstractBinder() 
		{
			
			@Override
			protected void configure() 
			{
				bind(authApp).to(AuthorisationApplication.class);
			}
		});
		packages("oxfordscholar.services.accesscontroller");
	}

}
