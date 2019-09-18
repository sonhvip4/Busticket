package busticket.model;

import java.sql.Date;

public class ProfileCustomer  {
	private int id;
	private String customerName;
	private Date dateOfBirth;
	private String gender;
	private String phoneNumber;
	private boolean showProfile;
	private String country;
	private int idUser;

	public ProfileCustomer() {
	}

	public ProfileCustomer(String customerName, Date dateOfBirth, String gender, String phoneNumber,
			boolean showProfile, String country, int idUser) {
		super();
		this.customerName = customerName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.showProfile = showProfile;
		this.country = country;
		this.idUser = idUser;
	}

	public ProfileCustomer(int id, String customerName, Date dateOfBirth, String gender, String phoneNumber,
			boolean showProfile, String country, int idUser) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.showProfile = showProfile;
		this.country = country;
		this.idUser = idUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

}
