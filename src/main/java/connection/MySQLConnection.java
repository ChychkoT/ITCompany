package connection;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

import org.apache.log4j.Logger;

public class MySQLConnection {

	private static final Logger LOGGER = Logger.getLogger(MySQLConnection.class);
	
	protected static void close(AutoCloseable resourse) {
		if (resourse != null)
			try {
				resourse.close();
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
	}

	public static void main(String[] args) {
		
		Connection connection = null;
		
		try {
			
			Properties prop = new Properties();
			FileInputStream in = new FileInputStream("src\\main\\resources\\db.properties");
			prop.load(in);
			close(in);

			String driver = prop.getProperty("jdbc.driver");
			if (driver != null) {
				Class.forName(driver);
			}

			 String url = prop.getProperty("jdbc.host");
			 String user = prop.getProperty("jdbc.user");
			 String password = prop.getProperty("jdbc.password");
			 ResultSet result = null;
			 PreparedStatement preparedStatement = null;

			try{

				connection = DriverManager.getConnection(url, user, password);
				preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOOYES where ID > ? and ID < ?");
				preparedStatement.setInt(1, 0);
				preparedStatement.setInt(2, 14);
				result = preparedStatement.executeQuery();
				while (result.next()) {
					LOGGER.info(result.getRow() + " Employees_id " + result.getInt("ID") + "\t"
							+ result.getString("NAME_EMPLOOYE") + "\t" + result.getDate("DATE_OF_BIRTH")+"\t"
									+ result.getInt("SALARY"));
				}
				/*if (!connection.isClosed()) {
					LOGGER.info("Connection to the database is established :)");
				}
				connection.close();
				if (connection.isClosed()) {
					LOGGER.info("Connection to the database is closed :)");
				}*/
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
				LOGGER.error("no connect");
			}
			finally {
				if (connection != null)				
						close(connection);
				        close(preparedStatement);
				        close(result);
				//LOGGER.info("Connection to the database is closed :)");
			}	 	
			
		} catch (Exception e) {
			LOGGER.error("The driver class did not load :(");
		}
		
		
	}

}
