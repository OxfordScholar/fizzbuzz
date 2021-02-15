package oxfordscholar.services.accesscontroller.app;

import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class Main {

	public static void main(String[] args) {
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);

		context.setContextPath("/");
		AppConfig appConfig = new AppConfig();
		
		ServletContainer jerseyContainer = new ServletContainer(appConfig);
		
		ServletHolder servletHolder = new ServletHolder(jerseyContainer);
	}

}