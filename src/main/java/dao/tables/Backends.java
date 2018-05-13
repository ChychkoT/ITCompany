package dao.tables;

public class Backends extends Development{

	private int id_backend;
	private int development_id;

	public Backends() {
		super();
	}

	public int getId_backend() {
		return id_backend;
	}

	public void setId_backend(int id_backend) {
		this.id_backend = id_backend;
	}

	public int getDevelopment_id() {
		return development_id;
	}

	public void setDevelopment_id(int development_id) {
		this.development_id = development_id;
	}

	@Override
	public String toString() {
		return "Backends [id_employees=" + getEmployees_id() + ", id_backend=" + id_backend + ", development_id="
				+ development_id + ", name=" + getName_employee()+ ", date of birth=" + getDate_of_birth() + ", salary=" + getSalary()
				+ development_id + "]";
	}	

}
