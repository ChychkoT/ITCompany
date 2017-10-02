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
import dao.interfacesdao.IFrontendsDao;
import dao.tables.Frontends;

public class FrontendsService extends ConnectionPoolDB implements IFrontendsDao{
	
	private static final Logger LOGGER = Logger.getLogger(FrontendsService.class);

	//Connection connection = getConnection();
	Connection connection = ConnectionPoolDB.getInstance().getConnection();
	
	@Override
	public void insert(Frontends frontends) {
		PreparedStatement preparedStatement =null;
		String sql = "INSERT INTO FRONTENDS (ID_FRONTENDS, DEVELOPMENT_ID) VALUES (?,?)";
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, frontends.getId_frontend());
			preparedStatement.setInt(2, frontends.getDevelopment_id());
			
			preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
			}
	}

	@Override
	public List<Frontends> getAll() {
		List<Frontends> frontendslist = new ArrayList<>();

		String sql = "SELECT * FROM FRONTENDS";
		
		Statement preparedStatement =null;
		try{
			preparedStatement = connection.prepareStatement(sql);
			
		    ResultSet resulSet = preparedStatement.executeQuery(sql);
		    
		    while(resulSet.next()){
		    	
		    	Frontends frontends = new Frontends();
		    	
		    	frontends.setId_frontend(resulSet.getInt("ID_FRONTENDS"));
		    	frontends.setDevelopment_id(resulSet.getInt("DEVELOPMENT_ID"));
		    	
		    	frontendslist.add(frontends);
		    }
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
		}

		return frontendslist;
	}

	@Override
	public Frontends getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Frontends frontends) {
		PreparedStatement preparedStatement =null;
		String sql = "UPDATE FRONTENDS SET DEVELOPMENT_ID=? WHERE ID_FRONTENDS=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, frontends.getId_frontend());
			preparedStatement.setInt(2, frontends.getDevelopment_id());
			
			preparedStatement.executeUpdate();
			
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement);
				close(connection);
			}
		
	}

	@Override
	public void delete(Frontends frontends) {
		PreparedStatement preparedStatement =null;
		String sql = "DELETE FROM FRONTENDS WHERE ID_FRONTENDS=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, frontends.getId_frontend());
	    	
			preparedStatement.executeUpdate();
			
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement);
				close(connection);
			}
		
		
	}

}
