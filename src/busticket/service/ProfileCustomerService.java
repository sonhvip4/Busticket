package busticket.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import busticket.model.ProfileCustomer;


public class ProfileCustomerService extends BaseService {

	public ProfileCustomerService()  {
		super();
	}
	public static ArrayList<ProfileCustomer> getAllProfileCustomer()
	{
		ArrayList<ProfileCustomer> arr = new ArrayList<ProfileCustomer>();
		String sql = "select * from profilecustomers";
		try {
			ResultSet rs = excuteQuery(sql);
			while(rs.next())
			{
				ProfileCustomer qsc = new ProfileCustomer();
				qsc.setId(rs.getInt(1));
				qsc.setCustomerName(rs.getString(2));
				qsc.setDateOfBirth(rs.getDate(3));
				qsc.setGender(rs.getString(4));
				qsc.setPhoneNumber(rs.getString(5));
				qsc.setShowProfile(rs.getBoolean(6));
				qsc.setCountry(rs.getString(7));
				qsc.setIdUser(rs.getInt(8));
				arr.add(qsc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public static boolean addProfileCustomer(ProfileCustomer pc)
	{
		String sql = "insert into profilecustomers(name,dateofbirth,gender,phonenumber,showprofile,country,userid) values (?,?,?,?,1,?,?)";
		List<Object> params = new ArrayList<>();
		params.add(pc.getCustomerName());
		params.add(pc.getDateOfBirth());
		params.add(pc.getGender());
		params.add(pc.getPhoneNumber());

		params.add(pc.getCountry());
		params.add(pc.getIdUser());
		try {
			return executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean updateProfileCustomer(ProfileCustomer pc)
	{
		String sql = "update profilecustomers set "
				+ "name = ?, "
				+ "dateofbirth = ?, "
				+ "gender = ?, "
				+ "phonenumber = ?, "
				+ "showprofile= ?, "
				+ "country=?, "
				+ "userid = ? "
				+ "where id = ?";

		List<Object> params = new ArrayList<>();
		params.add(pc.getCustomerName());
		params.add(pc.getDateOfBirth());
		params.add(pc.getGender());
		params.add(pc.getPhoneNumber());
		params.add(pc.isShowProfile());
		params.add(pc.getCountry());
		params.add(pc.getIdUser());
		params.add(pc.getId());
		try {
			return executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static ProfileCustomer getProfileByIdUser(int iduser) {
		String sql = "select * from profilecustomers where userid="+iduser+"";
		ProfileCustomer qsc = new ProfileCustomer();
		try {
			ResultSet rs = excuteQuery(sql);
			while(rs.next())
			{
				qsc.setId(rs.getInt(1));
				qsc.setCustomerName(rs.getString(2));
				qsc.setDateOfBirth(rs.getDate(3));
				qsc.setGender(rs.getString(4));
				qsc.setPhoneNumber(rs.getString(5));
				qsc.setShowProfile(rs.getBoolean(6));
				qsc.setCountry(rs.getString(7));
				qsc.setIdUser(rs.getInt(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qsc;		
	}
	
	public static int getIdCustomerByIdUser(int iduser) {
		int id = -1;
		String sql = "select id from profilecustomers where userid = ?";
		List<Object> param = new ArrayList<>();
		param.add(iduser);
		try {
			ResultSet rs = excuteQuery(sql, param);
			while (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;
	}
	public static ProfileCustomer getCustomerById(int id) {
		String sql = "select * from profilecustomers where id = ?";
		List<Object> param = new ArrayList<>();
		param.add(id);
		ProfileCustomer qsc = new ProfileCustomer();
		
		try {
			ResultSet rs = excuteQuery(sql, param);
			while (rs.next()) {
				qsc.setId(rs.getInt(1));
				qsc.setCustomerName(rs.getString(2));
				qsc.setDateOfBirth(rs.getDate(3));
				qsc.setGender(rs.getString(4));
				qsc.setPhoneNumber(rs.getString(5));
				int showProfile = rs.getInt(6);
				if (showProfile == 1) {
					qsc.setShowProfile(true);
				} else qsc.setShowProfile(false);
				qsc.setCountry(rs.getString(7));
				qsc.setIdUser(rs.getInt(8));
				return qsc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qsc;
	}
	
	public static String getEmailById(int id) {
		String sql = "SELECT email FROM `profilecustomers` p inner join `users` u on userid = u.id WHERE p.id = ? ";
		List<Object> param = new ArrayList<>();
		param.add(id);
		String qsc = new String();
		try {
			ResultSet rs = excuteQuery(sql, param);
			while (rs.next()) {
				qsc = rs.getString(1);
				return qsc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qsc;
	}
	
	public static ArrayList<ProfileCustomer> getAllProfileCustomerShowed()
	{
		ArrayList<ProfileCustomer> arr = new ArrayList<ProfileCustomer>();
		String sql = "select * from profilecustomers where showprofile = 1";
		try {
			ResultSet rs = excuteQuery(sql);
			while(rs.next())
			{
				ProfileCustomer qsc = new ProfileCustomer();
				qsc.setId(rs.getInt(1));
				qsc.setCustomerName(rs.getString(2));
				qsc.setDateOfBirth(rs.getDate(3));
				qsc.setGender(rs.getString(4));
				qsc.setPhoneNumber(rs.getString(5));
				qsc.setShowProfile(rs.getBoolean(6));
				qsc.setCountry(rs.getString(7));
				qsc.setIdUser(rs.getInt(8));
				arr.add(qsc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
} 


