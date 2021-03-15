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
		try 
		{
			return authApp.getUserInfo(dn);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "NOT FOUND";
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
		try {
			return authApp.getUserGroupsByApplication(dn, appId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "NOT FOUND";
//		String userDetails = getUserProfile(dn);
//		 
//		SQLConnector connector = new SQLConnector();
//		
//		List<String> roles = connector.getRolesByUserInApp(dn, appId);
//
//		
//		// JSON conversions
//		JsonParser jsonParser = new JsonParser();
//		JsonArray rolesJson = (JsonArray)jsonParser.parse(new Gson().toJson(roles));
//		JsonObject userJson = (JsonObject)jsonParser.parse(userDetails);
//	
//		userJson.add("roles", rolesJson);
//
//		return userJson.toString();
	}
	
	/**
	 * Obtains all groups held by User
	 * 
	 * @param dn Distinguished Name
	 * @return JSON containing all Groups for User
	 */
	@GET
	@Path("/{dn}/groups")
	@Produces(MediaType.APPLICATION_JSON)
	public String userRoles(@PathParam("dn") String dn)
	{
//		SQLConnector connector = new SQLConnector();
//		
//		List<String> roles = connector.getRolesForUser(dn);
//		Map<String, List<String>> response = new HashMap() {{
//			put("roles", roles);
//			
//		}};
//		
//		//Format results into JSON and return
//		String json = new Gson().toJson(roles);
//		return json;
		try {
			return authApp.getUserGroups(dn);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return "NOT FOUND";
	}
	
	
}