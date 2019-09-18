package busticket.model;

public class RoleUser {
	private int id;
	private String roleName;

	public RoleUser() {
	}

	public RoleUser(String roleName) {
		super();
		this.roleName = roleName;
	}

	public RoleUser(int id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
