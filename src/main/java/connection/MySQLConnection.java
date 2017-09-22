package connection;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

import org.apache.log4j.Logger;

public class MySQLConnection {

	private static final Logger LOGGER = Logger
			.getLogger(MySQLConnection.class);

	public static void main(String[] args) {
		try {
			Properties prop = new Properties();
			FileInputStream in = new FileInputStream("src/main/resources/db.properties");
			prop.load(in);
			in.close();

			String driver = prop.getProperty("jdbc.driver");
			if (driver != null) {
				Class.forName(driver);
			}

			 String URL = prop.getProperty("jdbc.host");
			 String USER = prop.getProperty("jdbc.user");
			 String PASSWORD = prop.getProperty("jdbc.password");

			try{
				Connection connection = DriverManager.getConnection(URL, USER,
						PASSWORD);

				if (!connection.isClosed()) {
					LOGGER.info("Connection to the database is established :)");
				}
				connection.close();
				if (connection.isClosed()) {
					LOGGER.info("Connection to the database is closed :)");
				}
			}catch(SQLException e){
				LOGGER.error(e);
			}		 

			

		} catch (Exception e) {
			LOGGER.error("The driver class did not load :(");
		}

	}

}
