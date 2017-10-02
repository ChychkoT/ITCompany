package dao.tables;

public class Development {
	
	private int id_development;
	private int employees_id;
	
	public Development(){}

	public int getId_development() {
		return id_development;
	}

	public void setId_development(int id_development) {
		this.id_development = id_development;
	}

	public int getEmployees_id() {
		return employees_id;
	}

	public void setEmployees_id(int employees_id) {
		this.employees_id = employees_id;
	}

	@Override
	public String toString() {
		return "Development [id_development=" + id_development
				+ ", employees_id=" + employees_id + "]";
	}
	

}
