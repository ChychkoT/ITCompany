package employees.marketing;
import java.util.Date;



import address.Address;

public class Sale extends Marketing {
	
	public Sale(){}

	public Sale(String name, Date date,  Address address,
			int salary) {
		super(name, date,  address, salary);
	}

	
	@Override
	public void sale() {
		System.out.println("Sells the product");
	}
	
	@Override
	public String getEmployee()
    {  
       return "Name: " + getName() + "\n"+
               "Date of birth: "+ getDate() + "\n" + 
    		    "Address: { country - " + getAddress().getCountry() +", city -  "+ getAddress().getCity() +", street -  "+
    		                  getAddress().getStreet()+", house -  " + getAddress().getHouse()+ "}\n" + 
                "Salary: " + getSalary() + "$"; 
    }
	
	

}
