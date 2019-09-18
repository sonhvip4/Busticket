package busticket.model;

public class Car {
	private int id;
	private String carName;

	public Car() {
		super();
	}

	public Car(String carName) {
		super();
		this.carName = carName;
	}

	public Car(int id, String carName) {
		super();
		this.id = id;
		this.carName = carName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

}
