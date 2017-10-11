package mybatis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

public class MyBatisConnectionFactory {
	
	private static SqlSessionFactory sqlSessionFactory;
	 
	public static SqlSessionFactory getSqlSessionFactory() {
        try {
 
            String resource = "database/mybatis.xml";
            InputStream  reader = Resources.getResourceAsStream(resource);
 
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return sqlSessionFactory;
    }
   /* public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }*/
	
	
	}

