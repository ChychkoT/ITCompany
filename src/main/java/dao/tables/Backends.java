package dao.tables;

public class Backends {

	private int id_backend;
	private int development_id;
	
	public Backends(){}

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
		return "Backends [id_backend=" + id_backend + ", development_id="
				+ development_id + "]";
	}
	
	

}
