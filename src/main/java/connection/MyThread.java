package connection;

import org.apache.log4j.Logger;

public class MyThread extends Thread{
	private static final Logger LOGGER = Logger.getLogger(MyThread.class);
	
	MyThread(){}
	
	public void runThread (int n, Runnable r) {
		for (int i = 0; i < n; i++)
			r.run();
	}
	
	public void run(){
		LOGGER.info("The MyTread started work.\n");
       		// Thread.currentThread().getName());
	
	}

}
