package dao.tables;

public class HrManagers extends Administration{
	
  private int id_hrmanagers;
  private int administration_id;

public HrManagers() {
	super();
}

public int getId_hrmanagers() {
	return id_hrmanagers;
}

public void setId_hrmanagers(int id_hrmanagers) {
	this.id_hrmanagers = id_hrmanagers;
}

public int getAdministration_id() {
	return administration_id;
}

public void setAdministration_id(int administration_id) {
	this.administration_id = administration_id;
}

@Override
public String toString() {
	return "HrManagers [id_employees=" + getEmployees_id() + ", id_hrmanagers=" + id_hrmanagers
			+ ", administration_id=" + administration_id 
			+ ", name=" + getName_employee()+ ", date of birth=" + getDate_of_birth() + ", salary=" + getSalary()
			+ ", Address: { country= " + getAddress().getCountry_id()+", city=  "+ getAddress().getCity() +", street=  "+
		                  getAddress().getStreet()+", house=  " + getAddress().getHouse()+ "}"
			+ "]";
}

}
