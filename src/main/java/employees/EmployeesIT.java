package employees;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import address.Address;

/**
 * The abstract class for employees IT company with fields <b>name</b> , <b>date</b>,
 * <b>address</b>, <b>salary</b>.
 * @autor Tatsiana
 */

public abstract class EmployeesIT {

	/** Field employee name */
	private String name;
	/** Field employee's date of birth */
	//@XmlJavaTypeAdapter(DateAdapter.class)
	private Date date;
	/** Field employee address */
	private Address address;
	/** Field employee salary */
	private int salary;
	
	public EmployeesIT(){}

	/**
	 * Constructor - creating a new object with certain values
	 * 
	 * @param name
	 *            - employee name
	 * @param date
	 *            - employee date of birth
	 * @param salary
	 *            - employee salary
	 * @param address
	 *            - employee address
	 * @see EmployeesIT#EmployeesIT()
	 */
	public EmployeesIT(String name, Date date, Address address, int salary) {
		this.name = name;
		this.date = date;
		this.salary = salary;
		this.setAddress(address);
	}

	/**
	 * Function of obtaining the field value {@link EmployeesIT#name}
	 * 
	 * @return Returns the name of the employee
	 */
	public String getName() {
		return name;
	}

	/**
	 * The procedure for determining the name of the employee
	 * {@link EmployeesIT#name}
	 * 
	 * @param name - employee name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	 /**
	 * Function of obtaining the field value {@link EmployeesIT#date}
	 * 
	 * @return Returns a formatted date of birth
	 */
	public String getDate() {
		SimpleDateFormat formatDate = new SimpleDateFormat("dd MMMM YYYY");
		String datest = formatDate.format(date);
		return datest;
	}

	/**
	 * The procedure for determining employee date of birth
	 * {@link EmployeesIT#date}
	 * 
	 * @param date - employee date of birth
	 */ 
	public void setDate(String datest) {
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		Date d = stringDate(datest, formatDate);
		this.date = d;
	}

	private Date stringDate(String st, SimpleDateFormat formatDate) {
		Date d = null;
		try {
			d = formatDate.parse(st);
		} catch (ParseException e) {
			System.out.println(e);
		}
		return d;
	}

	/**
	 * Function of obtaining the field value {@link EmployeesIT#salary}
	 * 
	 * @return Returns employee salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * The procedure for determining employee date of birth
	 * {@link EmployeesIT#salary}
	 * 
	 * @param salary - employee salary
	 */
	public void setSalary(int salary) {
		this.salary = salary;

	}

	/**
	 * Function of obtaining the field value {@link EmployeesIT#address}
	 * 
	 * @return Returns employee address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * The procedure for determining employee date of birth
	 * {@link EmployeesIT#address}
	 * 
	 * @param adress - employee address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 *The abstract method showing that all empioyees work
	 */
	public abstract void work();

	public void setDate(Date date) {
		this.date = date;
	}
	
	 public String getEmployee()
	    {  
	       return "Name: " + getName() + "\n"+
	               "Date of birth: "+ getDate() + "\n" + 
	    		    "Address: " + getAddress().getCountry() + getAddress().getCity() +
	    		                  getAddress().getStreet() + getAddress().getHouse()+ "\n" + 
	                "Salary: " + getSalary() + "$"; 
	    }

	 

		/*public Date getDate() {
			return date;
		}
		
		 @XmlJavaTypeAdapter(DateAdapter.class)
		public void setDate() {
			this.date = date;
		}*/
	

}
