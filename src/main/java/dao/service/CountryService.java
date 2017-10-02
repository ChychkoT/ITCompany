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
import dao.interfacesdao.ICountryDao;
import dao.tables.Country;

public class CountryService extends ConnectionPoolDB implements ICountryDao{
	
private static final Logger LOGGER = Logger.getLogger(CountryService.class);
	
	//Connection connection = getConnection();
   Connection connection = ConnectionPoolDB.getInstance().getConnection();
     

	@Override
	public void insert(Country country) {
		PreparedStatement preparedStatement =null;
		String sql = "INSERT INTO COUNTRY (ID, COUNTRY_NAME) VALUES (?,?)";
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, country.getId());
			preparedStatement.setString(2, country.getCountry_name());
			
			preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
			}
		
	}

	@Override
	public List<Country> getAll() {

		List<Country> countrylist = new ArrayList<>();

		String sql = "SELECT * FROM COUNTRY";
		
		Statement preparedStatement =null;
		try{
			preparedStatement = connection.prepareStatement(sql);
			
		    ResultSet resulSet = preparedStatement.executeQuery(sql);
		    
		    while(resulSet.next()){
		    	
		    	Country country = new Country();
		    	
		    	country.setId(resulSet.getInt("ID"));
		    	country.setCountry_name(resulSet.getString("COUNTRY_NAME"));
		    	
		    	countrylist.add(country);
		    }
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
		}

		return countrylist;
	}

	@Override
	public Country getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Country country) {
		PreparedStatement preparedStatement =null;
		String sql = "UPDATE COUNTRY SET COUNTRY_NAME=? WHERE ID=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, country.getId());
			preparedStatement.setString(2, country.getCountry_name());
	    	
			preparedStatement.executeUpdate();
			
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement);
				close(connection);
			}
	}

	@Override
	public void delete(Country country) {
		
		PreparedStatement preparedStatement =null;
		String sql = "DELETE FROM COUNTRY WHERE ID=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, country.getId());
	    	
			preparedStatement.executeUpdate();
			
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement);
				close(connection);
			}
		
		
	}

}
