package oxfordscholar.services.accesscontroller.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * 
 *
 */
@Path("/users")
public class AuthorisationResource {

	
	/**
	 * 
	 * @param dn
	 * @return
	 */
	@Path("/{dn}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserProfile(@PathParam("dn") String dn)
	{
		return "{\"dn\":\"test\"}";
	}
	
}