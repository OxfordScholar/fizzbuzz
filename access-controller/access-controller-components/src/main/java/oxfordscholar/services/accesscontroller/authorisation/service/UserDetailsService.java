package oxfordscholar.services.accesscontroller.authorisation.service;

import oxfordscholar.services.accesscontroller.authorisation.IAuthorisationService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.*;

public class UserDetailsService implements IAuthorisationService{

	public UserDetailsService(String url)
	{
		
	}

	@Override
	public String getUserInfo(String dn) 
	{
		
		return "todo";
		
	}
	
}
