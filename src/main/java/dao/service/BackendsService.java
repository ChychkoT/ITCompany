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
import dao.interfacesdao.IBackendsDao;
import dao.tables.Backends;
import dao.tables.Frontends;

public class BackendsService  extends ConnectionDB implements IBackendsDao{
	
	private static final Logger LOGGER = Logger.getLogger(BackendsService.class);

	Connection connection = getConnection();

	@Override
	public void insert(Backends backends) {
		PreparedStatement preparedStatement =null;
		String sql = "INSERT INTO BACKENDS (ID_BACKENDS, DEVELOPMENT_ID) VALUES (?,?)";
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, backends.getId_backend());
			preparedStatement.setInt(2, backends.getDevelopment_id());
			
			preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
			}
	}

	@Override
	public List<Backends> getAll() {
		List<Backends> backendslist = new ArrayList<>();

		String sql = "SELECT * FROM BACKENDS";
		
		Statement preparedStatement =null;
		try{
			preparedStatement = connection.prepareStatement(sql);
			
		    ResultSet resulSet = preparedStatement.executeQuery(sql);
		    
		    while(resulSet.next()){
		    	
		    	Backends backends = new Backends();
		    	
		    	backends.setId_backend(resulSet.getInt("ID_BACKENDS"));
		    	backends.setDevelopment_id(resulSet.getInt("DEVELOPMENT_ID"));
		    	
		    	backendslist.add(backends);
		    }
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
		}

		return backendslist;
	}

	@Override
	public Backends getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Backends backends) {
		PreparedStatement preparedStatement =null;
		String sql = "UPDATE BACKENDS SET DEVELOPMENT_ID=? WHERE ID_FRONTENDS=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, backends.getId_backend());
			preparedStatement.setInt(2, backends.getDevelopment_id());
			
			preparedStatement.executeUpdate();
			
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement);
				close(connection);
			}
	}

	@Override
	public void delete(Backends backends) {
		PreparedStatement preparedStatement =null;
		String sql = "DELETE FROM BACKENDS WHERE ID_BACKENDS=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, backends.getId_backend());
	    	
			preparedStatement.executeUpdate();
			
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement);
				close(connection);
			}
		
	}
}
