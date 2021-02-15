package oxfordscholar.services.accesscontroller.app;

import org.eclipse.jetty.servlet.ServletContextHandler;
import org.glassfish.jersey.server.ResourceConfig;
import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("rest/v3")
public class AppConfig extends ResourceConfig
{
	
	public AppConfig()
	{
		packages("com.oxfordscholar.access-controller");
	}

}
