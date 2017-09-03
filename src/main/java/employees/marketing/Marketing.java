package employees.marketing;
import java.util.Date;

import interfaces.IEat;
import interfaces.ISleep;
import address.Address;
import employees.EmployeesIT;

/** 
 * Marketing - abstract class that is inherited from class EmployeesIT 
*/
public abstract class Marketing extends EmployeesIT implements IEat, ISleep{
	
	public Marketing(){}
	
	public Marketing(String name, Date date, Address address,
			int salary) {
		super(name, date,  address, salary);
	}
	
	@Override
	public void work() {
	}

	/**
     *The abstract method showing that all employees of the marketing department sell
     */
	public abstract void sale();
	
	@Override
	public void eat() {
		System.out.println("The marketing department is usually eats at a cafe.");

	}
	@Override
	public void sleep() {
		System.out.println("In the marketing department they like to sleep, but they rarely get it.");

	}

}
