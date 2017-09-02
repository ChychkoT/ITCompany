package runner;

import org.apache.log4j.Logger;

public class DeadLock {
	
	private static final Logger LOGGER = Logger.getLogger(DeadLock.class);

	public static void main(String[] args) {
		
		LOGGER.info("----------DeadLock-----------");

		final String resource1 = "1";
		final String resource2 = "2";
		Thread t1 = new Thread() {
			public void run() {
				synchronized (resource1) {
					LOGGER.info("Thread 1: locked resource 1");

					try {
						Thread.sleep(10);
					} catch (Exception e) {
						LOGGER.error(e);
					}

					synchronized (resource2) {
						LOGGER.info("Thread 1: locked resource 2");
					}
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				synchronized (resource2) {
					LOGGER.info("Thread 2: locked resource 2");

					try {
						Thread.sleep(10);
					} catch (Exception e) {
						LOGGER.error(e);
					}

					synchronized (resource1) {
						LOGGER.info("Thread 2: locked resource 1");
					}
				}
			}
		};
		t1.start();
		t2.start();


	}

}
