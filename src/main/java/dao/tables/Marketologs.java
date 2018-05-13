package dao.tables;

public class Marketologs extends Marketing{

	private int id_marketolog;
	private int marketing_id;
	
    

	public Marketologs() {
		super();	
	}

	public int getId_marketolog() {
		return id_marketolog;
	}

	public void setId_marketolog(int id_marketolog) {
		this.id_marketolog = id_marketolog;
	}

	public int getMarketing_id() {
		return marketing_id;
	}

	public void setMarketing_id(int marketing_id) {
		this.marketing_id = marketing_id;
	}

	@Override
	public String toString() {
		return "Marketolog [id_employee=" + getEmployees_id() + ", marketing_id=" + marketing_id + ", id_marketolog=" + id_marketolog
				+ ", name=" + getName_employee()+ ", date of birth=" + getDate_of_birth() + ", salary=" + getSalary() 
				+ ", Address: { country= " + getAddress().getCountry_id()+", city=  "+ getAddress().getCity() +", street=  "+
		                  getAddress().getStreet()+", house=  " + getAddress().getHouse()+ "}"
				+ "]";
	}

	

}
