package oxfordscholar.utilities;

/**
 * Model for JSON object - probably need to refactor later
 * @author dev
 *
 */
public class JsonModel {
	
	//Base level
	String firstName;
	String lastName;
	
	//Inner level
	class dn
	{
		String cn;
		String ou;
		String c;
	}

}
