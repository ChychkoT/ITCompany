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
import dao.interfacesdao.IMarketologsDao;
import dao.interfacesdao.ISalesDao;
import dao.tables.Marketologs;
import dao.tables.Sales;

public class SalesService extends ConnectionDB implements ISalesDao{
	
	private static final Logger LOGGER = Logger.getLogger(SalesService.class);

	Connection connection = getConnection();

	@Override
	public void insert(Sales sales) {
		PreparedStatement preparedStatement =null;
		String sql = "INSERT INTO SALES (ID_SALES, MARKETING_ID) VALUES (?,?)";
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, sales.getId_sale());
			preparedStatement.setInt(2, sales.getMarketing_id());
			
			preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
			}
		
	}

	@Override
	public List<Sales> getAll() {
		List<Sales> saleslist = new ArrayList<>();

		String sql = "SELECT * FROM SALES";
		
		Statement preparedStatement =null;
		try{
			preparedStatement = connection.prepareStatement(sql);
			
		    ResultSet resulSet = preparedStatement.executeQuery(sql);
		    
		    while(resulSet.next()){
		    	
		    	Sales sales = new Sales();
		    	
		    	sales.setId_sale(resulSet.getInt("ID_SALES"));
		    	sales.setMarketing_id(resulSet.getInt("MARKETING_ID"));
		    	
		    	saleslist.add(sales);
		    }
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
		}

		return saleslist;
	}

	@Override
	public Sales getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Sales sales) {
		PreparedStatement preparedStatement =null;
		String sql = "UPDATE SALES SET MARKETING_ID=? WHERE ID_SALES=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, sales.getId_sale());
			preparedStatement.setInt(2, sales.getMarketing_id());
			
			preparedStatement.executeUpdate();
			
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement);
				close(connection);
			}
		
	}

	@Override
	public void delete(Sales sales) {
		PreparedStatement preparedStatement =null;
		String sql = "DELETE FROM SALES WHERE ID_SALES=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, sales.getId_sale());
	    	
			preparedStatement.executeUpdate();
			
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement);
				close(connection);
			}
		
	}


}
