package busticket.service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import busticket.model.Bill;
import busticket.model.ProfileCustomer;
import busticket.model.Ticket;
import busticket.model.User;

public class BillService extends BaseService {

	public BillService() {
		super();
	}

	public static ArrayList<Bill> getAllBill() {
		ArrayList<Bill> arr = new ArrayList<Bill>();
		String sql = "select * from bills ";
		try {
			ResultSet rs = excuteQuery(sql);
			while (rs.next()) {
				Bill qsc = new Bill();
				qsc.setId(rs.getString(1));
				qsc.setIdTicket(rs.getInt(2));
				qsc.setIdCustomer(rs.getInt(3));
				Ticket ticket = TicketService.getTicketById(qsc.getIdTicket());
				if (ticket != null) {
					qsc.setTicketObject(ticket);
				}
				qsc.setBookingdate(rs.getTimestamp(4));
				qsc.setStatus(rs.getBoolean(5));
				arr.add(qsc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public static ArrayList<Bill> getAllBillByIdCustomerAndStatus(int idCus) {
		ArrayList<Bill> arr = new ArrayList<Bill>();
		String sql = "select * from bills where status = b'1' and cusid = ? order by bookingdate desc";
		List<Object> params = new ArrayList<>();
		params.add(idCus);
		try {
			ResultSet rs = excuteQuery(sql,params);
			while (rs.next()) {
				Bill qsc = new Bill();
				qsc.setId(rs.getString(1));
				qsc.setIdTicket(rs.getInt(2));
				qsc.setIdCustomer(rs.getInt(3));
				Ticket ticket = TicketService.getTicketById(qsc.getIdTicket());
				if (ticket != null) {
					qsc.setTicketObject(ticket);
				}
				qsc.setBookingdate(rs.getTimestamp(4));
				qsc.setStatus(rs.getBoolean(5));
				arr.add(qsc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	public static ArrayList<Bill> getAllBillByIdTicket(int idticket) {
		ArrayList<Bill> arr = new ArrayList<Bill>();
		String sql = "select * from bills where ticketid = ?";
		List<Object> params = new ArrayList<>();
		params.add(idticket);
		try {
			ResultSet rs = excuteQuery(sql, params);
			while (rs.next()) {
				Bill qsc = new Bill();
				qsc.setId(rs.getString(1));
				qsc.setIdTicket(rs.getInt(2));
				qsc.setIdCustomer(rs.getInt(3));
				qsc.setBookingdate(rs.getTimestamp(4));
				qsc.setStatus(rs.getBoolean(5));
				arr.add(qsc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	public static boolean addBill(Bill bill) {
		String sql = "insert into bills(id,ticketid,cusid,bookingdate,status) values (?,?,?,?,b'1')";
		List<Object> params = new ArrayList<>();
		params.add(bill.getId());
		params.add(bill.getIdTicket());
		params.add(bill.getIdCustomer());
		params.add(bill.getBookingdate());

		try {
			return executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static String getIdByIdTicket(int idticket) {
		String id = "";
		String sql = "select id from bills where ticketid = ?";
		List<Object> param = new ArrayList<>();
		param.add(idticket);
		try {
			ResultSet rs = excuteQuery(sql, param);
			while (rs.next()) {
				id = rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;
	}

	public static boolean updateBill(Bill bill) {
		String sql = "update bills set " + "ticketid = ?, " + "cusid = ?, " + "bookingdate = ?," + "status = b'?' " + "where id = ?";

		List<Object> params = new ArrayList<>();
		params.add(bill.getIdTicket());
		params.add(bill.getIdCustomer());
		params.add(bill.getBookingdate());
		params.add(bill.isStatus());
		params.add(bill.getId());
		try {
			return executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean CancelBill(String idbill) {
		String sql = "update bills set status = b'0' where id = ?";

		List<Object> params = new ArrayList<>();
		params.add(idbill);
		try {
			return executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean deleteBill(String id) {
		String query = "delete from bills where id = ?";

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
	public static Bill getBillById(String idbill) {
		String sql = "select * from bills where id = ?";
		List<Object> params = new ArrayList<>();
		params.add(idbill);

		Bill qsc = new Bill();
		try {
			ResultSet rs = excuteQuery(sql, params);
			while (rs.next()) {
				qsc.setId(rs.getString(1));
				qsc.setIdTicket(rs.getInt(2));
				qsc.setIdCustomer(rs.getInt(3));
				qsc.setBookingdate(rs.getTimestamp(4));
				qsc.setStatus(rs.getBoolean(5));
				
				Ticket ticket = TicketService.getTicketById(qsc.getIdTicket());
				if (ticket != null) {
					qsc.setTicketObject(ticket);
				}
				
				ProfileCustomer cus = ProfileCustomerService.getCustomerById(qsc.getIdCustomer());
				if (cus != null) {
					qsc.setCustomerObject(cus);
				}
				return qsc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qsc;
	}
	
	public static boolean delBill(Bill bill) {
		String sql = "update bills set "  + "status = ?" + "where id = ?";

		List<Object> params = new ArrayList<>();
		if (bill.isStatus()) {
			params.add(1);
		} else params.add(0);
		
		params.add(bill.getId());
		try {
			return executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static Timestamp getDateBookingById(String id)
	{
		Timestamp dateBooking=null;
		String sql="select bookingdate from bills where id=?";
		List<Object> params = new ArrayList<>();
		params.add(id);
		try {
			ResultSet rs = excuteQuery(sql, params);
			while(rs.next()) {
				dateBooking= rs.getTimestamp(1);
			}
			return dateBooking;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dateBooking;
	}
}


