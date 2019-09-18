package busticket.model;

public class Seat {
	private int id;
	private int seatName;
	private int idCar;

	public Seat() {
		super();
	}

	public Seat(int seatName, int idCar) {
		super();
		this.seatName = seatName;
		this.idCar = idCar;
	}

	public Seat(int id, int seatName, int idCar) {
		super();
		this.id = id;
		this.seatName = seatName;
		this.idCar = idCar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSeatName() {
		return seatName;
	}

	public void setSeatName(int seatName) {
		this.seatName = seatName;
	}

	public int getIdCar() {
		return idCar;
	}

	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}

}
