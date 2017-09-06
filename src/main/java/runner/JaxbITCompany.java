package runner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import employees.ITCompanyXML;

public class JaxbITCompany {
	
	private static final Logger lOGGER = LogManager.getLogger(JaxbITCompany.class);
	
    public static void main(String[] args) throws  JAXBException {
    	
    		
    	try {
			JAXBContext context = JAXBContext.newInstance(ITCompanyXML.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			FileReader reader = new FileReader("src\\main\\resources\\ITCompanyEmployeesXML.xml");
			ITCompanyXML jaxbITCompany = (ITCompanyXML) unmarshaller.unmarshal(reader);
			lOGGER.info(jaxbITCompany.getDirector().get(0).toString());
			lOGGER.info(jaxbITCompany.getDirector().get(1).toString());
		} catch (JAXBException e) {
			lOGGER.info(e.getMessage());
		} catch (FileNotFoundException e) {
			lOGGER.info(e.getMessage());

	    }
 	

    }   
		 
}
