package dao.tables;

public class Sales extends Marketing{
	private int id_sale;
	private int marketing_id;

	public Sales() {
		super();
	}

	public int getId_sale() {
		return id_sale;
	}

	public void setId_sale(int id_sale) {
		this.id_sale = id_sale;
	}

	public int getMarketing_id() {
		return marketing_id;
	}

	public void setMarketing_id(int marketing_id) {
		this.marketing_id = marketing_id;
	}

	@Override
	public String toString() {
		return "Sales [id_employees=" + getId() + ", marketing_id=" + marketing_id +  ", id_sale=" + id_sale + ", name=" + getName_employee()+ 
				", date of birth=" + getDate_of_birth() + ", salary=" + getSalary()
				+ ", Address: { country= " + getAddress().getCountry_id()+", city=  "+ getAddress().getCity() +", street=  "+
                getAddress().getStreet()+", house=  " + getAddress().getHouse()+ "}"
		        + "]"; 
	}

}
