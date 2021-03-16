package oxfordscholar.services.accesscontroller.resources;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/api")
public class ApiResource {

	private static final String DEFAULT_PERSISTENCEUNIT = "oxfordscholar";
	private EntityManagerFactory sessionFactory;
	
	public ApiResource()
	{
		sessionFactory = Persistence.createEntityManagerFactory(DEFAULT_PERSISTENCEUNIT);
	}
	
	@POST
	@Path("/create")
	public Boolean setUserName(@PathParam("newDn") String newDn)
	{
		
		
		return false;
	}
	
	@PATCH
	@Path("/update")
	public Boolean deleteUser(@PathParam("userId") int userId)
	{
		
		
		return false;
	}
	
	
	@POST
	@Path("/revoke")
	public Boolean revokeUser(@PathParam("userId") int userId, @PathParam("group") String group)
	{
		
		return false;
	}
	
}
