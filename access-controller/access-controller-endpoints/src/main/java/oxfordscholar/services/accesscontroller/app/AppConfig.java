package oxfordscholar.services.accesscontroller.app;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
		this.loadProperties();
		
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
	
	/**
	 * Reads through configuration file for config data
	 */
	private void loadProperties()
	{
		String fileName = "conf/application.properties";
		
		if (System.getenv("APPLICATION_PROP_FILE") != null)
		{
			fileName = System.getenv("APPLICATION_PROP_FILE");
		}
		
		
		try
		{
			File configFile = new File(fileName);
			Scanner scanner = new Scanner(configFile);
			
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				// Add to our config state
				System.out.println(line);
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
