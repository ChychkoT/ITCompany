package dao.tables;

public class Address {
	
	private int id;
	private int contry_id;
	private String city;
	private String street;
	private String house;
	private int employees_id;
	
	public Address(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getContry_id() {
		return contry_id;
	}

	public void setContry_id(int contry_id) {
		this.contry_id = contry_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public int getEmployees_id() {
		return employees_id;
	}

	public void setEmployees_id(int employees_id) {
		this.employees_id = employees_id;
	}
	

}
