package com.xml.model;

public class Car {
	private int id;
	private String immat;
	private String model;
	private String color;
	
	public Car(int id, String immat, String model, String color) {
		super();
		this.id = id;
		this.immat = immat;
		this.model = model;
		this.color = color;
	}
	

	public Car() {
		super();
	}


	public int getId() {
		return id;
	}

	public String getImmat() {
		return immat;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setImmat(String immat) {
		this.immat = immat;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setColor(String color) {
		this.color = color;
	}


	@Override
	public String toString() {
		return "Car [id=" + id + ", immat=" + immat + ", model=" + model + ", color=" + color + "]";
	}
	
	
}
