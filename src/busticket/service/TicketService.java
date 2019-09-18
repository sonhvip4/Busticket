package busticket.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import busticket.model.Bill;
import busticket.model.Seat;
import busticket.model.Session;
import busticket.model.Ticket;

public class TicketService extends BaseService {

	public TicketService() {
		super();
	}

	public static ArrayList<Ticket> getAllTicket() {
		ArrayList<Ticket> arr = new ArrayList<Ticket>();
		String sql = "select * from ticket";
		try {
			ResultSet rs = excuteQuery(sql);
			while (rs.next()) {
				Ticket qsc = new Ticket();
				qsc.setId(rs.getInt(1));
				qsc.setIdBill(rs.getString(2));
				qsc.setIdSeat(rs.getInt(3));
				qsc.setStatus(rs.getString(4));
				qsc.setIdSession(rs.getInt(5));
				arr.add(qsc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	public static Ticket getTicketById(int id) {
		String sql = "select * from ticket where id = ?";
		List<Object> params = new ArrayList<>();
		params.add(id);
		try {
			ResultSet rs = excuteQuery(sql, params);
			while (rs.next()) {
				Ticket qsc = new Ticket();
				qsc.setId(rs.getInt(1));
				qsc.setIdBill(rs.getString(2));
				qsc.setIdSeat(rs.getInt(3));
				qsc.setStatus(rs.getString(4));
				qsc.setIdSession(rs.getInt(5));
				Session session = SessionService.getSessionById(qsc.getIdSession());
				if (session != null) {
					qsc.setSessionObject(session);
				}
				Seat seat = SeatService.getSeatById(qsc.getIdSeat());
				if (seat != null) {
					qsc.setSeatObject(seat);
				}
				return qsc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int getIdTicketByIdSeatAndIdSession(int idSeat,int idSession) {
		int id = -1;
		String sql = "select id from ticket where seatid = ? and sessionid = ?";
		List<Object> param = new ArrayList<>();
		param.add(idSeat);
		param.add(idSession);
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

	public static boolean addTicket(Ticket ticket) {
		String sql = "insert into ticket(billid,seatid,status,sessionid) values (?,?,'occupied',?)";
		List<Object> params = new ArrayList<>();
		params.add(ticket.getIdBill());
		params.add(ticket.getIdSeat());
		params.add(ticket.getIdSession());
		try {
			return executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean updateNewTicket(String idBill, int idTicket) {
		String sql = "update ticket set " + "billid = ? " + "where id = ?";

		List<Object> params = new ArrayList<>();
		params.add(idBill);
		params.add(idTicket);
		try {
			return executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean updateStatusTicket(String idBill) {
		String sql = "update ticket set " + "status = 'available' " + "where billid = ?";

		List<Object> params = new ArrayList<>();
		params.add(idBill);
		try {
			return executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean deleteTicket(int id) {
		String query = "delete from ticket where id = ?";

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

	public static int countTicket() {
		String sql = "select count(id) from ticket";
		try {
			ResultSet rs = excuteQuery(sql);
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public static List<Ticket> getAllTicket(int firstResult, int amoutResult) {
		String query = "select * from ticket order by Id LIMIT ?,?";
		List<Object> param = new ArrayList<>();
		param.add(firstResult);
		param.add(amoutResult);
		List<Ticket> lstProfileTic = null;

		try {
			lstProfileTic = new ArrayList<>();
			ResultSet rs = excuteQuery(query, param);
			while (rs.next()) {
				Ticket qsc = new Ticket();
				qsc.setId(rs.getInt(1));
				qsc.setIdBill(rs.getString(2));
				qsc.setIdSeat(rs.getInt(3));
				qsc.setStatus(rs.getString(4));
				qsc.setIdSession(rs.getInt(5));
				lstProfileTic.add(qsc);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return lstProfileTic;
	}
	public static ArrayList<Ticket> getAllOccupiedTicketBySession(int idSession){
		ArrayList<Ticket> arr = new ArrayList<Ticket>();
		String sql = "SELECT * FROM ticket WHERE status = 'occupied' AND sessionid = ?";
		List<Object> param = new ArrayList<>();
		param.add(idSession);
		try {
			ResultSet rs = excuteQuery(sql,param);
			while (rs.next()) {
				Ticket qsc = new Ticket();
				qsc.setId(rs.getInt(1));
				qsc.setIdBill(rs.getString(2));
				qsc.setIdSeat(rs.getInt(3));
				qsc.setStatus(rs.getString(4));
				qsc.setIdSession(rs.getInt(5));
				Bill bill = BillService.getBillById(qsc.getIdBill());
				if (bill != null) {
					qsc.setBillObject(bill);
				}
				Seat seat = SeatService.getSeatById(qsc.getIdSeat());
				if (bill != null) {
					qsc.setSeatObject(seat);
				}
				arr.add(qsc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public static boolean delTicket(int id) {
		String sql = "update ticket set " + "status = 'available'"
				+ "where id = ?";

		List<Object> params = new ArrayList<>();
		params.add(id);
		try {
			boolean x = executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}


