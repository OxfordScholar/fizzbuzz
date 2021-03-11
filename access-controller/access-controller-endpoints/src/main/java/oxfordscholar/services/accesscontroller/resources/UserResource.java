package oxfordscholar.services.accesscontroller.resources;

import oxfordscholar.services.accesscontroller.connectors.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.*;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import oxfordscholar.services.accesscontroller.authorisation.service.AuthorisationApplication;
import oxfordscholar.services.accesscontroller.authorisation.AuthorisationServiceFactory;


/**
 * 
 *
 */
@Path("/users")
public class UserResource 
{

	@Inject
	private AuthorisationApplication authApp;
	
	/**
	 * Returns user profile
	 * 
	 * @param dn Distinguished Name
	 * @return JSON of User profile
	 */
	@GET
	@Path("/{dn}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserProfile(@PathParam("dn") String dn)
	{
		// Needs to talk to Rest1
		return authApp.getUserInfo(dn);
	}
	
	/**
	 * Obtains all Roles held by User for specific Application
	 * 
	 * @param dn Distinguished Name
	 * @param appId Application Id
	 * @return JSON containing all Roles for User in particular Application
	 */
	@GET
	@Path("/{dn}/groups/{applicationId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserRolesByApplication(@PathParam("dn") String dn, @PathParam("applicationId") String appId)
	{	
		
		String userDetails = getUserProfile(dn);
		
		SQLConnector connector = new SQLConnector();
		
		List<String> roles = connector.getRolesByUserInApp(dn, appId);

		
		// JSON conversions
		JsonParser jsonParser = new JsonParser();
		JsonArray rolesJson = (JsonArray)jsonParser.parse(new Gson().toJson(roles));
		JsonObject userJson = (JsonObject)jsonParser.parse(userDetails);
	
		userJson.add("roles", rolesJson);

		return userJson.toString();
	}
	
	/**
	 * Obtains all roles held by User
	 * 
	 * @param dn Distinguished Name
	 * @return JSON containing all Roles for User
	 */
	@GET
	@Path("/{dn}/roles")
	@Produces(MediaType.APPLICATION_JSON)
	public String userRoles(@PathParam("dn") String dn)
	{
		SQLConnector connector = new SQLConnector();
		
		List<String> roles = connector.getRolesForUser(dn);
		Map<String, List<String>> response = new HashMap() {{
			put("roles", roles);
			
		}};
		
		//Format results into JSON and return
		String json = new Gson().toJson(roles);
		return json;
	}
	
	
}