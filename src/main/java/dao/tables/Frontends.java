package dao.tables;

public class Frontends {
    
	private int id_frontend;
	private int development_id;
	
	public Frontends(){}

	public int getId_frontend() {
		return id_frontend;
	}

	public void setId_frontend(int id_frontend) {
		this.id_frontend = id_frontend;
	}

	public int getDevelopment_id() {
		return development_id;
	}

	public void setDevelopment_id(int development_id) {
		this.development_id = development_id;
	}

	@Override
	public String toString() {
		return "Frontends [id_frontend=" + id_frontend + ", development_id="
				+ development_id + "]";
	}
	

}
