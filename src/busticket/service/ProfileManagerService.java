package busticket.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import busticket.model.ProfileManager;

public class ProfileManagerService extends BaseService {
	
	public ProfileManagerService() {
		super();
	}

	public static ArrayList<ProfileManager> getAllProfileManager()
	{
		ArrayList<ProfileManager> arr = new ArrayList<ProfileManager>();
		String sql = "select * from profilemanagers";
		try {
			ResultSet rs = excuteQuery(sql);
			while(rs.next())
			{
				ProfileManager qsc = new ProfileManager();
				qsc.setId(rs.getInt(1));
				qsc.setManagerName(rs.getString(2));
				qsc.setDateOfBirth(rs.getDate(3));
				qsc.setGender(rs.getString(4));
				qsc.setPhoneNumber(rs.getString(5));
				qsc.setShowProfile(rs.getBoolean(6));
				qsc.setIdUser(rs.getInt(7));
				arr.add(qsc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public static boolean addProfileManager(ProfileManager pm)
	{
		String sql = "insert into profilemanagers(name,dateofbirth,gender,phonenumber,showprofile,userid) values (?,?,?,?,1,?)";
		List<Object> params = new ArrayList<>();
		params.add(pm.getManagerName());
		params.add(pm.getDateOfBirth());
		params.add(pm.getGender());
		params.add(pm.getPhoneNumber());
		params.add(pm.getIdUser());
		try {
			return executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean updateProfileManager(ProfileManager pm)
	{
		String sql = "update profilemanagers set "
				+ "name = ?, "
				+ "dateofbirth = ?, "
				+ "gender = ?, "
				+ "phonenumber = ?, "
				+ "showprofile= ?, "
				+ "userid = ? "
				+ "where id = ?";

		List<Object> params = new ArrayList<>();
		params.add(pm.getManagerName());
		params.add(pm.getDateOfBirth());
		params.add(pm.getGender());
		params.add(pm.getPhoneNumber());
		params.add(pm.isShowProfile());
		params.add(pm.getIdUser());
		params.add(pm.getId());
		try {
			return executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static ProfileManager getProfileManager(int id) {
		String sql="select * from profilemanagers where userid="+id+"";
		ProfileManager qsc = new ProfileManager();
		try {
			ResultSet rs = excuteQuery(sql);
			while(rs.next())
			{
				qsc.setId(rs.getInt(1));
				qsc.setManagerName(rs.getString(2));
				qsc.setDateOfBirth(rs.getDate(3));
				qsc.setGender(rs.getString(4));
				qsc.setPhoneNumber(rs.getString(5));
				qsc.setShowProfile(rs.getBoolean(6));
				qsc.setIdUser(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qsc;
	}
	public static void main(String[] args) {
		ProfileManager pm = ProfileManagerService.getProfileManager(1);
		System.out.println(pm.getPhoneNumber());	
	}
}
