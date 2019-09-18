package busticket.dto;

public class BillDetail {

	private String idBill;
	private int idTicket;
	private int idCustomer;
	private int idSeat;
	private int idSession;
	private int idRoute;
	private String status;
	public BillDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BillDetail(String idBill, int idTicket, int idCustomer, int idSeat, int idSession, int idRoute,
			String status) {
		super();
		this.idBill = idBill;
		this.idTicket = idTicket;
		this.idCustomer = idCustomer;
		this.idSeat = idSeat;
		this.idSession = idSession;
		this.idRoute = idRoute;
		this.status = status;
	}
	public String getIdBill() {
		return idBill;
	}
	public void setIdBill(String idBill) {
		this.idBill = idBill;
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
	public int getIdSeat() {
		return idSeat;
	}
	public void setIdSeat(int idSeat) {
		this.idSeat = idSeat;
	}
	public int getIdSession() {
		return idSession;
	}
	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}
	public int getIdRoute() {
		return idRoute;
	}
	public void setIdRoute(int idRoute) {
		this.idRoute = idRoute;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
