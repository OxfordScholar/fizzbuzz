package oxfordscholar.services.accesscontroller.resources;

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
	@Path("/groups/{projectId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserGroupsByProject(String dn, String projectId)
	{
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