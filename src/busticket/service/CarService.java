package busticket.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import busticket.model.Car;

public class CarService extends BaseService {

	public CarService() {
		super();
	}

	public static ArrayList<Car> getAllCar() {
		ArrayList<Car> arr = new ArrayList<Car>();
		String sql = "select * from cars";
		try {
			ResultSet rs = excuteQuery(sql);
			while (rs.next()) {
				Car qsc = new Car();
				qsc.setId(rs.getInt(1));
				qsc.setCarName(rs.getString(2));
				arr.add(qsc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public static Car getCarById(int carid) {
		String sql = "select * from cars where id = ?";
		List<Object> params = new ArrayList<>();
		params.add(carid);
		try {
			ResultSet rs = excuteQuery(sql,params);
			while (rs.next()) {
				Car qsc = new Car();
				qsc.setId(rs.getInt(1));
				qsc.setCarName(rs.getString(2));
				return qsc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean addCar(Car car) {
		String sql = "insert into cars(name) values (?)";
		List<Object> params = new ArrayList<>();
		params.add(car.getCarName());
		try {
			return executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean updateCar(Car car) {
		String sql = "update cars set " + "name = ?, " + "where id = ?";

		List<Object> params = new ArrayList<>();
		params.add(car.getCarName());
		params.add(car.getId());
		try {
			return executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean deleteCar(int id) {
		String query = "delete from cars where id = ?";

		List<Object> params = new ArrayList<>();
		params.add(id);
		try {
			boolean action = executeUpdate(query, params);
			return action;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static String getCarNameById(int id) {
		String name = null;
		String sql = "select name from cars where id= ?";
		List<Object> param = new ArrayList<>();
		param.add(id);
		try {
			ResultSet rs = excuteQuery(sql, param);
			while (rs.next()) {
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return name;
	}
}
