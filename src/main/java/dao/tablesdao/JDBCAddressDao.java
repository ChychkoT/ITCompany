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
import dao.interfacesdao.IAddressDao;
import dao.tables.Address;

public class JDBCAddressDao extends ConnectionPoolDB implements IAddressDao {
	

	private static final Logger LOGGER = Logger.getLogger(JDBCAddressDao.class);
	
	//Connection connection = getConnection();
	Connection connection = ConnectionPoolDB.getInstance().getConnection();

	@Override
	public void insert(Address address) {
		PreparedStatement preparedStatement =null;
		String sql = "INSERT INTO ADDRESSES (ID, COUNTRY_ID, CITY,STREET,HOUSE,A_EMPLOYEES_ID) VALUES (?,?,?,?,?,?)";
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, address.getId());
			preparedStatement.setInt(2, address.getCountry_id());
			preparedStatement.setString(3, address.getCity());
			preparedStatement.setString(4, address.getStreet());
			preparedStatement.setString(5, address.getHouse());
			preparedStatement.setInt(6, address.getEmployees_id());
			
			preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			ConnectionPoolDB.getInstance().putBackConnection(connection);
		}
		
	}

	@Override
	public List<Address> getAll() {
		
		List<Address> addresslist = new ArrayList<>();

		String sql = "SELECT ID, COUNTRY_ID, CITY,STREET,HOUSE,A_EMPLOYEES_ID FROM ADDRESSES";
		               
		
		Statement preparedStatement =null;
		try{
			preparedStatement = connection.prepareStatement(sql);
			
		    ResultSet resulSet = preparedStatement.executeQuery(sql);
		    
		    while(resulSet.next()){
		    	
		    	Address address = new Address();
		    	
		    	address.setId(resulSet.getInt("ID"));
		    	address.setCountry_id(resulSet.getInt("COUNTRY_ID"));
		    	address.setCity(resulSet.getString("CITY"));
		    	address.setStreet(resulSet.getString("STREET"));
		    	address.setHouse(resulSet.getString("HOUSE"));
		    	address.setEmployees_id(resulSet.getInt("A_EMPLOYEES_ID"));
		    	
		    	addresslist.add(address);
		    }
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			ConnectionPoolDB.getInstance().putBackConnection(connection);
		}

		return addresslist;
	}

	@Override
	public Address getById(int id) {
		PreparedStatement preparedStatement =null;
		String sql = "SELECT ID, COUNTRY_ID, COUNTRY_NAME, CITY,STREET,HOUSE, A_EMPLOYEES_ID FROM ADDRESSES a WHERE ID=?";
				//+ "LEFT JOIN COUNTRY c ON c.ID = a.COUNTRY_ID  ";
		
		Address address = new Address();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resulSet = preparedStatement.executeQuery();
			resulSet.next();
	
			address.setId(resulSet.getInt("ID"));
	    	address.setCountry_id(resulSet.getInt("COUNTRY_ID"));
	    	address.setCity(resulSet.getString("CITY"));
	    	address.setStreet(resulSet.getString("STREET"));
	    	address.setHouse(resulSet.getString("HOUSE"));
	    	address.setEmployees_id(resulSet.getInt("A_EMPLOYEES_ID"));
	    	//address.setC(resulSet.getString("COUNTRY_NAME"));
	    	
	    	LOGGER.info(address);
		    
			
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			ConnectionPoolDB.getInstance().putBackConnection(connection);
		}
	
		return address;
	}

	@Override
	public void update(Address address) {
		PreparedStatement preparedStatement =null;
		//String sql = "UPDATE ADDRESSES SET COUNTRY_ID=?, CITY=?,STREET=?,HOUSE=?,A_EMPLOYEES_ID=? WHERE ID=?";
		String sql = "UPDATE ADDRESSES SET COUNTRY_ID=?, CITY=?,STREET=?,HOUSE=? WHERE ID=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, address.getId());
			//preparedStatement.setInt(2, address.getCountry_id());
			preparedStatement.setString(2, address.getCity());
			preparedStatement.setString(3, address.getStreet());
			preparedStatement.setString(4, address.getHouse());
			preparedStatement.setInt(5, address.getEmployees_id());
			preparedStatement.executeUpdate();
			
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement);
				ConnectionPoolDB.getInstance().putBackConnection(connection);
			}
		
	}

	@Override
	public void delete(Address address) {
		PreparedStatement preparedStatement =null;
		String sql = "DELETE FROM ADDRESSES WHERE ID=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, address.getId());
	    	
			preparedStatement.executeUpdate();
			
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement);
				ConnectionPoolDB.getInstance().putBackConnection(connection);
			}
		
	}

}
