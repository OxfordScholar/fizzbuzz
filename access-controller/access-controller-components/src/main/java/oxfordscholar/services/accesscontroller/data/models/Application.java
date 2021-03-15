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
	
	@Column(name = "name")
	private String name;
	
	public String getName()
	{
		return name;
	}
}
