package employees.development;
import java.util.Date;



import address.Address;

public class FrontEnd extends Development {
	
	public FrontEnd(){}

	public FrontEnd(String name, Date date, Address address,
			int salary) {
		super(name, date,  address, salary);

	}

	@Override
	public void develop() {
		System.out.println("FrontDevelop");

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
