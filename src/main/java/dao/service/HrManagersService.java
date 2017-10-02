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
import dao.interfacesdao.IHrManagersDao;
import dao.tables.HrManagers;

public class HrManagersService extends ConnectionPoolDB implements IHrManagersDao{
	
	private static final Logger LOGGER = Logger.getLogger(HrManagersService.class);

	//Connection connection = getConnection();
	Connection connection = ConnectionPoolDB.getInstance().getConnection();

	@Override
	public void insert(HrManagers hrManagers) {
		PreparedStatement preparedStatement =null;
		String sql = "INSERT INTO HRMANAGERS (ID_HRMANAGERS, ADMINISTRATION_ID) VALUES (?,?)";
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, hrManagers.getId_hrmanagers());
			preparedStatement.setInt(2, hrManagers.getAdministration_id());
			
			preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
			}
	}

	@Override
	public List<HrManagers> getAll() {
		List<HrManagers> hrmanagerslist = new ArrayList<>();

		String sql = "SELECT * FROM HRMANAGERS";
		
		Statement preparedStatement =null;
		try{
			preparedStatement = connection.prepareStatement(sql);
			
		    ResultSet resulSet = preparedStatement.executeQuery(sql);
		    
		    while(resulSet.next()){
		    	
		    	HrManagers hrManagers = new HrManagers();
		    	
		    	hrManagers.setId_hrmanagers(resulSet.getInt("ID_HRMANAGERS"));
		    	hrManagers.setAdministration_id(resulSet.getInt("ADMINISTRATION_ID"));
		    	
		    	hrmanagerslist.add(hrManagers);
		    }
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
		}

		return hrmanagerslist;
	}

	@Override
	public HrManagers getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(HrManagers hrManagers) {
		PreparedStatement preparedStatement =null;
		String sql = "UPDATE HRMANAGERS SET ADMINISTRATION_ID=? WHERE ID_HRMANAGERS=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, hrManagers.getId_hrmanagers());
			preparedStatement.setInt(2, hrManagers.getAdministration_id());
	    	
			preparedStatement.executeUpdate();
			
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement);
				close(connection);
			}
		
	}

	@Override
	public void delete(HrManagers hrManagers) {
		PreparedStatement preparedStatement =null;
		String sql = "DELETE FROM HRMANAGERS WHERE ID_HRMANAGERS=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, hrManagers.getId_hrmanagers());
	    	
			preparedStatement.executeUpdate();
			
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement);
				close(connection);
			}
		
		
	}
}
