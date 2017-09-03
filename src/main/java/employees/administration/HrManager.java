package employees.administration;

import java.util.Date;



import address.Address;


public class HrManager extends Administration {
	
	public HrManager(){}

	public HrManager(String name, Date date, Address address, int salary) {
		super(name, date, address, salary);

	}

	public void FindSpecial() {
		super.work();
		System.out.println("Finds specialists");

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
	/*public void randomManager() {

		String symbols = "abcdefghijklmnopqrstuvwxyzABCEDFGHIJKLMNOPQRSTUVWXYZ1234567890";

		int count = (int) (Math.random() * 30);

		System.out.print("\nName: ");
		for (int j = 0; j < count; j++) {

			System.out.print(symbols.charAt((int) (Math.random() * symbols
					.length())));
		}

		System.out.print("\nDate of Birth: ");
		for (int j = 0; j < count; j++) {

			System.out.print(symbols.charAt((int) (Math.random() * symbols
					.length())));

		}

		System.out.print("\nAdress: ");
		for (int j = 0; j < count; j++) {

			System.out.print(symbols.charAt((int) (Math.random() * symbols
					.length())));

		}

		System.out.print("\nSalary:");
		for (int j = 0; j < count; j++) {

			System.out.print(symbols.charAt((int) (Math.random() * symbols
					.length())));

		}
		
		  System.out.println();

	}*/
}
