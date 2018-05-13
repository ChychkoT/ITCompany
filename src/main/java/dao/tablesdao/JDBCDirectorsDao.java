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
import dao.interfacesdao.IDirectorsDao;
import dao.tables.Address;
import dao.tables.Directors;
import dao.tables.HrManagers;

public class JDBCDirectorsDao extends ConnectionPoolDB implements IDirectorsDao{
	
	private static final Logger LOGGER = Logger.getLogger(JDBCDirectorsDao.class);

	Connection connection = ConnectionPoolDB.getInstance().getConnection();
	
	@Override
	public void insert(Directors directors) {
		PreparedStatement preparedStatement1 =null;
		PreparedStatement preparedStatement2 =null;
		PreparedStatement preparedStatement3 =null;
		
		
		String sql1 = "INSERT INTO EMPLOYEES ( ID, NAME_EMPLOYEE, DATE_OF_BIRTH,SALARY) VALUES (?,?,?,?)";
		String sql2 = "INSERT INTO ADMINISTRATION (ID_ADMINISTRATION, EMPLOYEES_ID) VALUES (?,?)";
		String sql3 = "INSERT INTO DIRECTORS (ID_DIRECTORS, ADMINISTRATION_ID) VALUES (?,?)";
		try{
			
			preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement1.setInt(1, directors.getId()); 
			preparedStatement1.setString(2, directors.getName_employee());
			preparedStatement1.setDate(3, directors.getDate_of_birth());
			preparedStatement1.setInt(4, directors.getSalary());
			preparedStatement1.executeUpdate();
			
			preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement2.setInt(1, directors.getId_administration());
			preparedStatement2.setInt(2, directors.getEmployees_id());
			preparedStatement2.executeUpdate();
			
			preparedStatement3 = connection.prepareStatement(sql3);
			preparedStatement3.setInt(1, directors.getId_directors());
			preparedStatement3.setInt(2, directors.getAdministration_id());
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
	public List<Directors> getAll() {
		List<Directors> directorslist = new ArrayList<>();
		String sql = "SELECT EMPLOYEES_ID,ID_ADMINISTRATION,ID_HRMANAGERS,NAME_EMPLOYEE,DATE_OF_BIRTH,SALARY FROM DIRECTORS d "
				+ "LEFT JOIN ADMINISTRATION a ON m.ID_ADMINISTRATION = d.ADMINISTRATION_ID "
				+ "LEFT JOIN EMPLOYEES e ON e.ID = a.EMPLOYEES_ID "
				+ "LEFT JOIN ADDRESSES a ON e.ID = a.A_EMPLOYEES_ID "
				+ "LEFT JOIN COUNTRY c ON c.ID = a.COUNTRY_ID ";
		
		Statement preparedStatement =null;
		try{
			preparedStatement = connection.prepareStatement(sql);
			
		    ResultSet resulSet = preparedStatement.executeQuery(sql);
		    
		    while(resulSet.next()){
		    	
		    	Directors directors = new Directors();
		    	Address address = new Address();
		    	directors.setId_directors(resulSet.getInt("d.ID_DIRECTORS"));
		    	directors.setAdministration_id(resulSet.getInt("d.ADMINISTRATION_ID"));
		    	directors.setEmployees_id(resulSet.getInt("a.EMPLOYEES_ID"));
		    	directors.setName_employee(resulSet.getString("e.NAME_EMPLOYEE"));
		    	directors.setDate_of_birth(resulSet.getDate("e.DATE_OF_BIRTH"));
		    	directors.setSalary(resulSet.getInt("e.SALARY")); 
		    	address.setCountry_id(resulSet.getInt("COUNTRY_ID"));
				address.setCity(resulSet.getString("CITY"));
				address.setStreet(resulSet.getString("STREET"));
				address.setHouse(resulSet.getString("HOUSE"));
				directors.setAddress(address);
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
		PreparedStatement preparedStatement =null;
		String sql = "SELECT EMPLOYEES_ID,ID_ADMINISTRATION,ID_HRMANAGERS,NAME_EMPLOYEE,DATE_OF_BIRTH,SALARY FROM HRMANAGERS hr "
				+ "LEFT JOIN ADMINISTRATION a ON m.ID_ADMINISTRATION = hr.ADMINISTRATION_ID "
				+ "LEFT JOIN EMPLOYEES e ON e.ID = a.EMPLOYEES_ID "
				+ "LEFT JOIN ADDRESSES a ON e.ID = a.A_EMPLOYEES_ID "
				+ "LEFT JOIN COUNTRY c ON c.ID = a.COUNTRY_ID "
				+ "WHERE hr.ID_HRMANAGERS=?";
		
		Directors directors = new Directors();
		try {
			preparedStatement = connection.prepareStatement(sql);
			//preparedStatement.setInt(1, id);
			ResultSet resulSet = preparedStatement.executeQuery();
			resulSet.next();

	    	directors.setId_directors(resulSet.getInt("d.ID_DIRECTORS"));
	    	directors.setAdministration_id(resulSet.getInt("d.ADMINISTRATION_ID"));
	    	directors.setEmployees_id(resulSet.getInt("a.EMPLOYEES_ID"));
	    	directors.setName_employee(resulSet.getString("e.NAME_EMPLOYEE"));
	    	directors.setDate_of_birth(resulSet.getDate("e.DATE_OF_BIRTH"));
	    	directors.setSalary(resulSet.getInt("e.SALARY")); 

		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			ConnectionPoolDB.getInstance().putBackConnection(connection);
		}
	
		return directors;
	}

	@Override
	public void update(Directors directors) {
		PreparedStatement preparedStatement1 =null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
		
		String sql1 = "UPDATE EMPLOYEES SET NAME_EMPLOYEE=? WHERE ID_DATE_OF_BIRTH=? WHERE SALARY=?";
		String sql2 = "UPDATE ADMINISTRATION SET EMPLOYEES_ID=?";
		String sql3 = "UPDATE DIRECTORS SET ADMINISTRATION_ID=? WHERE ID_DIRECTORS=?";
		try {
			
			preparedStatement1 = connection.prepareStatement(sql1);
			//preparedStatement1.setInt(1, directors.getId());
			preparedStatement1.setString(2, directors.getName_employee());
			preparedStatement1.setDate(3, directors.getDate_of_birth());
			preparedStatement1.setInt(4, directors.getSalary());
			preparedStatement1.executeUpdate();
			
			preparedStatement2 = connection.prepareStatement(sql2);
			//preparedStatement2.setInt(1, hrManagers.getId_administration());
			preparedStatement2.setInt(2, directors.getEmployees_id());
			preparedStatement2.executeUpdate();
			
			preparedStatement3 = connection.prepareStatement(sql3);
			//preparedStatement3.setInt(1, directors.getId_directors());
			preparedStatement3.setInt(2, directors.getAdministration_id());
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
	public void delete(Directors directors) {
		PreparedStatement preparedStatement1 =null;
		PreparedStatement preparedStatement2 =null;
		PreparedStatement preparedStatement3 =null;
		String sql1 = "DELETE FROM EMPLOYEES  WHERE ID=?";
		String sql2 = "DELETE FROM MARKETING  WHERE ID_MARKETING=?";
		String sql3 = "DELETE FROM DIRECTORS WHERE ID_DIRECTORS=?";
		try {
			
			preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement1.setInt(1, directors.getId());
			preparedStatement1.executeUpdate();
			
			preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement2.setInt(1, directors.getId_administration());
			preparedStatement2.executeUpdate();
			
			preparedStatement3 = connection.prepareStatement(sql3);
			preparedStatement3.setInt(1, directors.getId_directors());
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
