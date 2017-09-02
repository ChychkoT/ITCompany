package connection;

import org.apache.log4j.Logger;

public class MyThread extends Thread{
	private static final Logger LOGGER = Logger.getLogger(MyThread.class);
	public void run(){
		LOGGER.info("The MyTread started work.\n");
       		// Thread.currentThread().getName());
	
	}

}
