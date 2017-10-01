package connection;



import org.apache.log4j.Logger;

public class RunnerConnectionPool {

	private static final Logger LOGGER = Logger.getLogger(RunnerConnectionPool.class);
	

	public static void main(String[] args) {
		MyThread th = new MyThread();
		ConnectionPool.getInstance();
		th.runThread(ConnectionPool.getMax_Connection(), () -> {
			new Thread(() -> {
				try {
					ConnectionPool.getInstance().getConnection();
					MyConnection connection = null;
					ConnectionPool.getInstance().putBackConnection(connection);
					ConnectionPool.getInstance().closeConnection();
				} catch (Exception e) {
					LOGGER.error(e.getMessage());
				}
				
			}).start();
		});
	
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage());
		}
		
		
	}
	
}
