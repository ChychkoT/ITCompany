package employees.development;

import java.util.Date;

import address.Address;

public class BackEnd extends Development  {

	
	public BackEnd(String name, Date date, Address address, int salary) {
		super(name, date, address, salary);
	}
	
	public BackEnd(){}

	@Override
	public void develop() {
		super.work();
		System.out.println("BackDevelop!");
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getName().hashCode();
		result = prime * result + getSalary();
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BackEnd other = (BackEnd) obj;
		if (getName() != other.getName())
			return false;
		if (getSalary() != other.getSalary())
			return false;
		return true;
	}

	public void develop(int a) {
		System.out.println("Developer category" + a + " BackDevelop!");
	}

	public void develop(int a, int b) {

		int c = a + b;

		System.out.println(getName() + "--- "
				+ "Number of working hours of the developer: " + c);
	}
	
	@Override
	public String toString()
    {  
       return "Name: " + getName() + "\n"+
               "Date of birth: "+ getDate() + "\n" + 
    		    "Address: { country - " + getAddress().getCountry() +", city -  "+ getAddress().getCity() +", street -  "+
    		                  getAddress().getStreet()+", house -  " + getAddress().getHouse()+ "}\n" + 
                "Salary: " + getSalary() + "$"; 
    }

	



}
