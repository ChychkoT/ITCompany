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
public class ITCompany {
	public ITCompany() {
		 }

	private List<Director> dir;
	/*public List<HrManager> hrman;
	public List<BackEnd> bend;
	public List<FrontEnd> fend;
	public List<Marketolog> mark;
	public List<Sale> sale;*/
	
	
	public List<Director> getListDirector() {
		  return dir;
		 }

	 @XmlElement
	  public void setListDirector(List<Director> dir) {
	 
	   this.dir = dir;
	 
	  }


}
