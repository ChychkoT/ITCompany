package runner;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;



import java.io.FileReader;

import employees.administration.Director;



public class ITCompanyStax {
	private static final Logger LOGGER = Logger.getLogger(ITCompanyStax.class);
	
	 public static void main(String[] args) {
		 

		 
		 boolean bName = false;
	     boolean bDate = false;
	     boolean bAddress = false;
	     boolean bSalary = false;
	    // boolean bcountry = false;
	    // boolean bstreet = false;
	     
	     
	     try {
	        XMLInputFactory factory = XMLInputFactory.newInstance();
	        XMLEventReader eventReader =
	        factory.createXMLEventReader(new FileReader("src\\main\\resources\\ITCompanyEmployees.xml"));

	        while(eventReader.hasNext()) {
	           XMLEvent event = eventReader.nextEvent();
	              
	           switch(event.getEventType()) {
	              
	              case XMLStreamConstants.START_ELEMENT:
	                 StartElement startElement = event.asStartElement();
	                 String qName = startElement.getName().getLocalPart();

	              if (qName.equalsIgnoreCase("Director")) {
	            	  LOGGER.info("Director:");
	              }else if (qName.equalsIgnoreCase("HrManager")) {
	            	  LOGGER.info("HrManager:");
	              }else if (qName.equalsIgnoreCase("BackEnd")) {
	            	  LOGGER.info("BackEnd:");
	              }else if (qName.equalsIgnoreCase("FrontEnd")) {
	            	  LOGGER.info("FrontEnd:");
	              }else if (qName.equalsIgnoreCase("Marketolog")) {
	            	  LOGGER.info("Marketolog:");
	              }else if (qName.equalsIgnoreCase("Sale")) {
	            	  LOGGER.info("Sale:");
	              } else if (qName.equalsIgnoreCase("Name")) {
	            	  bName = true;
	              } else if (qName.equalsIgnoreCase("Date")) {
	            	  bDate = true;
	              } else if (qName.equalsIgnoreCase("Address")) {
	            	  bAddress = true;
	              //} else if (qName.equalsIgnoreCase("country")) {
	            	 // bcountry = true;
	              }
	              else if (qName.equalsIgnoreCase("Salary")) {
	            	  bSalary = true;
	            
	              }
	              break;
	              
	              

	              case XMLStreamConstants.CHARACTERS:
	                 Characters characters = event.asCharacters();
	              if(bName) {
	            	  LOGGER.info("Name: " + characters.getData());
	                 bName = false;
	              }
	              if(bDate) {
	            	  LOGGER.info("Date of birth: " + characters.getData());
	                 bDate = false;
	              }
	              if(bAddress) {
	            	  LOGGER.info("Address: " + characters.getData());
	                 bAddress = false;
	              }
	              //if(bcountry) {
		                // System.out.println("country: " + characters.getData());
		                // bAddress = false;
		             // }
	              if(bSalary) {
	            	  LOGGER.info("Salary: " + characters.getData());
	                 bSalary = false;
	              }
	              break;

	              case XMLStreamConstants.END_ELEMENT:
	                 EndElement endElement = event.asEndElement();
	                 
	              if(endElement.getName().getLocalPart().equalsIgnoreCase("Director")) {
	                     LOGGER.info("\n\n\n");
	              }else if(endElement.getName().getLocalPart().equalsIgnoreCase("HrManager")) {
		                 LOGGER.info("\n\n\n");
	              }else if(endElement.getName().getLocalPart().equalsIgnoreCase("BackEnd")) {
		                 LOGGER.info("\n\n\n");             
	              }else if(endElement.getName().getLocalPart().equalsIgnoreCase("FrontEnd")) {
	                     LOGGER.info("\n\n\n");
                  }else if(endElement.getName().getLocalPart().equalsIgnoreCase("Marketolog")) {
	                     LOGGER.info("\n\n\n");
                  }else if(endElement.getName().getLocalPart().equalsIgnoreCase("Sale")) {               	 
	                     LOGGER.info("\n\n\n");
                  }
	              break;
	           } 
	        }
	     } catch (FileNotFoundException e) {
	    	 LOGGER.error(e);
	     } catch (XMLStreamException e) {
	    	 LOGGER.error(e);
	     }
	  
		 
		 
		 ////////////////////////////////////////////////////////////////////
	       
		 String fileName = "src\\main\\resources\\dir.xml";
		 
	       List<Director> dirList = parseXMLfile(fileName);  
	        for(Director dir : dirList){
	        	LOGGER.info(dir.toStringD());
	        }
	        
	    
     }

     private static List<Director> parseXMLfile(String fileName) {
         List<Director> dirList = new ArrayList<>();        
         Director dir = null;        
         XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
         try {
             XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
             while (reader.hasNext()) {
                 XMLEvent xmlEvent = reader.nextEvent();
                 if (xmlEvent.isStartElement()) {
                     StartElement startElement = xmlEvent.asStartElement();
                     if (startElement.getName().getLocalPart().equals("Director")) {
                        dir = new Director("Vasya1 ", null, null, 550);//?????
                     } else if (startElement.getName().getLocalPart().equals("Name")) {
                         xmlEvent = reader.nextEvent();
                         dir.setName(xmlEvent.asCharacters().getData());
                     } else if (startElement.getName().getLocalPart().equals("Date")) {
                         xmlEvent = reader.nextEvent();
                         dir.setDate(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("Address")) {
                         xmlEvent = reader.nextEvent();
                         dir.getAddress();
                     } else if (startElement.getName().getLocalPart().equals("Salary")) {
                         xmlEvent = reader.nextEvent();
                         dir.setSalary(Integer.parseInt(xmlEvent.asCharacters().getData()));
                 }
                 
             }
                 if (xmlEvent.isEndElement()) {
                     EndElement endElement = xmlEvent.asEndElement();
                     if (endElement.getName().getLocalPart().equals("Director")) {
                        dirList.add(dir);
                        
                     }
                 }
             }     
  
         } catch (FileNotFoundException | XMLStreamException exc) {
        	 LOGGER.error(exc);
         }
         return dirList;
     }
     
   
     
}



