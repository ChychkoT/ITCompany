package employees.administration;


import java.util.Date;

import interfaces.IEat;
import interfaces.ISleep;
import employees.EmployeesIT;
import address.Address;

/** 
 * Administration - abstract class that is inherited from class EmployeesIT 
*/
public abstract class Administration extends EmployeesIT implements IEat, ISleep {
	
	public Administration(){}

	public Administration(String name, Date date, Address address,
			int salary) {
		super(name, date, address, salary);

	}

	public void work() {
	}

	@Override
	public void eat() {
		System.out.println("The administration usually eats in a restaurant.");

	}
	
	@Override
	public void sleep() {
		System.out.println("According to statistics employees of the administrative department sleep for eight hours");

	}

}
