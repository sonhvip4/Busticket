package busticket.model;

import java.util.List;

public class User {
	private int id;
	private String userName;
	private String email;
	private String password;
	private List<String> roleName;
	private RoleUser roleObject;
	private boolean isActived;
	private int idRoleUser;

	public User() {
	}

	public User(String userName, String email, String password, boolean isActived, int idRoleUser) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.isActived = isActived;
		this.idRoleUser = idRoleUser;
	}

	public User(int id, String userName, String email, String password, boolean isActived, int idRoleUser) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.isActived = isActived;
		this.idRoleUser = idRoleUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActived() {
		return isActived;
	}

	public void setActived(boolean isActived) {
		this.isActived = isActived;
	}

	public int getIdRoleUser() {
		return idRoleUser;
	}

	public void setIdRoleUser(int idRoleUser) {
		this.idRoleUser = idRoleUser;
	}

	public RoleUser getRoleObject() {
		return roleObject;
	}

	public void setRoleObject(RoleUser roleObject) {
		this.roleObject = roleObject; 
	}
	
	public List<String> getRoleName() {
		return roleName;
	}

	public void setRoleName(List<String> roleName) {
		this.roleName = roleName;
	}

}
