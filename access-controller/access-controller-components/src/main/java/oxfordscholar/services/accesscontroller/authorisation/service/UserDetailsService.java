package oxfordscholar.services.accesscontroller.authorisation.service;

import oxfordscholar.services.accesscontroller.authorisation.IAuthorisationService;
import oxfordscholar.services.accesscontroller.connectors.SQLConnector;
import oxfordscholar.services.accesscontroller.authentication.RestConnector;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;

public class UserDetailsService implements IAuthorisationService
{

	RestConnector rest;
	SQLConnector sql;
	Gson gson;
	
	/**
	 * Constructor for UserDetailsService class
	 * 
	 * @param url URL of endpoint
	 */
	public UserDetailsService(String url)
	{
		this.rest = new RestConnector(url);
		this.sql = new SQLConnector();
		this.gson = new Gson();
	}

	/**
	 * Returns user info from given address
	 * 
	 * @param dn Distinguished Name
	 */
	@Override
	public String getUserInfo(String dn) 
	{
		// Grab JSON from rest1
		String rest1Response = this.rest.connectRest(dn);
		
		
		// Get roles from SQL
		List<String> roles = new ArrayList<String>();
		roles = sql.getRolesForUser(dn);
		
		
		// Convert to JSON
		JsonParser jsonParser = new JsonParser();
		JsonObject json = (JsonObject)jsonParser.parse(rest1Response);
		JsonArray rolesJson = new Gson().toJsonTree(roles).getAsJsonArray();
		
		// Merge and return
		json.add("groups", rolesJson);
		return json.toString();
		
	}
	
}
