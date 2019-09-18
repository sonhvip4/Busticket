package busticket.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import busticket.model.RoleUser;

public class RoleUserService extends BaseService {
	
	public RoleUserService() {
		super();
	}

	public static ArrayList<RoleUser> getAllRoleuser() {
		ArrayList<RoleUser> arr = new ArrayList<RoleUser>();
		String sql = "select * from roleusers";
		try {
			ResultSet rs = excuteQuery(sql);
			while (rs.next()) {
				RoleUser ru = new RoleUser();
				ru.setId(rs.getInt(1));
				ru.setRoleName(rs.getString(2));
				arr.add(ru);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	public static ArrayList<RoleUser> getRoleUserById(int id) {
		List<Object> params = new ArrayList<>();
		String sql = "Select * from roleusers where id = ?";
		params.add(id);
		try {
			ResultSet rs = excuteQuery(sql, params);
			ArrayList<RoleUser> arr = new ArrayList<RoleUser>();
			while (rs.next()) {
				RoleUser qsc = new RoleUser();
				qsc.setId(rs.getInt(1));
				qsc.setRoleName(rs.getString(2));
				arr.add(qsc);
			}
			return arr;
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return null;
	}

	public static ArrayList<RoleUser> getRoleUserByName(String name) {
		List<Object> params = new ArrayList<>();
		String sql = "Select * from roleusers where rolename = ?";
		params.add(name);
		try {
			ResultSet rs = excuteQuery(sql, params);
			ArrayList<RoleUser> arr = new ArrayList<RoleUser>();
			while (rs.next()) {
				RoleUser qsc = new RoleUser();
				qsc.setId(rs.getInt(1));
				qsc.setRoleName(rs.getString(2));
				arr.add(qsc);
			}
			return arr;
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return null;
	}

	public static int getIdRoleuser(String roleUserName) {
		int id = -1;
		String sql = "select id from roleusers where roleName=?";
		List<Object> param = new ArrayList<>();
		param.add(roleUserName);
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

	public static String getNameRoleuser(int id_Roleuser) {
		String Name = null;
		String sql = "select roleName  from roleusers where id=?";
		List<Object> param = new ArrayList<>();
		param.add(id_Roleuser);
		try {
			ResultSet rs = excuteQuery(sql, param);
			while (rs.next()) {
				Name = rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return Name;
	}
}
