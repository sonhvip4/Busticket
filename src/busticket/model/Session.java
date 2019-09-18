/*
	@author:Quang Truong
	@date: Aug 16, 2019
*/

package busticket.model;

import java.sql.Date;

public class Session {
	private int id;
	private int ticketNumber;
	private int idCar;
	private int idRoute;
	private Date departDate;
	private Car carObject;
	private Route routeObject;

	public Session() {
		super();
	}



	public Session(int ticketNumber, int idCar, int idRoute, Date departDate) {
		super();
		this.ticketNumber = ticketNumber;
		this.idCar = idCar;
		this.idRoute = idRoute;
		this.departDate = departDate;
	}



	public Session(int id, int ticketNumber, int idCar, int idRoute, Date departDate) {
		super();
		this.id = id;
		this.ticketNumber = ticketNumber;
		this.idCar = idCar;
		this.idRoute = idRoute;
		this.departDate = departDate;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public int getIdCar() {
		return idCar;
	}

	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}

	public int getIdRoute() {
		return idRoute;
	}

	public void setIdRoute(int idRoute) {
		this.idRoute = idRoute;
	}
	

	public Date getDepartDate() {
		return departDate;
	}



	public void setDepartDate(Date departDate) {
		this.departDate = departDate;
	}



	public Car getCarObject() {
		return carObject;
	}

	public void setCarObject(Car carObject) {
		this.carObject = carObject;
	}

	public Route getRouteObject() {
		return routeObject;
	}

	public void setRouteObject(Route routeObject) {
		this.routeObject = routeObject;
	}
	
	
	
}
