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
import dao.interfacesdao.IAddressDao;
import dao.tables.Address;
import dao.tables.Employees;

public class AddressService extends ConnectionDB implements IAddressDao {
	

	private static final Logger LOGGER = Logger.getLogger(AddressService.class);
	
	Connection connection = getConnection();

	@Override
	public void insert(Address address) {
		PreparedStatement preparedStatement =null;
		String sql = "INSERT INTO ADDRESSES (ID, COUNTRY_ID, CITY,STREET,HOUSE,EMPLOYEES_ID) VALUES (?,?,?,?,?,?)";
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, address.getId());
			preparedStatement.setInt(2, address.getContry_id());
			preparedStatement.setString(3, address.getCity());
			preparedStatement.setString(4, address.getHouse());
			preparedStatement.setInt(5, address.getEmployees_id());
			
			preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
		}
		
	}

	@Override
	public List<Address> getAll() {
		
		List<Address> addresslist = new ArrayList<>();

		String sql = "SELECT ID, COUNTRY_ID, CITY,STREET,HOUSE,EMPLOYEES_ID FROM ADDRESSES";
		
		Statement preparedStatement =null;
		try{
			preparedStatement = connection.prepareStatement(sql);
			
		    ResultSet resulSet = preparedStatement.executeQuery(sql);
		    
		    while(resulSet.next()){
		    	
		    	Address address = new Address();
		    	
		    	address.setId(resulSet.getInt("ID"));
		    	address.setContry_id(resulSet.getInt("COUNTRY_ID"));
		    	address.setCity(resulSet.getString("CITY"));
		    	address.setStreet(resulSet.getString("STREET"));
		    	address.setHouse(resulSet.getString("HOUSE"));
		    	address.setEmployees_id(resulSet.getInt("EMPLOYEES_ID"));
		    	
		    	addresslist.add(address);
		    }
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
		}

		return addresslist;
	}

	@Override
	public Address getById(int id) {
		PreparedStatement preparedStatement =null;
		String sql = "SELECT ID, COUNTRY_ID, CITY,STREET,HOUSE,EMPLOYEES_ID FROM ADDRESSES WHERE ID=?";
		
		Address address = new Address();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resulSet = preparedStatement.executeQuery();
			//resulSet.next();
	
			address.setId(resulSet.getInt("ID"));
	    	address.setContry_id(resulSet.getInt("COUNTRY_ID"));
	    	address.setCity(resulSet.getString("CITY"));
	    	address.setStreet(resulSet.getString("STREET"));
	    	address.setHouse(resulSet.getString("HOUSE"));
	    	address.setEmployees_id(resulSet.getInt("EMPLOYEES_ID"));
	    
	    	preparedStatement.executeUpdate();
		    
			
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
		}
	
		return address;
	}

	@Override
	public void update(Address address) {
		PreparedStatement preparedStatement =null;
		String sql = "UPDATE ADDRESSES SET COUNTRY_ID=?, CITY=?,STREET=?,HOUSE=?,EMPLOYEES_ID=? WHERE ID=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, address.getId());
			preparedStatement.setInt(2, address.getContry_id());
			preparedStatement.setString(3, address.getCity());
			preparedStatement.setString(4, address.getHouse());
			preparedStatement.setInt(5, address.getEmployees_id());
	    	
			preparedStatement.executeUpdate();
			
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement);
				close(connection);
			}
		
	}

	@Override
	public void delete(Address address) {
		PreparedStatement preparedStatement =null;
		String sql = "DELETE FROM EMPLOYEES WHERE ID=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, address.getId());
	    	
			preparedStatement.executeUpdate();
			
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement);
				close(connection);
			}
		
	}

}
