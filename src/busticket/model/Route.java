package busticket.model;

import java.sql.Time;

public class Route {
	private int id;
	private String startingPoint;
	private String destination;
	private Time timeStarting;
	private Time timeFinishing;
	private int price;
	private int idCar;
	private Car carObject;

	public Route() {
		super();
	}


	
	public Route(String startingPoint, String destination, Time timeStarting, Time timeFinishing, int price,
			int idCar) {
		super();
		this.startingPoint = startingPoint;
		this.destination = destination;
		this.timeStarting = timeStarting;
		this.timeFinishing = timeFinishing;
		this.price = price;
		this.idCar = idCar;
	}



	public Route(String startingPoint, String destination, Time timeStarting, Time timeFinishing) {
		super();
		this.startingPoint = startingPoint;
		this.destination = destination;
		this.timeStarting = timeStarting;
		this.timeFinishing = timeFinishing;
	}


	public Route(int id, String startingPoint, String destination, Time timeStarting, Time timeFinishing, int price,
			int idCar) {
		super();
		this.id = id;
		this.startingPoint = startingPoint;
		this.destination = destination;
		this.timeStarting = timeStarting;
		this.timeFinishing = timeFinishing;
		this.price = price;
		this.idCar = idCar;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Time getTimeStarting() {
		return timeStarting;
	}

	public void setTimeStarting(Time timeStarting) {
		this.timeStarting = timeStarting;
	}

	public Time getTimeFinishing() {
		return timeFinishing;
	}

	public void setTimeFinishing(Time timeFinishing) {
		this.timeFinishing = timeFinishing;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}



	public int getIdCar() {
		return idCar;
	}



	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}



	public Car getCarObject() {
		return carObject;
	}



	public void setCarObject(Car carObject) {
		this.carObject = carObject;
	}
	
}
