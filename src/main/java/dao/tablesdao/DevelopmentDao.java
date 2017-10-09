package dao.tablesdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

//import dao.ConnectionDB;
import dao.ConnectionPoolDB;
import dao.interfacesdao.IDevelopmentDao;
import dao.tables.Development;

public class DevelopmentDao extends ConnectionPoolDB implements IDevelopmentDao{
	
private static final Logger LOGGER = Logger.getLogger(DevelopmentDao.class);

//Connection connection = getConnection();
Connection connection = ConnectionPoolDB.getInstance().getConnection();

@Override
public void insert(Development development) {
	PreparedStatement preparedStatement =null;
	String sql = "INSERT INTO DEVELOPMENT (ID_DEVELOPMENT, EMPLOYEES_ID) VALUES (?,?)";
	try{
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, development.getId_development());
		preparedStatement.setInt(2, development.getEmployees_id());
		
		preparedStatement.executeUpdate();
		
	}catch(SQLException e){
		LOGGER.error(e.getMessage());
	}finally{
		close(preparedStatement);
		close(connection);
		}
	
}

@Override
public List<Development> getAll() {
	List<Development> developmentlist = new ArrayList<>();

	String sql = "SELECT * FROM DEVELOPMENT";
	
	Statement preparedStatement =null;
	try{
		preparedStatement = connection.prepareStatement(sql);
		
	    ResultSet resulSet = preparedStatement.executeQuery(sql);
	    
	    while(resulSet.next()){
	    	
	    	Development development = new Development();
	    	
	    	development.setId_development(resulSet.getInt("ID_DEVELOPMENT"));
	    	development.setEmployees_id(resulSet.getInt("EMPLOYEES_ID"));
	    	
	    	developmentlist.add(development);
	    }
	}catch(SQLException e){
		LOGGER.error(e.getMessage());
	}finally{
		close(preparedStatement);
		close(connection);
	}
	return developmentlist;
}

@Override
public Development getById(int id) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void update(Development development) {
	PreparedStatement preparedStatement =null;
	String sql = "UPDATE DEVELOPMENT SET EMPLOYEES_ID=? WHERE ID_DEVELOPMENT=?";
	try {
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, development.getId_development());
		preparedStatement.setInt(2, development.getEmployees_id());
    	
		preparedStatement.executeUpdate();
		
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
		}
	
}

@Override
public void delete(Development development) {
	PreparedStatement preparedStatement =null;
	String sql = "DELETE FROM DEVELOPMENT WHERE ID_DEVELOPMENT=?";
	try {
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, development.getId_development());
    	
		preparedStatement.executeUpdate();
		
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
		}
	
}

}
