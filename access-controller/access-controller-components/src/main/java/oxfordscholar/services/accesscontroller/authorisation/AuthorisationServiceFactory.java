package oxfordscholar.services.accesscontroller.authorisation;

import oxfordscholar.services.accesscontroller.authorisation.service.AuthorisationApplication;
import oxfordscholar.services.accesscontroller.authorisation.service.UserDetailsService;

public class AuthorisationServiceFactory {
	
	private IAuthorisationService authService;
	private AuthorisationApplication authApp;
	
	public void buildAuthService(String url, String type)
	{
		
		if (type.equalsIgnoreCase("userdetails"))
		{
			authService = new UserDetailsService(url);
			authApp = new AuthorisationApplication(authService);
		}

	}
	
	public AuthorisationApplication getAuthorisationService()
	{
		return authApp;
	}

}
