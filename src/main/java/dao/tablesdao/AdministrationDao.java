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
import dao.interfacesdao.IAdministrationDao;
import dao.tables.Administration;

public class AdministrationDao extends ConnectionPoolDB implements IAdministrationDao{
	
private static final Logger LOGGER = Logger.getLogger(AdministrationDao.class);

//Connection connection = getConnection();
Connection connection = ConnectionPoolDB.getInstance().getConnection();

@Override
public void insert(Administration administration) {
	PreparedStatement preparedStatement =null;
	String sql = "INSERT INTO ADMINISTRATION (ID_ADMINISTRATION, EMPLOYEES_ID) VALUES (?,?)";
	try{
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, administration.getId_administration());
		preparedStatement.setInt(2, administration.getEmployees_id());
		
		preparedStatement.executeUpdate();
		
	}catch(SQLException e){
		LOGGER.error(e.getMessage());
	}finally{
		close(preparedStatement);
		close(connection);
		}
	
}

@Override
public List<Administration> getAll() {
	List<Administration> administrationlist = new ArrayList<>();

	String sql = "SELECT * FROM ADMINISTRATION";
	
	Statement preparedStatement =null;
	try{
		preparedStatement = connection.prepareStatement(sql);
		
	    ResultSet resulSet = preparedStatement.executeQuery(sql);
	    
	    while(resulSet.next()){
	    	
	    	Administration administration = new Administration();
	    	
	    	administration.setId_administration(resulSet.getInt("ID_ADMINISTRATION"));
	    	administration.setEmployees_id(resulSet.getInt("EMPLOYEES_ID"));
	    	
	    	administrationlist.add(administration);
	    }
	}catch(SQLException e){
		LOGGER.error(e.getMessage());
	}finally{
		close(preparedStatement);
		close(connection);
	}

	return administrationlist;
}

@Override
public Administration getById(int id) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void update(Administration administration) {
	PreparedStatement preparedStatement =null;
	String sql = "UPDATE ADMINISTRATION SET EMPLOYEES_ID=? WHERE ID_ADMINISTRATION=?";
	try {
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, administration.getId_administration());
		preparedStatement.setInt(2, administration.getEmployees_id());
    	
		preparedStatement.executeUpdate();
		
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
		}
	
}

@Override
public void delete(Administration administration) {
	PreparedStatement preparedStatement =null;
	String sql = "DELETE FROM ADMINISTRATION WHERE ID_ADMINISTRATION=?";
	try {
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, administration.getId_administration());
    	
		preparedStatement.executeUpdate();
		
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
		}
}
	

}
