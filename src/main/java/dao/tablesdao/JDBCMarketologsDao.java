package dao.tablesdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.ConnectionPoolDB;
import dao.interfacesdao.IMarketologsDao;
import dao.tables.Address;
import dao.tables.Marketologs;

public class JDBCMarketologsDao extends ConnectionPoolDB implements IMarketologsDao{
	
	private static final Logger LOGGER = Logger.getLogger(JDBCMarketologsDao.class);

	//Connection connection = getConnection();
	Connection connection = ConnectionPoolDB.getInstance().getConnection();

	@Override
	public void insert(Marketologs marketologs) {
		PreparedStatement preparedStatement =null;
		PreparedStatement preparedStatement2 =null;
		PreparedStatement preparedStatement3 =null;
		
		String sql = "INSERT INTO MARKETOLOGS (ID_MARKETOLOGS, MARKETING_ID) VALUES (?,?)";
		String sql2 = "INSERT INTO EMPLOYEES ( ID, NAME_EMPLOYEE, DATE_OF_BIRTH,SALARY) VALUES (?,?,?,?)";
		String sql3 = "INSERT INTO MARKETING (ID_MARKETING, EMPLOYEES_ID) VALUES (?,?)";
		
		try{
			
			
			preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement2.setInt(1, marketologs.getId()); 
			preparedStatement2.setString(2, marketologs.getName_employee());
			preparedStatement2.setDate(3, marketologs.getDate_of_birth());
			preparedStatement2.setInt(4, marketologs.getSalary());
			preparedStatement2.executeUpdate();
			
			preparedStatement3 = connection.prepareStatement(sql3);
			preparedStatement3.setInt(1, marketologs.getId_marketing());
			preparedStatement3.setInt(2, marketologs.getEmployees_id());
			preparedStatement3.executeUpdate();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, marketologs.getId_marketolog());
			preparedStatement.setInt(2, marketologs.getMarketing_id());
			preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(preparedStatement2);
			close(preparedStatement3);
			ConnectionPoolDB.getInstance().putBackConnection(connection);
			}
		
	}

	@Override
	public List<Marketologs> getAll() {
		List<Marketologs> marketologslist = new ArrayList<>();
		
		String sql = "SELECT ID_MARKETOLOGS,  A_EMPLOYEES_ID, NAME_EMPLOYEE, DATE_OF_BIRTH, SALARY,COUNTRY_ID,CITY,STREET,HOUSE FROM MARKETOLOGS mar "
				+ "LEFT JOIN MARKETING m ON m.ID_MARKETING = mar.MARKETING_ID "
				+ "LEFT JOIN EMPLOYEES e ON e.ID = m.EMPLOYEES_ID "
				+ "LEFT JOIN ADDRESSES a ON e.ID = a.A_EMPLOYEES_ID "
				+ "LEFT JOIN COUNTRY c ON c.ID = a.COUNTRY_ID ";
		//String sql = "SELECT * FROM MARKETOLOGS";
		
		Statement preparedStatement =null;
		try{
			preparedStatement = connection.prepareStatement(sql);
			
		    ResultSet resulSet = preparedStatement.executeQuery(sql);

	  
		    while(resulSet.next()){
		    	
		    	Marketologs marketologs = new Marketologs();
		    	Address address = new Address();
		    	marketologs.setEmployees_id(resulSet.getInt("a.A_EMPLOYEES_ID"));
		    	//marketologs.setMarketing_id(resulSet.getInt("mar.MARKETING_ID"));
		    	marketologs.setId_marketolog(resulSet.getInt("mar.ID_MARKETOLOGS"));
		    	marketologs.setName_employee(resulSet.getString("e.NAME_EMPLOYEE"));
		    	marketologs.setDate_of_birth(resulSet.getDate("e.DATE_OF_BIRTH"));
		    	marketologs.setSalary(resulSet.getInt("e.SALARY"));
		        address.setCountry_id(resulSet.getInt("COUNTRY_ID"));
				address.setCity(resulSet.getString("CITY"));
				address.setStreet(resulSet.getString("STREET"));
				address.setHouse(resulSet.getString("HOUSE"));
		        marketologs.setAddress(address);
		    	marketologslist.add(marketologs);
		  
		    }
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			ConnectionPoolDB.getInstance().putBackConnection(connection);
		}

		return marketologslist;
	}

	@Override
	public Marketologs getById(int id) {
		
		PreparedStatement preparedStatement =null;
		
		
		String sql = "SELECT ID_MARKETOLOGS, MARKETING_ID, A_EMPLOYEES_ID, NAME_EMPLOYEE, DATE_OF_BIRTH, SALARY,COUNTRY_ID,CITY,STREET,HOUSE FROM MARKETOLOGS mar "
				+ "LEFT JOIN MARKETING m ON m.ID_MARKETING = mar.MARKETING_ID "
				+ "LEFT JOIN EMPLOYEES e ON e.ID = m.EMPLOYEES_ID "
				+ "LEFT JOIN ADDRESSES a ON e.ID = a.A_EMPLOYEES_ID "
				+ "LEFT JOIN COUNTRY c ON c.ID = a.COUNTRY_ID "
				+ "WHERE mar.ID_MARKETOLOGS=?";
		
		Marketologs marketologs = new Marketologs();
		//Address address = new Address();
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resulSet = preparedStatement.executeQuery();
			resulSet.next();
			marketologs.setEmployees_id(resulSet.getInt("A_EMPLOYEES_ID"));
			marketologs.setId_marketolog(resulSet.getInt("ID_MARKETOLOGS"));
			marketologs.setMarketing_id(resulSet.getInt("MARKETING_ID"));
			marketologs.setName_employee(resulSet.getString("NAME_EMPLOYEE"));
			marketologs.setDate_of_birth(resulSet.getDate("DATE_OF_BIRTH"));
			marketologs.setSalary(resulSet.getInt("SALARY")); 
			
			/*address.setCountry_id(resulSet.getInt("COUNTRY_ID"));
			address.setCity(resulSet.getString("CITY"));
			address.setStreet(resulSet.getString("STREET"));
			address.setHouse(resulSet.getString("HOUSE"));*/
			LOGGER.info(marketologs);
			//LOGGER.info("Marketolog's address: " + address);
	    	
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			ConnectionPoolDB.getInstance().putBackConnection(connection);
		}
	
		return marketologs;
		
	}

	@Override
	public void update(Marketologs marketologs) {
		
		PreparedStatement preparedStatement1 =null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;

		String sql1 = "UPDATE EMPLOYEES SET NAME_EMPLOYEE=?, DATE_OF_BIRTH=?, SALARY=? WHERE ID=?";
		String sql2 = "UPDATE MARKETING SET EMPLOYEES_ID=? WHERE ID_MARKETING=?";
		String sql3 = "UPDATE MARKETOLOGS SET MARKETING_ID=? WHERE ID_MARKETOLOGS=?";

		try {

			preparedStatement1 = connection.prepareStatement(sql1);
			//preparedStatement1.setInt(1, marketologs.getId());
			preparedStatement1.setString(2, marketologs.getName_employee());
			preparedStatement1.setDate(3, marketologs.getDate_of_birth());
			preparedStatement1.setInt(4, marketologs.getSalary());			
			preparedStatement1.executeUpdate();
			
			preparedStatement2 = connection.prepareStatement(sql2);
			//preparedStatement2.setInt(1, marketologs.getId_marketing());
			preparedStatement2.setInt(2, marketologs.getEmployees_id());
			preparedStatement2.executeUpdate();
			
			preparedStatement3 = connection.prepareStatement(sql3);
			//preparedStatement3.setInt(1, marketologs.getId_marketolog());
			preparedStatement3.setInt(2, marketologs.getMarketing_id());
			preparedStatement3.executeUpdate();
			
		
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement1);
				close(preparedStatement2);
				close(preparedStatement3);
				ConnectionPoolDB.getInstance().putBackConnection(connection);;
			}
		
		
	}

	@Override
	public void delete(Marketologs marketologs) {
		PreparedStatement preparedStatement1 =null;
		PreparedStatement preparedStatement2 =null;
		PreparedStatement preparedStatement3 =null;
		String sql1 = "DELETE FROM EMPLOYEES  WHERE ID=?";
		String sql2 = "DELETE FROM MARKETING  WHERE ID_MARKETING=?";
		String sql3 = "DELETE FROM MARKETOLOGS WHERE ID_MARKETOLOGS=?";
		try {
			
			preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement1.setInt(1, marketologs.getId());
			preparedStatement1.executeUpdate();
			
			preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement2.setInt(1, marketologs.getId_marketing());
			preparedStatement2.executeUpdate();
			
			preparedStatement3 = connection.prepareStatement(sql3);
			preparedStatement3.setInt(1, marketologs.getId_marketolog());
			preparedStatement3.executeUpdate();
			
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement1);
				close(preparedStatement2);
				close(preparedStatement3);
				ConnectionPoolDB.getInstance().putBackConnection(connection);
			}
		
	}
}
