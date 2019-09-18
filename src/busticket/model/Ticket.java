package busticket.model;

public class Ticket {
	private int id;
	private String idBill;
	private int idSeat;
	private String status;
	private int idSession;
	private Session sessionObject;
	private Seat seatObject;
	private Bill billObject;

	


	public Ticket() {
		super();
	}

	public Ticket(String idBill, int idSeat, String status, int idSession) {
		super();
		this.idBill = idBill;
		this.idSeat = idSeat;
		this.status = status;
		this.idSession = idSession;
	}
	
	public Ticket(String idBill, int idSeat,int idSession) {
		super();
		this.idBill = idBill;
		this.idSeat = idSeat;
		this.idSession = idSession;
	}

	public Ticket(int id, String idBill, int idSeat, String status, int idSession) {
		super();
		this.id = id;
		this.idBill = idBill;
		this.idSeat = idSeat;
		this.status = status;
		this.idSession = idSession;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdBill() {
		return idBill;
	}

	public void setIdBill(String idBill) {
		this.idBill = idBill;
	}

	public int getIdSeat() {
		return idSeat;
	}

	public void setIdSeat(int idSeat) {
		this.idSeat = idSeat;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getIdSession() {
		return idSession;
	}

	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}

	public Session getSessionObject() {
		return sessionObject;
	}

	public void setSessionObject(Session sessionObject) {
		this.sessionObject = sessionObject;
	}

	public Seat getSeatObject() {
		return seatObject;
	}

	public void setSeatObject(Seat seatObject) {
		this.seatObject = seatObject;
	}
	public Bill getBillObject() {
		return billObject;
	}

	public void setBillObject(Bill billObject) {
		this.billObject = billObject;
	}
}
