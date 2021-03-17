package oxfordscholar.services.accesscontroller.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import oxfordscholar.services.accesscontroller.authorisation.service.AuthorisationApplication;
import oxfordscholar.services.accesscontroller.connectors.SQLConnector;

@Path("/groups")
public class GroupResource 
{
	
	@Inject
	AuthorisationApplication authApp;
	
	/**
	 * Shows whether a given User holds particular Role in Application
	 * 
	 * @param appId Application ID
	 * @param roleId Role ID
	 * @param dn Distinguished Name
	 * @return Boolean of whether User holds Role within Application
	 */
	@GET
	@Path("/{applicationId}!{roleId}/members/{dn}")
	public Boolean doesUserHaveRoleInApp(@PathParam("applicationId") String appId, @PathParam("roleId") int roleId, @PathParam("dn") String dn)
	{
		
		SQLConnector connector = new SQLConnector();
		
		Boolean hasRole = connector.queryUserRoleInApp(dn, appId, roleId);
		
		return hasRole;
	}
	
}
