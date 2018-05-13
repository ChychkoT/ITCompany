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
import dao.interfacesdao.ISalesDao;
import dao.tables.Address;
import dao.tables.Sales;

public class JDBCSalesDao extends ConnectionPoolDB implements ISalesDao{
	
	private static final Logger LOGGER = Logger.getLogger(JDBCSalesDao.class);

	//Connection connection = getConnection();
	Connection connection = ConnectionPoolDB.getInstance().getConnection();

	@Override
	public void insert(Sales sales) {
		PreparedStatement preparedStatement =null;
		PreparedStatement preparedStatement2 =null;
		PreparedStatement preparedStatement3 =null;
		
		try{
			
            preparedStatement = connection.prepareStatement("INSERT INTO EMPLOYEES ( ID, NAME_EMPLOYEE, DATE_OF_BIRTH,SALARY) VALUES (?,?,?,?)");
			preparedStatement.setInt(1, sales.getId()); 
			preparedStatement.setString(2, sales.getName_employee());
			preparedStatement.setDate(3, sales.getDate_of_birth());
			preparedStatement.setInt(4, sales.getSalary());
			preparedStatement.executeUpdate();
			
			preparedStatement2 = connection.prepareStatement("INSERT INTO MARKETING (ID_MARKETING, EMPLOYEES_ID) VALUES (?,?)");
			preparedStatement2.setInt(1, sales.getId_marketing());
			preparedStatement2.setInt(2, sales.getEmployees_id());
			preparedStatement2.executeUpdate();
			
			preparedStatement3 = connection.prepareStatement("INSERT INTO SALES (ID_SALES, MARKETING_ID) VALUES (?,?)");	
			preparedStatement3.setInt(1, sales.getId_sale());
			preparedStatement3.setInt(2, sales.getMarketing_id());
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
	public List<Sales> getAll() {
		List<Sales> saleslist = new ArrayList<>();

		String sql = "SELECT ID_SALES, A_EMPLOYEES_ID, NAME_EMPLOYEE, DATE_OF_BIRTH, SALARY,COUNTRY_ID,CITY,STREET,HOUSE FROM SALES s "
				+ "LEFT JOIN MARKETING m ON m.ID_MARKETING = s.MARKETING_ID "
				+ "LEFT JOIN EMPLOYEES e ON e.ID = m.EMPLOYEES_ID "
				+ "LEFT JOIN ADDRESSES a ON e.ID = a.A_EMPLOYEES_ID "
				+ "LEFT JOIN COUNTRY c ON c.ID = a.COUNTRY_ID ";
		
		Statement preparedStatement =null;
		try{
			preparedStatement = connection.prepareStatement(sql);
			
		    ResultSet resulSet = preparedStatement.executeQuery(sql);
		    
		    while(resulSet.next()){
		    	
		    	Sales sales = new Sales();
		    	Address address = new Address();
		    	
		    	sales.setEmployees_id(resulSet.getInt("m.EMPLOYEES_ID"));
		    	sales.setId_marketing(resulSet.getInt("m.ID_MARKETING"));
		    	sales.setId_sale(resulSet.getInt("s.ID_SALES"));
		    	sales.setName_employee(resulSet.getString("e.NAME_EMPLOYEE"));
		    	sales.setDate_of_birth(resulSet.getDate("e.DATE_OF_BIRTH"));
		    	sales.setSalary(resulSet.getInt("e.SALARY")); 	
		    	address.setCountry_id(resulSet.getInt("COUNTRY_ID"));
				address.setCity(resulSet.getString("CITY"));
				address.setStreet(resulSet.getString("STREET"));
				address.setHouse(resulSet.getString("HOUSE"));
				sales.setAddress(address);
		    	saleslist.add(sales);
		    }
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			ConnectionPoolDB.getInstance().putBackConnection(connection);
		}

		return saleslist;
	}

	@Override
	public Sales getById(int id) {
	PreparedStatement preparedStatement =null;
	
	String sql = "SELECT ID_SALES, MARKETING_ID, A_EMPLOYEES_ID, NAME_EMPLOYEE, DATE_OF_BIRTH, SALARY,COUNTRY_ID,CITY,STREET,HOUSE FROM SALES s "
			+ "LEFT JOIN MARKETING m ON m.ID_MARKETING = s.MARKETING_ID "
			+ "LEFT JOIN EMPLOYEES e ON e.ID = m.EMPLOYEES_ID "
			+ "LEFT JOIN ADDRESSES a ON e.ID = a.A_EMPLOYEES_ID "
			+ "LEFT JOIN COUNTRY c ON c.ID = a.COUNTRY_ID "
			+ "WHERE s.ID_SALES=?";
		
		Sales sales = new Sales();
		try {
			 preparedStatement = connection.prepareStatement(sql);
			 ResultSet resulSet = preparedStatement.executeQuery(sql);
			 preparedStatement.setInt(1, id);
			    sales.setEmployees_id(resulSet.getInt("m.EMPLOYEES_ID"));
		    	sales.setMarketing_id(resulSet.getInt("s.MARKETING_ID"));
		    	sales.setId_sale(resulSet.getInt("s.ID_SALES"));
		    	sales.setName_employee(resulSet.getString("e.NAME_EMPLOYEE"));
		    	sales.setDate_of_birth(resulSet.getDate("e.DATE_OF_BIRTH"));
		    	sales.setSalary(resulSet.getInt("e.SALARY")); 	
		    	
		    	System.out.println(sales);
			
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			ConnectionPoolDB.getInstance().putBackConnection(connection);
		}
	
		return sales;

	}
	

	@Override
	public void update(Sales sales) {
		PreparedStatement preparedStatement1 =null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
		
		String sql1 = "UPDATE EMPLOYEES SET NAME_EMPLOYEE=?, DATE_OF_BIRTH=?, SALARY=? WHERE ID=?";
		String sql2 = "UPDATE MARKETING SET EMPLOYEES_ID=? WHERE ID_MARKETING=?";
		String sql3 = "UPDATE SALES SET MARKETING_ID=? WHERE ID_SALES=?";
		
		try {
			
			preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement1.setInt(1, sales.getId()); 
			preparedStatement1.setString(2, sales.getName_employee());
			preparedStatement1.setDate(3, sales.getDate_of_birth());
			preparedStatement1.setInt(4, sales.getSalary());
			preparedStatement1.executeUpdate();
			
			preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement2.setInt(1, sales.getId_marketing());
			preparedStatement2.setInt(2, sales.getEmployees_id());
			preparedStatement2.executeUpdate();
			
			preparedStatement3 = connection.prepareStatement(sql3);
			preparedStatement3.setInt(1, sales.getId_sale());
			preparedStatement3.setInt(2, sales.getMarketing_id());
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

	@Override
	public void delete(Sales sales) {
		PreparedStatement preparedStatement1 =null;
		PreparedStatement preparedStatement2 =null;
		PreparedStatement preparedStatement3 =null;
		String sql1 = "DELETE FROM EMPLOYEES  WHERE ID=?";
		String sql2 = "DELETE FROM MARKETING  WHERE ID_MARKETING=?";
		String sql3 = "DELETE FROM SALES WHERE ID_SALES=?";
		try {
			
			preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement1.setInt(1, sales.getId());
			preparedStatement1.executeUpdate();
			
			preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement2.setInt(1, sales.getId_marketing());
			preparedStatement2.executeUpdate();
			
			preparedStatement3 = connection.prepareStatement(sql3);
			preparedStatement3.setInt(1, sales.getId_sale());
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
