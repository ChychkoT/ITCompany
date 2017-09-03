package employees;

import java.util.List;

import employees.administration.Director;
import employees.administration.HrManager;
import employees.development.BackEnd;
import employees.development.FrontEnd;
import employees.marketing.Marketolog;
import employees.marketing.Sale;

public class ITCompanyJSON {
	

	private List<Director> director;
	private List<HrManager> hrManager;
	private List<BackEnd> backEnd;
	private List<FrontEnd> frontEnd;
	private List<Marketolog> marketolog;
	private List<Sale> sale;
	
	public ITCompanyJSON() {
		super();
		 }
	
	public List<Director> getDirector() {
		return director;
	}
	
	public List<HrManager> getHrManager() {
		return hrManager;
	}
	
	public List<BackEnd> getBackEnd() {
		return backEnd;
	}
	
	public List<FrontEnd> getFrontEnd() {
		return frontEnd;
	}
	
	public List<Marketolog> getMarketolog() {
		return marketolog;
	}
	
	public List<Sale> getSale() {
		return sale;
	}

}
