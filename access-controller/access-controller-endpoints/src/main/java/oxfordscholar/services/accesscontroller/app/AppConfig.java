package oxfordscholar.services.accesscontroller.app;

import org.glassfish.jersey.server.ResourceConfig;
import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("rest/v3")
public class AppConfig extends ResourceConfig
{
	
	public AppConfig()
	{
		packages("oxfordscholar.services.accesscontroller.resources");
	}

}
