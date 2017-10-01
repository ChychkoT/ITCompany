package dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.ConnectionDB;
import dao.interfacesdao.IMarketingDao;
import dao.tables.Administration;
import dao.tables.Marketing;

public class MarketingService extends ConnectionDB implements IMarketingDao{
	
private static final Logger LOGGER = Logger.getLogger(MarketingService.class);

Connection connection = getConnection();

@Override
public void insert(Marketing marketing) {
	PreparedStatement preparedStatement =null;
	String sql = "INSERT INTO MARKETING (ID_MARKETING, EMPLOYEES_ID) VALUES (?,?)";
	try{
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, marketing.getId_marketing());
		preparedStatement.setInt(2, marketing.getEmployees_id());
		
		preparedStatement.executeUpdate();
		
	}catch(SQLException e){
		LOGGER.error(e.getMessage());
	}finally{
		close(preparedStatement);
		close(connection);
		}
}

@Override
public List<Marketing> getAll() {
	List<Marketing> marketinglist = new ArrayList<>();

	String sql = "SELECT * FROM MARKETING";
	
	Statement preparedStatement =null;
	try{
		preparedStatement = connection.prepareStatement(sql);
		
	    ResultSet resulSet = preparedStatement.executeQuery(sql);
	    
	    while(resulSet.next()){
	    	
	    	Marketing marketing = new Marketing();
	    	
	    	marketing.setId_marketing(resulSet.getInt("ID_MARKETING"));
	    	marketing.setEmployees_id(resulSet.getInt("EMPLOYEES_ID"));
	    	
	    	marketinglist.add(marketing);
	    }
	}catch(SQLException e){
		LOGGER.error(e.getMessage());
	}finally{
		close(preparedStatement);
		close(connection);
	}

	return marketinglist;
}

@Override
public Marketing getById(int id) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void update(Marketing marketing) {
	PreparedStatement preparedStatement =null;
	String sql = "UPDATE MARKETING SET EMPLOYEES_ID=? WHERE ID_MARKETING=?";
	try {
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, marketing.getId_marketing());
		preparedStatement.setInt(2, marketing.getEmployees_id());
    	
		preparedStatement.executeUpdate();
		
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
		}
	
}

@Override
public void delete(Marketing marketing) {
	PreparedStatement preparedStatement =null;
	String sql = "DELETE FROM MARKETING WHERE ID_MARKETING=?";
	try {
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, marketing.getId_marketing());
    	
		preparedStatement.executeUpdate();
		
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
		}
	
}

}
