package employees.administration;

import java.util.Date;

import address.Address;

import javax.xml.bind.annotation.*;

@XmlRootElement
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
	
	public String toString() {
       return "Director{" +
                "Name='" + getName() + '\'' +
                ", Date=" + getDate() +
                ", Address=" + getAddress() +
                ", Slary='" + getSalary() + '\'' +
                '}';
    }
	

}
