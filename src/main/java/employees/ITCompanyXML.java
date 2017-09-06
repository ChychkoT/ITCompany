package employees;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
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

	@XmlElement
	public List<Director> director;
	
	@XmlElement
	public List<HrManager> hrManager;
	
	@XmlElement
	public List<BackEnd> backEnd;
	
	@XmlElement
	public List<FrontEnd> frontEnd;
	
	@XmlElement
	public List<Marketolog> marketolog;
	
	@XmlElement
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
	
	/*public ITCompanyXML unmarshall() throws JAXBException, IOException {
	    JAXBContext context = JAXBContext.newInstance(ITCompanyXML.class);
	    return (ITCompanyXML) context.createUnmarshaller()
	      .unmarshal(new FileReader("src\\main\\resources\\ITCompanyEmployeesXML.xml"));
	}*/


}
