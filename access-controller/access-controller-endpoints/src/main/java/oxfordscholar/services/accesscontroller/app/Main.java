package oxfordscholar.services.accesscontroller.app;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class Main {

	public static void main(String[] args) 
	{
		int port = 8100; // TODO - change
		
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);

		context.setContextPath("/");
		AppConfig appConfig = new AppConfig();
		
		ServletContainer jerseyContainer = new ServletContainer(appConfig);
		
		ServletHolder servletHolder = new ServletHolder(jerseyContainer);
		
		context.addServlet(servletHolder, "/rest/v3/*");
		
		Server server = new Server(port);
		server.setHandler(context);
		
		
		try
		{
			server.start();
			server.join();
		} 
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		finally
		{
			server.destroy();
		}
	}

}