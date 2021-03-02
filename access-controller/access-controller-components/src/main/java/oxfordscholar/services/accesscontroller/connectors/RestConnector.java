package oxfordscholar.services.accesscontroller.connectors;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class responsible for handling connections to rest1 API
 *
 */
public class RestConnector {
	
	public String connectRest(String address)
	{
		//Setup
				StringBuilder response = new StringBuilder();
						
				try
				{
					
					// Build necessary components
					URL url = new URL(address);
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					InputStreamReader input  = new InputStreamReader(connection.getInputStream());
					BufferedReader buff = new BufferedReader(input);
					
					// Read in lines of input and add them to StringBuilder
					String line;
					while ((line = buff.readLine()) != null)
					{
						response.append(line);
					}
					
				}
				
				catch (MalformedURLException urlEx)
				{
					urlEx.printStackTrace();
				}
				
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
				
				finally
				{
//					connection.disconnect();
				}
				
				
				return response.toString();
	}

}
