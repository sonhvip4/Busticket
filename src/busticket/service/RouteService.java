package busticket.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import busticket.model.Car;
import busticket.model.Route;

public class RouteService extends BaseService {

	public RouteService() {
		super();
	}
	public static ArrayList<Route> getAllRoute(){
		ArrayList<Route> arr = new ArrayList<Route>();
		String sql = "select * from route";
		try {
			ResultSet rs = excuteQuery(sql);
			while (rs.next()) {
				Route qsc = new Route();
				qsc.setId(rs.getInt(1));
				qsc.setStartingPoint(rs.getString(2));
				qsc.setDestination(rs.getString(3));
				qsc.setTimeStarting(rs.getTime(4));
				qsc.setTimeFinishing(rs.getTime(5));
				qsc.setPrice(rs.getInt(6));
				qsc.setIdCar(rs.getInt(7));
				arr.add(qsc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public static ArrayList<Route> getAllRouteById(int id){
		ArrayList<Route> arr = new ArrayList<Route>();
		String sql = "select * from route where id = ?";
		List<Object> params = new ArrayList<>();
		params.add(id);
		try {
			ResultSet rs = excuteQuery(sql,params);
			while (rs.next()) {
				Route qsc = new Route();
				qsc.setId(rs.getInt(1));
				qsc.setStartingPoint(rs.getString(2));
				qsc.setDestination(rs.getString(3));
				qsc.setTimeStarting(rs.getTime(4));
				qsc.setTimeFinishing(rs.getTime(5));
				qsc.setPrice(rs.getInt(6));
				qsc.setIdCar(rs.getInt(7));
				Car car = CarService.getCarById(qsc.getIdCar());
				if(car != null) {
					qsc.setCarObject(car);
				}
				arr.add(qsc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public static Route getRouteById(int routeid) {
		String sql = "select * from routes where id = ?";
		List<Object> params = new ArrayList<>();
		params.add(routeid);
		try {
			ResultSet rs = excuteQuery(sql,params);
			while (rs.next()) {
				Route qsc = new Route();
				qsc.setId(rs.getInt(1));
				qsc.setStartingPoint(rs.getString(2));
				qsc.setDestination(rs.getString(3));
				qsc.setTimeStarting(rs.getTime(4));
				qsc.setTimeFinishing(rs.getTime(5));
				qsc.setPrice(rs.getInt(6));
				qsc.setIdCar(rs.getInt(7));
				return qsc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static ArrayList<Route> FindRoute(String startingpoint,String destination){
		ArrayList<Route> arr = new ArrayList<Route>();
		String sql = "select * from routes where startingpoint = ? and destination = ?";
		List<Object> params = new ArrayList<>();
		params.add(startingpoint);
		params.add(destination);
		try {
			ResultSet rs = excuteQuery(sql,params);
			while (rs.next()) {
				Route qsc = new Route();
				qsc.setId(rs.getInt(1));
				qsc.setStartingPoint(rs.getString(2));
				qsc.setDestination(rs.getString(3));
				qsc.setTimeStarting(rs.getTime(4));
				qsc.setTimeFinishing(rs.getTime(5));
				qsc.setPrice(rs.getInt(6));
				qsc.setIdCar(rs.getInt(7));
				arr.add(qsc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public static Route FindRouteObject(Route route){
		String sql = "select * from routes where startingpoint = ? and destination = ? and timestarting = ? and timeexpecting = ?";
		List<Object> params = new ArrayList<>();
		params.add(route.getStartingPoint());
		params.add(route.getDestination());
		params.add(route.getTimeStarting());
		params.add(route.getTimeFinishing());
		try {
			ResultSet rs = excuteQuery(sql,params);
			while (rs.next()) {
				Route qsc = new Route();
				qsc.setId(rs.getInt(1));
				qsc.setStartingPoint(rs.getString(2));
				qsc.setDestination(rs.getString(3));
				qsc.setTimeStarting(rs.getTime(4));
				qsc.setTimeFinishing(rs.getTime(5));
				qsc.setPrice(rs.getInt(6));
				qsc.setIdCar(rs.getInt(7));
				return qsc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int getRouteIdFromChoosed(Route route) {
		int id = -1;
		String sql = "select id from routes where startingpoint = ? and destination = ? and timestarting = ? and timeexpecting = ?";
		List<Object> params = new ArrayList<>();
		params.add(route.getStartingPoint());
		params.add(route.getDestination());
		params.add(route.getTimeStarting());
		params.add(route.getTimeFinishing());
		try {
			ResultSet rs = excuteQuery(sql,params);
			while (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public static int getCarIdByRouteId(int idroute) {
		int id = -1;
		String sql = "select carid from routes where id = ?";
		List<Object> params = new ArrayList<>();
		params.add(idroute);
		try {
			ResultSet rs = excuteQuery(sql,params);
			while (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public static boolean addRoute(Route route)
	{
		String sql = "insert into routes(startingpoint,destination,timestarting,timeexpecting,price,carid) values (?,?,?,?,?,?)";
		List<Object> params = new ArrayList<>();
		params.add(route.getStartingPoint());
		params.add(route.getDestination());
		params.add(route.getTimeStarting());
		params.add(route.getTimeFinishing());
		params.add(route.getPrice());
		params.add(route.getIdCar());
		try {
			return executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean updateRoute(Route route)
	{
		String sql = "update routes set " 
					+ "startingpoint = ?, " 
					+ "destination = ?, "
					+ "timestarting = ?, "
					+ "timeexpecting = ?, "
					+ "price = ?,"
					+ "carid = ? " 
					+ "where id = ?";

		List<Object> params = new ArrayList<>();
		params.add(route.getStartingPoint());
		params.add(route.getDestination());
		params.add(route.getTimeStarting());
		params.add(route.getTimeFinishing());
		params.add(route.getPrice());
		params.add(route.getIdCar());
		params.add(route.getId());
		try {
			return executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean deleteRoute(int id)
	{
		String query = "delete from routes where id = ?";

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
	public static ArrayList<String> getAllStartingTime(){
		String sql = "select timestarting from routes group by timestarting";
		ArrayList<String> arr = new ArrayList<String>();
		try {
			ResultSet rs = excuteQuery(sql);
			while (rs.next()) {
				String qsc = new String();
				qsc = rs.getTime(1).toString();
				arr.add(qsc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	
}
