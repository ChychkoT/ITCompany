package connection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;


public class SingltonConnection {
	
	private static final Logger LOGGER = Logger.getLogger(SingltonConnection.class);
	
	private final static int MAX_CONNECTIONS = 3;
	private static SingltonConnection instance = null;
	private static BlockingQueue< MySQLConnection> pool = new ArrayBlockingQueue<>(MAX_CONNECTIONS);
	
	
	private static  SingltonConnection getInstance(){
		try{
		if (instance == null){
			instance = new SingltonConnection();
			createConection();
			LOGGER.info("The new connection was given");
		}else {
			createConection();
			LOGGER.info("The next connection was given");
		}
		
		}
		catch (Exception e){
			LOGGER.error(e);
		}
		return instance;
	}
	
	
	private static void createConection() {
		 MySQLConnection connection = new  MySQLConnection();
		pool.add(connection);
	}
	
		public void startConection()  {
			getInstance();
		}

}
