package dao.tables;

public class Country {
	
	private int id;
	private String country_name;
	
	public Country(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", country_name=" + country_name + "]";
	}


}
