package runner;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;

import employees.ITCompanyJSON;

public class JacksonITCompany {
	
	private static final Logger lOGGER = LogManager.getLogger(JacksonITCompany.class);

	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			File reader = new File("src\\main\\resources\\ITCompanyEmployees.json");
			ITCompanyJSON jacksonIT = mapper.readValue(reader, ITCompanyJSON.class);
			lOGGER.info(jacksonIT.getDirector().get(0).toString());
			lOGGER.info(jacksonIT.getDirector().get(1).toString());
			lOGGER.info(jacksonIT.getHrManager().get(0).toString());
			lOGGER.info(jacksonIT.getHrManager().get(1).toString());
		} catch (JsonGenerationException e) {
			lOGGER.info(e.getMessage());
		} catch (IOException e) {
			lOGGER.info(e.getMessage());

		}
		

	}

}
