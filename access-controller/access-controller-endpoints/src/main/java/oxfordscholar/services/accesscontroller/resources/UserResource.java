package oxfordscholar.services.accesscontroller.resources;

import oxfordscholar.services.accesscontroller.connectors.*;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import oxfordscholar.services.accesscontroller.authorisation.service.AuthorisationApplication;

/**
 * 
 *
 */
@Path("/users")
public class UserResource {

	@Inject
	AuthorisationApplication authApp;
	
	/**
	 * 
	 * @param dn Distinguished Name
	 * @return
	 */
	@Path("/{dn}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserProfile(@PathParam("dn") String dn)
	{
		return authApp.getUserInfo(dn);
	}
	
	// Returns all groups that user is part of by project ID
	@GET
	@Path("/groups/{applicationId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserGroupsByProject(String dn, String projectId)
	{	
		
		SQLConnector connector = new SQLConnector();
		
		List<String> allTypes = connector.getTypesByUserInApp(dn, 1);
		
		
		return "todo";
	}
	
	// Returns all roles user has
	@GET
	@Path("/roles")
	@Produces(MediaType.APPLICATION_JSON)
	public String userRoles(String dn)
	{
		return "todo";
	}
	
}