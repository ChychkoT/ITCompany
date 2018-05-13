package dao.tables;

public class Directors extends Administration{
	
	private int id_directors;
	private int administration_id;

	public Directors() {
		super();
	}

	public int getId_directors() {
		return id_directors;
	}

	public void setId_directors(int id_directors) {
		this.id_directors = id_directors;
	}

	public int getAdministration_id() {
		return administration_id;
	}

	public void setAdministration_id(int administration_id) {
		this.administration_id = administration_id;
	}

	@Override
	public String toString() {
		return "Directors [id_employees=" + getEmployees_id() + ", id_directors=" + id_directors
				+ ", administration_id=" + administration_id
				+ ", name=" + getName_employee()+ ", date of birth=" + getDate_of_birth() + ", salary=" + getSalary()
				+ "]";
	}
	
	

}
