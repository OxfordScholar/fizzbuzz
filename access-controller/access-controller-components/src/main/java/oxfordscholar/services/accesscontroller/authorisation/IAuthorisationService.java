package oxfordscholar.services.accesscontroller.authorisation;

public interface IAuthorisationService {

	public String getUserInfo(String dn);
	public String getUserGroupsByApplication(String dn, String application) throws Exception;
}