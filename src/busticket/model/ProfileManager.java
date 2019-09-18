package busticket.model;

import java.sql.Date;

public class ProfileManager {
	private int id;
	private String managerName;
	private Date dateOfBirth;
	private String gender;
	private String phoneNumber;
	private boolean showProfile;
	private int idUser;

	public ProfileManager() {
		super();
	}

	public ProfileManager(String managerName, Date dateOfBirth, String gender, String phoneNumber, boolean showProfile,
			int idUser) {
		super();
		this.managerName = managerName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.showProfile = showProfile;
		this.idUser = idUser;
	}

	public ProfileManager(int id, String managerName, Date dateOfBirth, String gender, String phoneNumber,
			boolean showProfile, int idUser) {
		super();
		this.id = id;
		this.managerName = managerName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.showProfile = showProfile;
		this.idUser = idUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isShowProfile() {
		return showProfile;
	}

	public void setShowProfile(boolean showProfile) {
		this.showProfile = showProfile;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

}
