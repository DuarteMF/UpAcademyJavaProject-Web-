package test;

public class Car {
	String id;
	int year;
	String color;
	String brand;
	int price;
	boolean soldState;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isSoldState() {
		return soldState;
	}
	public void setSoldState(boolean soldState) {
		this.soldState = soldState;
	}
	public Car(String id, String brand, int year, String color, int price, boolean soldState) {
		this.id = id;
		this.year = year;
		this.color = color;
		this.brand = brand;
		this.price = price;
		this.soldState = soldState;
	}
	
	
}
