package oxfordscholar.services.accesscontroller.authorisation;

public interface IAuthorisationService {

	public String getUserInfo(String dn) throws Exception;
	public String getUserGroupsByApplication(String dn, String application) throws Exception;
	public String getUserRoles(String dn) throws Exception;
}