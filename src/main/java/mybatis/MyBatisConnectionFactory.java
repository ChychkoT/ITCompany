package mybatis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ibatis.common.resources.Resources;


import dao.ConnectionPoolDB;

public class MyBatisConnectionFactory {
	
	private static final Logger LOGGER = LogManager.getLogger(MyBatisConnectionFactory.class);
	
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSessionFactory getSqlSessionFactory() {
		String resource = "database/mybatis/mybatis.xml";
		InputStream  reader = null; 
        try {
        	reader = Resources.getResourceAsStream(resource);
 
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
        	LOGGER.info(fileNotFoundException);
        }
        catch (IOException iOException) {
        	LOGGER.info(iOException); 
        }
        return sqlSessionFactory;
    }
   /* public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }*/
	
	protected void close(AutoCloseable resourse) {
		if (resourse != null)
			try {
				resourse.close();
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
	}

	protected Connection getConnection() throws InterruptedException {
		Connection connection = null;
		connection = ConnectionPoolDB.getInstance().getConnection();
		return connection;
	}
	}

