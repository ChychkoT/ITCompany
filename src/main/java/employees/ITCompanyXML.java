package employees;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import employees.administration.Director;
import employees.administration.HrManager;
import employees.development.BackEnd;
import employees.development.FrontEnd;
import employees.marketing.Marketolog;
import employees.marketing.Sale;

@XmlRootElement(name = "ITCompany")
public class ITCompanyXML {
	
	public ITCompanyXML() {
		super();
		 }

	@XmlElement(name="director")
	private List<Director> director;
	
	@XmlElement(name="hrManager")
	public List<HrManager> hrManager;
	
	@XmlElement(name="backEnd")
	public List<BackEnd> backEnd;
	
	@XmlElement(name="frontEnd")
	public List<FrontEnd> frontEnd;
	
	@XmlElement(name="marketolog")
	public List<Marketolog> marketolog;
	
	@XmlElement(name="sale")
	public List<Sale> sale;
	
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
