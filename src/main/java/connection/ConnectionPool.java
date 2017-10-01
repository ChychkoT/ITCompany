package connection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

public class ConnectionPool {
	
	private static final Logger LOGGER = Logger.getLogger(RunnerConnectionPool.class);
	
	private final static int MAX_CONNECTIONS = 3;
	private static ConnectionPool instance ;
	private  BlockingQueue<MyConnection> pool = new ArrayBlockingQueue<MyConnection>(MAX_CONNECTIONS);
	private int counter = 0;

	

	public static ConnectionPool getInstance(){
		Lock lock = new ReentrantLock();
		lock.lock();
		try {
			if (instance == null) {
				instance = new ConnectionPool();
			}
			return instance;
		}
		finally {
			lock.unlock();
		}
	}
	
	
	public MyConnection getConnection() throws InterruptedException {
		if (pool.isEmpty()) {
			pool.add(new MyConnection());
			LOGGER.info("Connection was given");
		}
		counter++;
		return pool.take();
	}

	public void putBackConnection(MyConnection connection) {
		if (connection != null && (pool.size() < MAX_CONNECTIONS))
			counter--;
			pool.add(connection);
	}

	public void closeConnection() {
		LOGGER.info("Connection was closed ");
	}


	public static int getMax_Connection() {
		return MAX_CONNECTIONS;
	}
	
	private int getcounter() {
		return counter;
	}

	private void setcounter(int counter) {
		this.counter = counter;
	}


}
