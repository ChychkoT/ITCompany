package employees.marketing;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import address.Address;

@XmlRootElement(name = "Marketolog")
@XmlType(propOrder = {"Name", "Date", "Address","Salary"})
public class Marketolog extends Marketing  {

	public Marketolog(String name, Date date,  Address address,
			int salary) {
		super(name, date, address, salary);
	}

	@Override
	public void sale() {
		System.out.println("Market research");
	}
	
	

}
