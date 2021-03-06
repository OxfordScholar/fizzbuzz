package com.OxfordScholar.restV2;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.HashMap;


/**
 * Root resource
 */
@Path("rest/v3/users/{dn}")
public class ApiResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as JSON
     *
     * @param DN (Distinguished name)
     * @return JSON object of user details
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(@PathParam("DN") String dn) {
    	
    		// Generating dummy data
    		String dnString = "cn=ipsum lorem(lxipsum), ou=defence, c=au";
    		
    		
    		HashMap<String, String> response = new HashMap<String, String>();
    		response.put("firstName", "lorem");
    		response.put("lastName", "ipsum");	
    		response.put("dn", dnString);
    		
    		return JsonHelper.jsonStringParser(response);
    }
}
