package oxfordscholar.services.accesscontroller.authorisation.service;

import oxfordscholar.services.accesscontroller.authorisation.IAuthorisationService;

public class AuthorisationApplication implements IAuthorisationService{
	
	private IAuthorisationService authService;
	
	public AuthorisationApplication(IAuthorisationService authService) 
	{
		this.authService = authService;
	}
	
	@Override
	public String getUserInfo(String dn)
	{
		return authService.getUserInfo(dn);
	}

}
