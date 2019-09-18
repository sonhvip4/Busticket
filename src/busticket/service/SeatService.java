package busticket.service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import busticket.dto.SeatDetail;
import busticket.model.Seat;

public class SeatService extends BaseService {

	public SeatService() {
		super();
	}

	public static ArrayList<Seat> getAllSeat() {
		ArrayList<Seat> arr = new ArrayList<Seat>();
		String sql = "select * from seat";
		try {
			ResultSet rs = excuteQuery(sql);
			while (rs.next()) {
				Seat qsc = new Seat();
				qsc.setId(rs.getInt(1));
				qsc.setSeatName(rs.getInt(2));
				qsc.setIdCar(rs.getInt(3));
				arr.add(qsc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public static ArrayList<Seat> getAllSeatByIdCar(int idcar) {
		ArrayList<Seat> arr = new ArrayList<Seat>();
		String sql = "select * from seat where carid = ?";
		List<Object> params = new ArrayList<>();
		params.add(idcar);
		try {
			ResultSet rs = excuteQuery(sql,params);
			while (rs.next()) {
				Seat qsc = new Seat();
				qsc.setId(rs.getInt(1));
				qsc.setSeatName(rs.getInt(2));
				qsc.setIdCar(rs.getInt(3));
				arr.add(qsc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public static Seat getSeatById(int idseat) {
		String sql = "select * from seat where id = ?";
		List<Object> params = new ArrayList<>();
		params.add(idseat);
		try {
			ResultSet rs = excuteQuery(sql,params);
			while (rs.next()) {
				Seat qsc = new Seat();
				qsc.setId(rs.getInt(1));
				qsc.setSeatName(rs.getInt(2));
				qsc.setIdCar(rs.getInt(3));
				return qsc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int getIdSeatByName(String nameSeat) {
		int id = -1;
		String sql = "select id from seat where name = ? ";
		List<Object> param = new ArrayList<>();
		param.add(nameSeat);
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

	public static boolean addSeat(Seat seat) {
		String sql = "insert into seat(name,carid) values (?,?)";
		List<Object> params = new ArrayList<>();
		params.add(seat.getSeatName());
		params.add(seat.getIdCar());
		try {
			return executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean updateSeat(Seat seat) {
		String sql = "update seat set " + "name = ?, " + "carid=? " + "where id = ?";

		List<Object> params = new ArrayList<>();
		params.add(seat.getSeatName());
		params.add(seat.getIdCar());
		params.add(seat.getId());
		try {
			return executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean deleteSeat(int id) {
		String query = "delete from seat where id = ?";

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
	
	
	public static ArrayList<SeatDetail> getIdSeatBooked(Date departdate,int routeid) {
		ArrayList<SeatDetail> arr = new ArrayList<SeatDetail>();
		String sql = "select seat.name from ticket left join sessions on ticket.sessionid = sessions.id right join seat on seat.id = ticket.seatid where sessions.departdate = ? and routeid = ? and ticket.status = 'occupied' group by seat.name";
		List<Object> param = new ArrayList<>();
		param.add(departdate);
		param.add(routeid);
		try {
			ResultSet rs = excuteQuery(sql, param);
			while (rs.next()) {
				{
					SeatDetail sd = new SeatDetail();
					sd.setNameSeat(rs.getInt(1));
					arr.add(sd);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return arr;
	}
	
}
