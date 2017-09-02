package employees.development;
import java.util.Date;

import interfaces.IEat;
import interfaces.ISleep;
import address.Address;
import employees.EmployeesIT;

/** 
 * Development - abstract class that is inherited from class EmployeesIT 
*/
public abstract class Development extends EmployeesIT implements IEat, ISleep {

	public Development(String name, Date date, Address address,
			int salary) {
		super(name, date, address, salary);

	}

	@Override
	public void work() {

	}

	/**
     *The abstract method showing that all developers develop 
     */
	public abstract void develop();
	
	@Override
	public void eat() {
		System.out.println("\nEmployees " + getName() + "of the development department bring food from home.");

	}
	
	@Override
	public void sleep() {
		System.out.println("No one knows when and how many developer " + getName() +  "sleep..))");

	}

}
