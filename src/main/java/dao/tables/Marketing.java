package dao.tables;

public class Marketing {

	private int id_marketing;
	private int employees_id;
	
	public Marketing() {
	}

	public int getId_marketing() {
		return id_marketing;
	}

	public void setId_marketing(int id_marketing) {
		this.id_marketing = id_marketing;
	}

	public int getEmployees_id() {
		return employees_id;
	}

	public void setEmployees_id(int employees_id) {
		this.employees_id = employees_id;
	}

	@Override
	public String toString() {
		return "Marketing [id_marketing=" + id_marketing + ", employees_id="
				+ employees_id + "]";
	}

	
}
