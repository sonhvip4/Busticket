package busticket.dto;

import java.sql.Date;

public class SeatDetail {

		private int idSeat;
		private int idTicket;
		private int idSession;
		private int idRoute;
		private int nameSeat;
		private String status;
		private Date departDate;
		
		public SeatDetail() {
			super();
			// TODO Auto-generated constructor stub
		}



		public SeatDetail(int idSeat, int idTicket, int idSession, int idRoute, int nameSeat, String status,
				Date departDate) {
			super();
			this.idSeat = idSeat;
			this.idTicket = idTicket;
			this.idSession = idSession;
			this.idRoute = idRoute;
			this.nameSeat = nameSeat;
			this.status = status;
			this.departDate = departDate;
		}



		public int getIdRoute() {
			return idRoute;
		}



		public void setIdRoute(int idRoute) {
			this.idRoute = idRoute;
		}



		public int getIdSeat() {
			return idSeat;
		}

		public void setIdSeat(int idSeat) {
			this.idSeat = idSeat;
		}

		public int getIdTicket() {
			return idTicket;
		}

		public void setIdTicket(int idTicket) {
			this.idTicket = idTicket;
		}

		public int getIdSession() {
			return idSession;
		}

		public void setIdSession(int idSession) {
			this.idSession = idSession;
		}

		public int getNameSeat() {
			return nameSeat;
		}

		public void setNameSeat(int nameSeat) {
			this.nameSeat = nameSeat;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Date getDepartDate() {
			return departDate;
		}

		public void setDepartDate(Date departDate) {
			this.departDate = departDate;
		}
		
		
		
}
