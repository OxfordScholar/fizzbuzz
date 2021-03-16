package oxfordscholar.services.accesscontroller.authorisation.service;

import oxfordscholar.services.accesscontroller.authorisation.IAuthorisationService;
import oxfordscholar.services.accesscontroller.connectors.RestConnector;
import oxfordscholar.services.accesscontroller.connectors.SQLConnector;
import oxfordscholar.services.accesscontroller.data.models.Group;
import oxfordscholar.services.accesscontroller.data.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.gson.*;

public class UserDetailsService implements IAuthorisationService
{

	RestConnector rest;
	SQLConnector sql;
	Gson gson;
	private static final String DEFAULT_PERSISTENCEUNIT = "oxfordscholar";
	private EntityManagerFactory sessionFactory;
	
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
		sessionFactory = Persistence.createEntityManagerFactory(DEFAULT_PERSISTENCEUNIT);
	}
	
	public UserDetailsService(String url, EntityManagerFactory emf)
	{
		this.rest = new RestConnector(url);
		this.sql = new SQLConnector();
		this.gson = new Gson();
		sessionFactory = emf;
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
		List<String> groups = new ArrayList<String>();
//		groups = sql.getRolesForUser(dn);
		
		
		// Convert to JSON
		JsonParser jsonParser = new JsonParser();
		JsonObject json = (JsonObject)jsonParser.parse(rest1Response);
//		JsonArray groupsJson = new Gson().toJsonTree(groups).getAsJsonArray();
		
		// To be used if we need to merge groups into the request
//		json.add("groups", groupsJson);
		return json.toString();
		
	}

	@Override
	public String getUserGroupsByApplication(String dn, String application) throws Exception 
	{
		EntityManager entityManager = sessionFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<User> userList = entityManager.createNamedQuery("findUserByDn", User.class).setParameter("dn", dn).getResultList();
		
		if(userList.isEmpty())
			throw new Exception("No User Found");
		
		if(userList.size() > 1)
			throw new Exception("Expecting One User");
		
		User user = userList.get(0);
		
		List<Group> userGroups = user.getGroups();
		Predicate<Group> byApplication = group -> group.getApplication().getName().equals(application);
		List<String> groups = userGroups.parallelStream().filter(byApplication).map(Group::getName).collect(Collectors.toList());
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		Gson gson = new Gson();
		Map<String, List<String>> groupMap = new HashMap<String, List<String>>();
		groupMap.put("groups", groups);
		return gson.toJson(groupMap);
	}
	
}
