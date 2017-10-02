package dao.tables;

public class Administration {
	
	private int id_administration;
	private int employees_id;
	
	public Administration(){}

	public int getId_administration() {
		return id_administration;
	}

	public void setId_administration(int id_administration) {
		this.id_administration = id_administration;
	}

	public int getEmployees_id() {
		return employees_id;
	}

	public void setEmployees_id(int employees_id) {
		this.employees_id = employees_id;
	}

	@Override
	public String toString() {
		return "Administration [id_administration=" + id_administration
				+ ", employees_id=" + employees_id + "]";
	}
	
	

}
