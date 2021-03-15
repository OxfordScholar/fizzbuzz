package oxfordscholar.services.accesscontroller.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ds_application")
public class Application 
{
	@Id
	@Column(name = "application_id")
	private String applicationId;
	
	public void setApplicationId(String appId)
	{
		applicationId = appId;
	}
	
	@Column(name = "name")
	private String name;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String appName)
	{
		name = appName;
	}
}
