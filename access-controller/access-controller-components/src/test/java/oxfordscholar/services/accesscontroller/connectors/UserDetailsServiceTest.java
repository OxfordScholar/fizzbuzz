package oxfordscholar.services.accesscontroller.connectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import oxfordscholar.services.accesscontroller.authorisation.IAuthorisationService;
import oxfordscholar.services.accesscontroller.authorisation.service.UserDetailsService;
import oxfordscholar.services.accesscontroller.data.models.Application;
import oxfordscholar.services.accesscontroller.data.models.Group;
import oxfordscholar.services.accesscontroller.data.models.User;

public class UserDetailsServiceTest 
{
	IAuthorisationService detailsService;
	
	@Before
	public void setup()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oxfordscholar-unittest");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Application app1 = new Application();
		app1.setApplicationId("111111111111111111111111111111111111");
		app1.setName("App1");
		em.persist(app1);
		
		Group adminGroup = new Group();
		adminGroup.setGroupId(1);
		adminGroup.setName("admin");
		adminGroup.setApplication(app1);
		em.persist(adminGroup);
		
		User bob = new User();
	    bob.setUserId(1);
	    bob.setDn("cn=Hawk Bob (hawkb),ou=people,o=oxfordscholar,c=au");
	    bob.setGroups(Arrays.asList(adminGroup));
	    em.persist(bob);
	    
		em.getTransaction().commit();
		em.close();
		detailsService = new UserDetailsService("mockurl", emf);
	}

	/**
	 * Test UserDetailsService class using valid data
	 */
	@Test
	public void testUserDetailsServiceValid()
	{
		String results = "";
		try 
		{
			results = detailsService.getUserGroupsByApplication("cn=Hawk Bob (hawkb),ou=people,o=oxfordscholar,c=au", "App1");
		} 
		catch (Exception e) 
		{
			//Assert.fail("Unexpected Exception: " + e.getStackTrace());
			e.printStackTrace();
		}

		assertEquals("{\"groups\":[\"admin\"]}", results);
		System.out.println(results);
		
	}
	
	//For bailey to check
//	@Test
//	public void testConnect()
//	{
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oxfordscholar");
//		
//		EntityManager em = emf.createEntityManager();
//		
//		em.getTransaction().begin();
//		
//		Query query = em.createQuery("SELECT u FROM User u");
//		User user = (User) query.getResultList().get(0);
//		System.out.println(user.getDn());
//		
//		em.getTransaction().commit();
//		em.close();
//	}
	
}
