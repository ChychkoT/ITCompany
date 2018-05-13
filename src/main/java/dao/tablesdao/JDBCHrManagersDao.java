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
import dao.interfacesdao.IHrManagersDao;
import dao.tables.Address;
import dao.tables.HrManagers;
import dao.tables.Marketologs;

public class JDBCHrManagersDao extends ConnectionPoolDB implements IHrManagersDao{
	
	private static final Logger LOGGER = Logger.getLogger(JDBCHrManagersDao.class);

	//Connection connection = getConnection();
	Connection connection = ConnectionPoolDB.getInstance().getConnection();

	@Override
	public void insert(HrManagers hrManagers) {
		PreparedStatement preparedStatement =null;
		PreparedStatement preparedStatement2 =null;
		PreparedStatement preparedStatement3 =null;
		
		String sql2 = "INSERT INTO EMPLOYEES ( NAME_EMPLOYEE, DATE_OF_BIRTH,SALARY) VALUES (?,?,?)";
		String sql3 = "INSERT INTO ADMINISTRATION (ID_ADMINISTRATION, EMPLOYEES_ID) VALUES (?,?)";
		String sql = "INSERT INTO HRMANAGERS (ID_HRMANAGERS, ADMINISTRATION_ID) VALUES (?,?)";
		
		try{
			
			preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement2.setInt(1, hrManagers.getId()); 
			preparedStatement2.setString(2, hrManagers.getName_employee());
			preparedStatement2.setDate(3, hrManagers.getDate_of_birth());
			preparedStatement2.setInt(4, hrManagers.getSalary());
			preparedStatement2.executeUpdate();
			
			preparedStatement3 = connection.prepareStatement(sql3);
		    preparedStatement3.setInt(1, hrManagers.getId_administration());
			preparedStatement3.setInt(2, hrManagers.getEmployees_id());
			preparedStatement3.executeUpdate();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, hrManagers.getId_hrmanagers());
			preparedStatement.setInt(2, hrManagers.getAdministration_id());
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
	public List<HrManagers> getAll() {
		List<HrManagers> hrmanagerslist = new ArrayList<>();

		String sql = "SELECT EMPLOYEES_ID,ID_ADMINISTRATION,ID_HRMANAGERS,NAME_EMPLOYEE,DATE_OF_BIRTH,SALARY,COUNTRY_ID,CITY,STREET,HOUSE FROM HRMANAGERS hr "
				+ "LEFT JOIN ADMINISTRATION a ON m.ID_ADMINISTRATION = hr.ADMINISTRATION_ID "
				+ "LEFT JOIN EMPLOYEES e ON e.ID = a.EMPLOYEES_ID "
				+ "LEFT JOIN ADDRESSES a ON e.ID = a.A_EMPLOYEES_ID "
				+ "LEFT JOIN COUNTRY c ON c.ID = a.COUNTRY_ID ";
		//String sql = "SELECT * FROM HRMANAGERS";
		
		Statement preparedStatement =null;
		try{
			preparedStatement = connection.prepareStatement(sql);
			
		    ResultSet resulSet = preparedStatement.executeQuery(sql);
		    
		    while(resulSet.next()){
		    	
		    	HrManagers hrManagers = new HrManagers();
		    	Address address = new Address();
		    	hrManagers.setId_hrmanagers(resulSet.getInt("hr.ID_HRMANAGERS"));
		    	hrManagers.setAdministration_id(resulSet.getInt("hr.ADMINISTRATION_ID"));
		    	hrManagers.setEmployees_id(resulSet.getInt("a.EMPLOYEES_ID"));
		    	hrManagers.setName_employee(resulSet.getString("e.NAME_EMPLOYEE"));
		    	hrManagers.setDate_of_birth(resulSet.getDate("e.DATE_OF_BIRTH"));
		    	hrManagers.setSalary(resulSet.getInt("e.SALARY")); 
		    	address.setCountry_id(resulSet.getInt("COUNTRY_ID"));
				address.setCity(resulSet.getString("CITY"));
				address.setStreet(resulSet.getString("STREET"));
				address.setHouse(resulSet.getString("HOUSE"));
				hrManagers.setAddress(address);
		    	hrmanagerslist.add(hrManagers);
		    }
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			ConnectionPoolDB.getInstance().putBackConnection(connection);
		}

		return hrmanagerslist;
	}

	@Override
	public HrManagers getById(int id) {
		PreparedStatement preparedStatement =null;
		String sql = "SELECT EMPLOYEES_ID,ID_ADMINISTRATION,ID_HRMANAGERS,NAME_EMPLOYEE,DATE_OF_BIRTH,SALARY FROM HRMANAGERS hr "
				+ "LEFT JOIN ADMINISTRATION a ON m.ID_ADMINISTRATION = hr.ADMINISTRATION_ID "
				+ "LEFT JOIN EMPLOYEES e ON e.ID = a.EMPLOYEES_ID "
				+ "LEFT JOIN ADDRESSES a ON e.ID = a.A_EMPLOYEES_ID "
				+ "LEFT JOIN COUNTRY c ON c.ID = a.COUNTRY_ID "
				+ "WHERE hr.ID_HRMANAGERS=?";
		
		HrManagers hrManagers = new HrManagers();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resulSet = preparedStatement.executeQuery();
			resulSet.next();
			hrManagers.setId_hrmanagers(resulSet.getInt("hr.ID_HRMANAGERS"));
	    	hrManagers.setAdministration_id(resulSet.getInt("hr.ADMINISTRATION_ID"));
	    	hrManagers.setEmployees_id(resulSet.getInt("a.EMPLOYEES_ID"));
	    	hrManagers.setName_employee(resulSet.getString("e.NAME_EMPLOYEE"));
	    	hrManagers.setDate_of_birth(resulSet.getDate("e.DATE_OF_BIRTH"));
	    	hrManagers.setSalary(resulSet.getInt("e.SALARY"));
	    	
	    	LOGGER.info(hrManagers);

		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			ConnectionPoolDB.getInstance().putBackConnection(connection);
		}
	
		return hrManagers;
	}

	@Override
	public void update(HrManagers hrManagers) {
		
		PreparedStatement preparedStatement1 =null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
		
		String sql1 = "UPDATE EMPLOYEES SET NAME_EMPLOYEE=? ID_DATE_OF_BIRTH=? SALARY=? WHERE ID=?";
		String sql2 = "UPDATE ADMINISTRATION SET EMPLOYEES_ID=? WHERE ID_ADMINISTRATION=?";
		String sql3 = "UPDATE HRMANAGERS SET ADMINISTRATION_ID=? WHERE ID_HRMANAGERS=?";
		try {
			
			preparedStatement1 = connection.prepareStatement(sql1);
			//preparedStatement1.setInt(1, hrManagers.getId());
			preparedStatement1.setString(2, hrManagers.getName_employee());
			preparedStatement1.setDate(3, hrManagers.getDate_of_birth());
			preparedStatement1.setInt(4, hrManagers.getSalary());
			preparedStatement1.executeUpdate();
			
			preparedStatement2 = connection.prepareStatement(sql2);
			//preparedStatement2.setInt(1, hrManagers.getId_administration());
			preparedStatement2.setInt(2, hrManagers.getEmployees_id());
			preparedStatement2.executeUpdate();
			
			preparedStatement3 = connection.prepareStatement(sql3);			
			//preparedStatement3.setInt(1, hrManagers.getId_hrmanagers());
			preparedStatement3.setInt(2, hrManagers.getAdministration_id());	    	
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
	public void delete(HrManagers hrManagers) {
		PreparedStatement preparedStatement1 =null;
		PreparedStatement preparedStatement2 =null;
		PreparedStatement preparedStatement3 =null;
		String sql1 = "DELETE FROM EMPLOYEES  WHERE ID=?";
		String sql2 = "DELETE FROM MARKETING  WHERE ID_MARKETING=?";
		String sql3 = "DELETE FROM HRMANAGERS WHERE ID_HRMANAGERS=?";
		try {
			preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement1.setInt(1, hrManagers.getId());
			preparedStatement1.executeUpdate();
			
			preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement2.setInt(1, hrManagers.getId_administration());
			preparedStatement2.executeUpdate();
			
			preparedStatement3 = connection.prepareStatement(sql3);
			preparedStatement3.setInt(1, hrManagers.getId_hrmanagers());
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
