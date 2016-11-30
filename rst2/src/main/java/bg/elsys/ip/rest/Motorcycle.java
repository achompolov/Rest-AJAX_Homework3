package bg.elsys.ip.rest;

import io.swagger.annotations.ApiModelProperty;

public class Motorcycle {

	@ApiModelProperty(required = true)
	private static int ID_COUNT = 1;
	
	private int id;
	private String brand;
	private String model;
	private int maxSpeed;
	private int horsePowers;
	private int creationYear;

	public Motorcycle() {
		id = ID_COUNT++;
	}

	public Motorcycle(String brand, String model, int maxSpeed, int horsePowers, int creationYear) {
        this();
        this.brand = brand;
		this.model = model;
		this.maxSpeed = maxSpeed;
		this.horsePowers = horsePowers;
		this.creationYear = creationYear;
	}

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getHorsePowers() {
		return horsePowers;
	}
	public void setHorsePowers(int horsePowers) {
		this.horsePowers = horsePowers;
	}

	public int getCreationYear() {
		return creationYear;
	}
	public void setCreationYear(int creationYear) {
		this.creationYear = creationYear;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
