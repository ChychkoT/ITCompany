package runner;

import org.apache.log4j.Logger;

import connection.MyThread;
import connection.SingltonConnection;

public class RunnerConnection {

	private static final Logger LOGGER = Logger.getLogger(RunnerConnection.class);
	
	public static void main(String[] args) {
		
		LOGGER.info("---SinglTon Connection-----------\n\n");

		SingltonConnection scon = new SingltonConnection();
		MyThread th = new MyThread();
		
		for (int i = 1; i < 5; i++) {
			LOGGER.info(i);
			th.run();
			scon.startConection();
			
		}

	}

}
