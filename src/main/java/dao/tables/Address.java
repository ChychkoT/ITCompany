package dao.tables;

public class Address {
	
	private int id;
	private int country_id;
	private String city;
	private String street;
	private String house;
	private int employees_id;
	private Country country;
	private String c;
	
	public Address(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
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

	@Override
	public String toString() {
		return "Address [" + "id_employee=" + employees_id + ", contry_id=" + country_id + ", city="
				+ city + ", street=" + street + ", house=" + house 
				+  "]";
	}

	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}
	
	
	

}
