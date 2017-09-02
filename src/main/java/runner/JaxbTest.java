package runner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import address.Address;
import address.Country;
import employees.ITCompany;
import employees.administration.Director;


public class JaxbTest {
	
	//private List<Director> dir;
	
    public static void main(String[] args) throws  JAXBException {
    	
    	// creating country object
    	   ITCompany itDir = new ITCompany();  

    	   // Creating listOfStates
    	   List<Director> dir = new ArrayList<Director>();
    	   Director dir1 = new Director("Vasya1 ", null, new Address(Country.BELARUS, "Minsk",
   				"Sovetskaya", 16), 550);
    	   dir.add(dir1);
    	   Director dir2 = new Director("Vasya2 ", null, new Address(Country.BELARUS, "Minsk",
      				"Sovetskaya", 16), 1550);
       	   dir.add(dir2);

    	   itDir.setListDirector(dir);

    	  try {

    	   // create JAXB context and initializing Marshaller
    	   JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);
    	   Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

    	   // for getting nice formatted output
    	   jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

    	   //specify the location and name of xml file to be created
    	   File XMLfile = new File("src/main/resources/dir2.xml");

    	   // Writing to XML file
    	   jaxbMarshaller.marshal(itDir, XMLfile); 
    	   // Writing to console
    	   jaxbMarshaller.marshal(itDir, System.out); 

    	  } catch (JAXBException e) {
    	   // some exception occured
    	   e.printStackTrace();
    	  }
    	
    /*	try {

    		File file = new File("src/main/resources/dir.xml");
    		JAXBContext jaxbContext = JAXBContext.newInstance(ITCompany.class);

    		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    		ITCompany it = (ITCompany) jaxbUnmarshaller.unmarshal(file);
    		
    		List<Director> dir = it.getListDirector();
    		   for(Director director:dir)
    		   {
    		    System.out.println("Director{" +
    	                "Name='" + director.getName() + '\'' +
    	                ", Date=" + director.getDate() +
    	                ", Address=" + director.getAddress() +
    	                ", Slary='" + director.getSalary() + '\'' +
    	                '}');
    		   }
    		


    	  } catch (JAXBException e) {
    		e.printStackTrace();
    	  }*/
    }   
		 
}
