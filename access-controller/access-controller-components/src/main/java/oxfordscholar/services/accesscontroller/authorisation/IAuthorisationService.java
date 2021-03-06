package oxfordscholar.services.accesscontroller.authorisation;

public interface IAuthorisationService {

	public String getUserInfo(String dn) throws Exception;
	public String getUserGroupsByApplication(String dn, String application) throws Exception;
	String getUserGroups(String dn) throws Exception;
	}