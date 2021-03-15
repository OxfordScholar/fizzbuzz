package oxfordscholar.services.accesscontroller.data.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ds_group")
public class Group 
{
	@Id
	@Column(name = "group_id")
	private int groupId;
	
	@Column(name = "name")
	private String name;
	
	public String getName()
	{
		return name;
	}
	
	@ManyToMany(mappedBy = "groups")
	private List<User> users;
	
	public List<User> getUsers()
	{
		return users;
	}
	
	@OneToOne
	@JoinColumn(name = "application_id")
	private Application application;
	
	public Application getApplication()
	{
		return application;
	}
	
}
