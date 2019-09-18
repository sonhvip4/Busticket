/*
	@author:Quang Truong
	@date: Aug 16, 2019
*/

package busticket.service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import busticket.model.Car;
import busticket.model.Route;
import busticket.model.Session;

public class SessionService extends BaseService {
	
	public static boolean UpdateRouteDaily() {
		long millis=System.currentTimeMillis(); 
		millis+=10*24*60*60*1000;
	    Date date=new java.sql.Date(millis);
	    String sql1="Select * from sessions where departdate='"+date+"'";
	    try {
			ResultSet rs= excuteQuery(sql1);
			if(rs.next()==false) {
				String sql2="INSERT INTO sessions (ticketnumber, carid, routeid, departdate) VALUES (0, 1, 1, ?),(0, 2, 2, ?),(0, 2, 3, ?),(0, 1, 4, ?),(0, 4, 5, ?),(0, 1, 6, ?),(0, 3, 7, ?),(0, 3, 8, ?),(0, 4, 9, ?),(0, 5, 10, ?),(0, 1, 11, ?),(0, 2, 12, ?),(0, 1, 13, ?),(0, 5, 14, ?),(0, 6, 15, ?),(0, 3, 16, ?),(0, 4, 17, ?),(0, 8, 18, ?),(0, 9, 19, ?),(0, 10, 20, ?),(0, 8, 21, ?),(0, 7, 22, ?);";
				List<Object> params = new ArrayList<>();
				for(int i=0;i<22;i++) {
					params.add(date);
				}
				executeUpdate(sql2, params);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return false;
	}
	
	public static ArrayList<Session> getAllSession(){
		ArrayList<Session> arr = new ArrayList<Session>();
		String sql = "select * from sessions";
		try {
			ResultSet rs = excuteQuery(sql);
			while (rs.next()) {
				Session qsc = new Session();
				qsc.setId(rs.getInt(1));
				qsc.setTicketNumber(rs.getInt(2));
				qsc.setIdCar(rs.getInt(3));
				qsc.setIdRoute(rs.getInt(4));
				qsc.setDepartDate(rs.getDate(5));
				Car car = CarService.getCarById(qsc.getIdCar());
				if(car != null) {
					qsc.setCarObject(car);
				}
				Route route = RouteService.getRouteById(qsc.getIdRoute());
				if(route != null)
				{
					qsc.setRouteObject(route);
				}
				
				arr.add(qsc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public static int getIdSessionByIdRouteAndIdCar(int idRoute,int idCar) {
		int id = -1;
		String sql = "select id from sessions where routeid = ? and carid = ?";
		List<Object> param = new ArrayList<>();
		param.add(idRoute);
		param.add(idCar);
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
	
	public static Session getSessionById(int sessionid){
		String sql = "select * from sessions where id = ?";
		List<Object> params = new ArrayList<>();
		params.add(sessionid);
		try {
			ResultSet rs = excuteQuery(sql,params);
			while (rs.next()) {
				Session qsc = new Session();
				qsc.setId(rs.getInt(1));
				qsc.setTicketNumber(rs.getInt(2));
				qsc.setIdCar(rs.getInt(3));
				qsc.setIdRoute(rs.getInt(4));
				qsc.setDepartDate(rs.getDate(5));
				Car car = CarService.getCarById(qsc.getIdCar());
				if(car != null) {
					qsc.setCarObject(car);
				}
				Route route = RouteService.getRouteById(qsc.getIdRoute());
				if(route != null)
				{
					qsc.setRouteObject(route);
				}
				
				return qsc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Integer> getRouteIdByDepartDate(Date date) {
		ArrayList<Integer> list_route= new ArrayList<Integer>();
		String sql = "select routeid from sessions where departdate = ?";
		List<Object> params = new ArrayList<>();
		params.add(date);
		try {
			ResultSet rs = excuteQuery(sql, params);
			while (rs.next()) {
				list_route.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list_route;
	}
	
	public static int getCountBill(int routeId,int customerId) {
		int count = 0;
		String sql = "select count(b.id) from bills b inner join ticket t on b.id = t.billid inner join sessions s on s.id = t.sessionid where s.routeid = ? and b.cusid = ? and t.status='occupied'";
		List<Object> params = new ArrayList<>();
		params.add(routeId);
		params.add(customerId);
		try {
			ResultSet rs = excuteQuery(sql, params);
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return count;
	}
	
	
	public static ArrayList<Session> getAllSessionNotExpired(){
		ArrayList<Session> arr = new ArrayList<Session>();
		String sql = "SELECT * FROM sessions s INNER JOIN routes r on routeid = r.id WHERE (timestarting > UTC_TIME and departdate = UTC_DATE) or (departdate > UTC_DATE);";
		try {
			ResultSet rs = excuteQuery(sql);
			while (rs.next()) {
				Session qsc = new Session();
				qsc.setId(rs.getInt(1));
				qsc.setTicketNumber(rs.getInt(2));
				qsc.setIdCar(rs.getInt(3));
				qsc.setIdRoute(rs.getInt(4));
				qsc.setDepartDate(rs.getDate(5));
				Car car = CarService.getCarById(qsc.getIdCar());
				if(car != null) {
					qsc.setCarObject(car);
				}
				Route route = RouteService.getRouteById(qsc.getIdRoute());
				if(route != null)
				{
					qsc.setRouteObject(route);
				}
				
				arr.add(qsc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
		
	}
	public static ArrayList<Session> getAllSessionNotExpiredWithWhere(String startingPoint, String destination, Date departDate,Time timeStarting  ){
		ArrayList<Session> arr = getAllSessionNotExpired();
		ArrayList<Session> newarr = new ArrayList<Session>();
		for(Session session:arr) {
			if(startingPoint!=null) {
				if(!startingPoint.equals(session.getRouteObject().getStartingPoint())) {
					continue;
				}
			}
			if(destination!=null) {
				if(!destination.equals(session.getRouteObject().getDestination())) {
					continue;
				}
			}
			if(departDate!=null) {
				if(departDate.getTime()!=session.getDepartDate().getTime()) {
					continue;
				}
			}
			if(timeStarting!=null) {
				if(timeStarting.getTime()!=session.getRouteObject().getTimeStarting().getTime()) {
					continue;
				}
			}
			newarr.add(session);
		}
		return newarr;
	}
}


