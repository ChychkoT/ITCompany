package dao.tables;

public class Directors {
	
	private int id_directors;
	private int administration_id;
	
	public Directors(){}

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
		return "Directors [id_directors=" + id_directors
				+ ", administration_id=" + administration_id + "]";
	}
	
	

}
