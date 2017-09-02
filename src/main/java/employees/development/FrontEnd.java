package employees.development;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import address.Address;

@XmlRootElement(name = "FrontEnd")
@XmlType(propOrder = {"Name", "Date", "Address","Salary"})
public class FrontEnd extends Development {

	public FrontEnd(String name, Date date, Address address,
			int salary) {
		super(name, date,  address, salary);

	}

	@Override
	public void develop() {
		System.out.println("FrontDevelop");

	}
}
