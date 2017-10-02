package dao.service;

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
import dao.interfacesdao.IMarketologsDao;
import dao.tables.Marketologs;

public class MarketologsService extends ConnectionPoolDB implements IMarketologsDao{
	
	private static final Logger LOGGER = Logger.getLogger(MarketologsService.class);

	//Connection connection = getConnection();
	Connection connection = ConnectionPoolDB.getInstance().getConnection();

	@Override
	public void insert(Marketologs marketologs) {
		PreparedStatement preparedStatement =null;
		String sql = "INSERT INTO MARKETOLOGS (ID_MARKETOLOGS, MARKETING_ID) VALUES (?,?)";
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, marketologs.getId_marketolog());
			preparedStatement.setInt(2, marketologs.getMarketing_id());
			
			preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
			}
		
	}

	@Override
	public List<Marketologs> getAll() {
		List<Marketologs> marketologslist = new ArrayList<>();

		String sql = "SELECT * FROM MARKETOLOGS";
		
		Statement preparedStatement =null;
		try{
			preparedStatement = connection.prepareStatement(sql);
			
		    ResultSet resulSet = preparedStatement.executeQuery(sql);
		    
		    while(resulSet.next()){
		    	
		    	Marketologs marketologs = new Marketologs();
		    	
		    	marketologs.setId_marketolog(resulSet.getInt("ID_MARKETOLOGS"));
		    	marketologs.setMarketing_id(resulSet.getInt("MARKETING_ID"));
		    	
		    	marketologslist.add(marketologs);
		    }
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
		}

		return marketologslist;
	}

	@Override
	public Marketologs getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Marketologs marketologs) {
		PreparedStatement preparedStatement =null;
		String sql = "UPDATE MARKETOLOGS SET MARKETING_ID=? WHERE ID_MARKETOLOGS=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, marketologs.getId_marketolog());
			preparedStatement.setInt(2, marketologs.getMarketing_id());
			
			preparedStatement.executeUpdate();
			
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement);
				close(connection);
			}
		
		
	}

	@Override
	public void delete(Marketologs marketologs) {
		PreparedStatement preparedStatement =null;
		String sql = "DELETE FROM MARKETOLOGS WHERE ID_MARKETOLOGS=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, marketologs.getId_marketolog());
	    	
			preparedStatement.executeUpdate();
			
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement);
				close(connection);
			}
		
	}
}
