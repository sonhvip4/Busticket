package busticket.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import busticket.model.Province;;

public class ProvinceService extends BaseService {

	public ProvinceService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static ArrayList<Province> getAllProvince() {
		ArrayList<Province> arr = new ArrayList<Province>();
	
		String sql = "SELECT * FROM busticket.provinces";
		try {
			
			ResultSet rs = excuteQuery(sql);
			while (rs.next()) {
				Province pr = new Province();
				pr.setId(rs.getInt("id"));
				 pr.setName(rs.getString("name")); 
				arr.add(pr);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return arr;
	}
	public static ArrayList<Province> getAllStartingPoint(){
		ArrayList<Province> arr = new ArrayList<Province>();
		String sql = "select provinces.id, provinces.name from provinces RIGHT join routes on provinces.name = routes.startingpoint GROUP BY provinces.id, provinces.name";
		try {
			ResultSet rs = excuteQuery(sql);
			while (rs.next()) {
				Province qsc = new Province();
				qsc.setId(rs.getInt(1));
				qsc.setName(rs.getString(2));
				arr.add(qsc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public static ArrayList<Province> getAllDestination(){
		ArrayList<Province> arr = new ArrayList<Province>();
		String sql = "select provinces.id, provinces.name from provinces RIGHT join routes on provinces.name = routes.destination GROUP BY provinces.id, provinces.name";
		try {
			ResultSet rs = excuteQuery(sql);
			while (rs.next()) {
				Province qsc = new Province();
				qsc.setId(rs.getInt(1));
				qsc.setName(rs.getString(2));
				arr.add(qsc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
}


