package dao.tables;

public class Sales {
	private int id_sale;
	private int marketing_id;
	
	public Sales(){}

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
		return "Sales [id_sale=" + id_sale + ", marketing_id=" + marketing_id
				+ "]";
	}
    
}
