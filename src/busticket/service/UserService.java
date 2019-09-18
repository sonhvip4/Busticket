package busticket.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import busticket.model.ProfileManager;
import busticket.model.User;

public class UserService extends BaseService {
	
	public UserService() {
		super();
	}

	public static ArrayList<User> getAllUser(){
		ArrayList<User> arr = new ArrayList<User>();
		String sql = "select * from users";
		try {
			ResultSet rs = excuteQuery(sql);
			while (rs.next()) {
				User qsc = new User();
				qsc.setId(rs.getInt(1));
				qsc.setUserName(rs.getString(2));
				qsc.setEmail(rs.getString(3));
				qsc.setPassword(rs.getString(4));
				qsc.setActived(rs.getBoolean(5));
				qsc.setIdRoleUser(rs.getInt(6));				
				arr.add(qsc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public static User findAccount(String name,String password){
		List<Object> params = new ArrayList<>();
		String sql = "Select * from users where username = ? and password = ?";
		params.add(name);
		params.add(password);
		try {
			ResultSet rs = excuteQuery(sql, params);
			while (rs.next()) {
				User qsc = new User(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getBoolean(5),
						rs.getInt(6));				
				return qsc;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static ArrayList<User> getUserByUsername(String name){
		List<Object> params = new ArrayList<>();
		String sql = "Select * from users where username = ?";
		params.add(name);
		try {
			ResultSet rs = excuteQuery(sql, params);
			ArrayList<User> arr = new ArrayList<User>();
			while (rs.next()) {
				User qsc = new User();
				qsc.setId(rs.getInt(1));
				qsc.setUserName(rs.getString(2));
				qsc.setEmail(rs.getString(3));
				qsc.setPassword(rs.getString(4));
				qsc.setActived(rs.getBoolean(5));
				qsc.setIdRoleUser(rs.getInt(6));				
				arr.add(qsc);
			}
			return arr;
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return null;
	}
	
	public static ArrayList<User> getUserByEmail(String email)
	{
		List<Object> params = new ArrayList<>();
		String sql = "Select * from users where email = ?";
		params.add(email);
		try {
			ResultSet rs = excuteQuery(sql, params);
			ArrayList<User> arr = new ArrayList<User>();
			while (rs.next()) {
				User qsc = new User();
				qsc.setId(rs.getInt(1));
				qsc.setUserName(rs.getString(2));
				qsc.setEmail(rs.getString(3));
				qsc.setPassword(rs.getString(4));
				qsc.setActived(rs.getBoolean(5));
				qsc.setIdRoleUser(rs.getInt(6));				
				arr.add(qsc);
			}
			return arr;
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return null;
	}
	
	public static int getIdByUserName(String userName) {
		int id = -1;
		String sql = "select id from users where username=?";
		List<Object> param = new ArrayList<>();
		param.add(userName);
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
	
	public static boolean addUser(User user)
	{
		String sql = "insert into users(username,email,password,active,roleuserid) values (?,?,?,b'1',?)";
		List<Object> params = new ArrayList<>();
		params.add(user.getUserName());
		params.add(user.getEmail());
		params.add(user.getPassword());
		params.add(user.getIdRoleUser());
		try {
			return executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean updateUser(User user)
	{
		String sql = "update users set "
				+ "username = ?, "
				+ "email = ?, "
				+ "password = ?, "
				+ "active = ?, "
				+ "roleuserid = ? "
				+ "where id = ?";
		List<Object> params = new ArrayList<>();
		params.add(user.getUserName());
		params.add(user.getEmail());
		params.add(user.getPassword());
		params.add(user.isActived());
		params.add(user.getIdRoleUser());
		params.add(user.getId());
		try {
			return executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static User getUserbyID(int id) {
		List<Object> params = new ArrayList<>();
		String sql = "Select * from users where id = ?";
		params.add(id);
		try {
			ResultSet rs = excuteQuery(sql, params);
			while (rs.next()) {
				User qsc = new User();
				qsc.setId(rs.getInt(1));
				qsc.setUserName(rs.getString(2));
				qsc.setEmail(rs.getString(3));
				qsc.setPassword(rs.getString(4));
				qsc.setActived(rs.getBoolean(5));
				qsc.setIdRoleUser(rs.getInt(6));		
				return qsc;
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return null;
	}
	public static void main(String[] args) {
		final String alphabet = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    final int N = alphabet.length();
	    Random r = new Random();
	    char[] c =  new char[5];
	    for (int i = 0; i < 5; i++) {
	        c[i]=alphabet.charAt(r.nextInt(N));  
	    }
	    String s= String.copyValueOf(c);
	    System.out.println(s);

	}
}
