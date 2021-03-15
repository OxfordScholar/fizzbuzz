package oxfordscholar.services.accesscontroller.data.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "ds_user")
@NamedQueries({
	@NamedQuery(name = "findUserByDn", query = "SELECT u FROM User u WHERE u.dn = :dn")
})
public class User 
{
	@Id
	@Column(name = "user_id")
	private int userId;
	
	public void setUserId(int usrId)
	{
		userId = usrId;
	}
	
	@Column(name = "name")
	private String dn;
	
	public String getDn()
	{
		return dn;
	}
	
	public void setDn(String userDn)
	{
		dn = userDn;
	}
	
	@ManyToMany
	@JoinTable(
			name = "ds_user_group",
			joinColumns = @JoinColumn(name = "user_Id"),
			inverseJoinColumns = @JoinColumn(name = "group_Id"))
	List<Group> groups;
	
	public List<Group> getGroups() 
	{
		return groups;
	}
	
	public void setGroups(List<Group> userGroups)
	{
		groups = userGroups;
	}
}
