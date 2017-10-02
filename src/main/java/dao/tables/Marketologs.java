package dao.tables;

public class Marketologs {

	private int id_marketolog;
	private int marketing_id;
	
	public Marketologs(){}

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
		return "Marketologs [id_marketolog=" + id_marketolog
				+ ", marketing_id=" + marketing_id + "]";
	}
	

}
