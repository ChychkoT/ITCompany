package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;


public class ConnectionPoolDB {
	
	//private ConnectionPoolDB(){}

	private static final Logger LOGGER = Logger.getLogger(ConnectionPoolDB.class);
	private final static int MAX_CONNECTIONS = 3;
	private static ConnectionPoolDB instance;
	private BlockingQueue<Connection> pool = new ArrayBlockingQueue<Connection>(MAX_CONNECTIONS);
	private int counter = 0;

	protected static void close(AutoCloseable resourse) {
		if (resourse != null)
			try {
				resourse.close();
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
	}

	public static ConnectionPoolDB getInstance() {
		Lock lock = new ReentrantLock();
		lock.lock();
		try {
			if (instance == null) {
				instance = new ConnectionPoolDB();
			}
			return instance;
		} finally {
			lock.unlock();
		}
	}

	public Connection getConnection() {
		Connection connection = null;
		try {

			Properties prop = new Properties();
			FileInputStream in = new FileInputStream(
					"src\\main\\resources\\database\\db.properties");
			prop.load(in);
			close(in);

			String driver = prop.getProperty("jdbc.driver");
			if (driver != null) {
				Class.forName(driver);
			}

			String url = prop.getProperty("jdbc.host");
			String user = prop.getProperty("jdbc.user");
			String password = prop.getProperty("jdbc.password");

			if (pool.isEmpty() && counter < MAX_CONNECTIONS) {
				try {
					connection = DriverManager.getConnection(url, user,
							password);

				} catch (SQLException e) {
					LOGGER.error(e.getMessage());
				}
			}else if (pool.size()!=0){
				try {
					connection = pool.poll(200, TimeUnit.MILLISECONDS);
				}
				catch (InterruptedException e) {
					LOGGER.error("InterruptedException");
				}
				
			}else {
				getConnection();
			}
			counter++;	

		} catch (Exception e) {
			LOGGER.error("The driver class did not load :(");
		}finally{
			//close(connection);
			putBackConnection(connection);
		}
		return connection;
	}

	
	
	public void putBackConnection(Connection connection) {
		if (connection != null && (pool.size() < MAX_CONNECTIONS))
			counter--;
			pool.add(connection);
	}
	
	
	
	private int getcounter() {
		return counter;
	}

	private void setcounter(int counter) {
		this.counter = counter;
	}

}
