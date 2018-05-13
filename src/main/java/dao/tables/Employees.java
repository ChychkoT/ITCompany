package dao.tables;

import java.sql.Date;

public abstract class Employees {
	

	private int id;
	private String name_employee;
	private Date date_of_birth;
	private int salary; 
	private Address address;
	

	
	public Employees(){}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName_employee() {
		return name_employee;
	}

	public void setName_employee(String name_employee) {
		this.name_employee = name_employee;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}	
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

	@Override
	public String toString() {
		return "Employees [id=" + id + ", name_employee=" + name_employee
				+ ", date_of_birth=" + date_of_birth + ", salary=" + salary
				+ "]";
	}
}
