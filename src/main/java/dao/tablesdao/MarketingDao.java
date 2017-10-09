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
import dao.interfacesdao.IMarketingDao;
import dao.tables.Marketing;
import dao.tables.Marketologs;

public class MarketingDao extends ConnectionPoolDB implements IMarketingDao{
	
private static final Logger LOGGER = Logger.getLogger(MarketingDao.class);

//Connection connection = getConnection();
Connection connection = ConnectionPoolDB.getInstance().getConnection();

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
	PreparedStatement preparedStatement =null;
	String sql = "SELECT ID_MARKETING, EMPLOYEES_ID FROM MARKETING WHERE ID_MARKETING=?";
	
	Marketing marketing = new Marketing();
	try {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resulSet = preparedStatement.executeQuery();
		resulSet.next();
		marketing.setId_marketing(resulSet.getInt("ID_MARKETING"));
		marketing.setEmployees_id(resulSet.getInt("EMPLOYEES_ID"));

	}catch(SQLException e){
		LOGGER.error(e.getMessage());
	}finally{
		close(preparedStatement);
		//close(connection);
		putBackConnection(connection);
	}

	return marketing;
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
