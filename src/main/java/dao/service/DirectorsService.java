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
import dao.interfacesdao.IDirectorsDao;
import dao.tables.Directors;

public class DirectorsService extends ConnectionDB implements IDirectorsDao{
	
	private static final Logger LOGGER = Logger.getLogger(DirectorsService.class);

	Connection connection = getConnection();

	@Override
	public void insert(Directors directors) {
		PreparedStatement preparedStatement =null;
		String sql = "INSERT INTO DIRECTORS (ID_DIRECTORS, ADMINISTRATION_ID) VALUES (?,?)";
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, directors.getId_directors());
			preparedStatement.setInt(2, directors.getAdministration_id());
			
			preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
			}
		
	}

	@Override
	public List<Directors> getAll() {
		List<Directors> directorslist = new ArrayList<>();

		String sql = "SELECT * FROM DIRECTORS";
		
		Statement preparedStatement =null;
		try{
			preparedStatement = connection.prepareStatement(sql);
			
		    ResultSet resulSet = preparedStatement.executeQuery(sql);
		    
		    while(resulSet.next()){
		    	
		    	Directors directors = new Directors();
		    	
		    	directors.setId_directors(resulSet.getInt("ID_DIRECTORS"));
		    	directors.setAdministration_id(resulSet.getInt("ADMINISTRATION_ID"));
		    	
		    	directorslist.add(directors);
		    }
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
		}

		return directorslist;
	
	}

	@Override
	public Directors getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Directors directors) {
		PreparedStatement preparedStatement =null;
		String sql = "UPDATE DIRECTORS SET ADMINISTRATION_ID=? WHERE ID_DIRECTORS=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, directors.getId_directors());
			preparedStatement.setInt(2, directors.getAdministration_id());
	    	
			preparedStatement.executeUpdate();
			
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement);
				close(connection);
			}
		
	}

	@Override
	public void delete(Directors directors) {
		PreparedStatement preparedStatement =null;
		String sql = "DELETE FROM DIRECTORS WHERE ID_DIRECTORS=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, directors.getId_directors());
	    	
			preparedStatement.executeUpdate();
			
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement);
				close(connection);
			}
		
	}

}
