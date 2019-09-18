package busticket.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Bill {
	private String id;
	private int idTicket;
	private int idCustomer;
	private Timestamp bookingdate;
	private boolean status;
	private Ticket ticketObject;
	private ProfileCustomer customerObject;

	public Bill() {
		super();
	}

	public Bill(int idTicket, int idCustomer, Timestamp bookingdate) {
		super();
		this.idTicket = idTicket;
		this.idCustomer = idCustomer;
		this.bookingdate = bookingdate;
	}

	public Bill(String id, int idTicket, int idCustomer, Timestamp bookingdate) {
		super();
		this.id = id;
		this.idTicket = idTicket;
		this.idCustomer = idCustomer;
		this.bookingdate = bookingdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Timestamp getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(Timestamp bookingdate) {
		this.bookingdate = bookingdate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Ticket getTicketObject() {
		return ticketObject;
	}

	public void setTicketObject(Ticket ticketObject) {
		this.ticketObject = ticketObject;
	}

	public ProfileCustomer getCustomerObject() {
		return customerObject;
	}

	public void setCustomerObject(ProfileCustomer customerObject) {
		this.customerObject = customerObject;
	}
}
