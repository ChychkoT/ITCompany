package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionDB {

	private static final Logger LOGGER = Logger.getLogger(ConnectionDB.class);

	protected static void close(AutoCloseable resourse) {
		if (resourse != null)
			try {
				resourse.close();
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
	}

	public Connection getConnection() {

		Connection connection = null;

		try {

			Properties prop = new Properties();
			FileInputStream in = new FileInputStream(
					"src\\main\\resources\\db.properties");
			prop.load(in);
			close(in);

			String driver = prop.getProperty("jdbc.driver");
			if (driver != null) {
				Class.forName(driver);
			}

			String url = prop.getProperty("jdbc.host");
			String user = prop.getProperty("jdbc.user");
			String password = prop.getProperty("jdbc.password");

			try {
				connection = DriverManager.getConnection(url, user, password);
				/*if (!connection.isClosed()) {
					LOGGER.info("Connection to the database is established :)");
				}
				connection.close();
				if (connection.isClosed()) {
					LOGGER.info("Connection to the database is closed :)");
				}*/
			} catch (SQLException e) {
				LOGGER.error(e.getMessage());
			} /*finally {
				if (connection != null)
					close(connection);
			}*/

		} catch (Exception e) {
			LOGGER.error("The driver class did not load :(");
		}
		return connection;

	}

}
