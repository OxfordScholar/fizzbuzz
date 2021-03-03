package oxfordscholar.services.accesscontroller.authorisation.service;

import oxfordscholar.services.accesscontroller.authorisation.IAuthorisationService;
import oxfordscholar.services.accesscontroller.connectors.SQLConnector;
import oxfordscholar.services.authentication.RestConnector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;

public class UserDetailsService implements IAuthorisationService{

	RestConnector rest;
	SQLConnector sql;
	
	public UserDetailsService(String url)
	{
		this.rest = new RestConnector();
		this.sql = new SQLConnector();
	}

	@Override
	public String getUserInfo(String dn) 
	{
		// Grab JSON from rest1
		
		String rest1Response = this.rest.connectRest(dn);
		
		
		// Get roles from SQL
		List<String> roles = new ArrayList<String>();
		roles = sql.getRolesForUser(dn);
		
		// Merge and return TODO
		
		
		return "todo";
		
	}
	
}
