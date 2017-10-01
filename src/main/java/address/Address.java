package address;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Address {

	private Country country;
	private String city;
	private String street;
	private int house;

	public Address(){}
	
	public Address(Country country, String city, String street, int house) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.house = house;

	}
	
	public void test() {
		System.out.println("Hello!");
	}
	
	public Country getCountry() {
		return country;
	}
	
	 @XmlElement
	public void setCountry(Country country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}
    
	 @XmlElement
	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}
	
	 @XmlElement
	public void setStreet(String street) {
		this.street = street;
	}

	public int getHouse() {
		return house;
	}
	
	 @XmlElement
	public void setHouse(int house) {
		this.house = house;
	}
	
	    public String getAddress() {
	        return "Address{" +
	                "country " + getCountry() + 
	                ", city " + getCity() +
	                ", street " + getStreet() +
	                ", house " + getHouse() + "}";
	    }



}