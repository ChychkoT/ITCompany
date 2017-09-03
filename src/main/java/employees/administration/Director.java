package employees.administration;

import java.util.Date;

import address.Address;

public class Director extends Administration {
	
	public Director(){}
	
	public Director(String name, Date date,  Address address,
			int salary) {
		super(name, date,  address, salary);
	}

	@Override
	public void work() {
	}

	public void hireEmployee() {
		System.out.println("Hires an employee");
	}
	
	public void startWorking() {
		System.out.println("Work!");
		
	}
	
	@Override
	public String toString() {
		return "Name: " + getName() + "\n"+
	               "Date of birth: "+ getDate() + "\n" + 
	    		    "Address: { country - " + getAddress().getCountry() +", city -  "+ getAddress().getCity() +", street -  "+
	    		                  getAddress().getStreet()+", house -  " + getAddress().getHouse()+ "}\n" + 
	                "Salary: " + getSalary() + "$"; 
    }
	
	
	public String toStringD() {
		return "Name: " + getName() + "\n"+
	               "Date of birth: "+ getDate() + "\n" + 
	    		    "Address: " + getAddress()+ "\n" + 
	                "Salary: " + getSalary() + "$"; 
    }
	

}
