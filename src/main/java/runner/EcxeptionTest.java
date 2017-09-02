package runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import employees.development.BackEnd;
import exception.MyTestException;
import exception.Test;

public class EcxeptionTest {

	private static final Logger LOGGER = LogManager.getLogger(EcxeptionTest.class);

	public static void main(String[] args) {
		
		BackEnd bend2 = new BackEnd("Vasya1 ", null, null, 550);
		Test test = new Test();

		try {
			String hello = test.helloMessage(null);
			LOGGER.info("Example 1: " + hello);
		} catch (MyTestException ex) {

			LOGGER.error("Example 1: error message: " + ex.getMessage());
		}

		try {
			String hello = test.helloMessage(bend2.getName());
			LOGGER.info("Example 2: " + hello);
		} catch (MyTestException ex) {

			LOGGER.error("Example 2: error message: " + ex.getMessage());
		}

	}

}
