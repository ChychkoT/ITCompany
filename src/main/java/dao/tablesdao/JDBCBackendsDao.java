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
import dao.interfacesdao.IBackendsDao;
import dao.tables.Address;
import dao.tables.Backends;
import dao.tables.HrManagers;

public class JDBCBackendsDao  extends ConnectionPoolDB implements IBackendsDao{
	
	private static final Logger LOGGER = Logger.getLogger(JDBCBackendsDao.class);

	//Connection connection = getConnection();
	Connection connection = ConnectionPoolDB.getInstance().getConnection();

	@Override
	public void insert(Backends backends) {
		PreparedStatement preparedStatement =null;
		PreparedStatement preparedStatement2 =null;
		PreparedStatement preparedStatement3 =null;
		
		String sql = "INSERT INTO EMPLOYEES ( ID, NAME_EMPLOYEE, DATE_OF_BIRTH,SALARY) VALUES (?,?,?,?)";
		String sql2 = "INSERT INTO DEVELLOPMENT (ID_DEVELOPMENT, EMPLOYEES_ID) VALUES (?,?)";
		String sql3 = "INSERT INTO BACKENDS (ID_BACKENDS, DEVELOPMENT_ID) VALUES (?,?)";
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, backends.getId()); 
			preparedStatement.setString(2, backends.getName_employee());
			preparedStatement.setDate(3, backends.getDate_of_birth());
			preparedStatement.setInt(4, backends.getSalary());
			preparedStatement.executeUpdate();
			
			preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement2.setInt(1, backends.getId_development());
			preparedStatement2.setInt(2, backends.getEmployees_id());
			preparedStatement2.executeUpdate();
			
			preparedStatement3 = connection.prepareStatement(sql3);
			preparedStatement3.setInt(1, backends.getId_backend());
			preparedStatement3.setInt(2, backends.getDevelopment_id());
			preparedStatement3.executeUpdate();
			
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
	public List<Backends> getAll() {
		List<Backends> backendslist = new ArrayList<>();

		String sql = "SELECT EMPLOYEES_ID,ID_DEVEOPMENT,ID_BACKENDS,NAME_EMPLOYEE,DATE_OF_BIRTH,SALARY FROM BACKENDS bk "
				+ "LEFT JOIN DEVEOPMENT d ON m.ID_ADMINISTRATION = bk.DEVEOPMENT_ID "
				+ "LEFT JOIN EMPLOYEES e ON e.ID = d.EMPLOYEES_ID "
				+ "LEFT JOIN EMPLOYEES e ON e.ID = d.EMPLOYEES_ID "
				+ "LEFT JOIN ADDRESSES a ON e.ID = a.A_EMPLOYEES_ID ";
		//String sql = "SELECT * FROM BACKENDS";
		
		Statement preparedStatement =null;
		try{
			preparedStatement = connection.prepareStatement(sql);
			
		    ResultSet resulSet = preparedStatement.executeQuery(sql);
		    
		    while(resulSet.next()){
		    	
		    	Backends backends = new Backends();
		    	Address address = new Address();
		    	backends.setId_backend(resulSet.getInt("bk.ID_BACKENDS"));
		    	backends.setDevelopment_id(resulSet.getInt("bk.DEVELOPMENT_ID"));
		    	backends.setEmployees_id(resulSet.getInt("d.EMPLOYEES_ID"));
		    	backends.setName_employee(resulSet.getString("e.NAME_EMPLOYEE"));
		    	backends.setDate_of_birth(resulSet.getDate("e.DATE_OF_BIRTH"));
		    	backends.setSalary(resulSet.getInt("e.SALARY")); 
		    	address.setCountry_id(resulSet.getInt("COUNTRY_ID"));
				address.setCity(resulSet.getString("CITY"));
				address.setStreet(resulSet.getString("STREET"));
				address.setHouse(resulSet.getString("HOUSE"));
				backends.setAddress(address);
		    	backendslist.add(backends);
		    }
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			ConnectionPoolDB.getInstance().putBackConnection(connection);
		}

		return backendslist;
	}

	@Override
	public Backends getById(int id) {
		PreparedStatement preparedStatement =null;
		String sql = "SELECT EMPLOYEES_ID,ID_DEVEOPMENT,ID_BACKENDS,NAME_EMPLOYEE,DATE_OF_BIRTH,SALARY FROM BACKENDS bk "
				+ "LEFT JOIN DEVEOPMENT d ON m.ID_ADMINISTRATION = bk.DEVEOPMENT_ID "
				+ "LEFT JOIN EMPLOYEES e ON e.ID = d.EMPLOYEES_ID "
				+ "LEFT JOIN ADDRESSES a ON e.ID = a.A_EMPLOYEES_ID "
				+ "LEFT JOIN COUNTRY c ON c.ID = a.COUNTRY_ID "
				+ "WHERE bk.ID_BACKENDS=?";
		
		Backends backends = new Backends();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resulSet = preparedStatement.executeQuery();
			resulSet.next();
			backends.setId_backend(resulSet.getInt("hr.ID_HRMANAGERS"));
			backends.setDevelopment_id(resulSet.getInt("hr.ADMINISTRATION_ID"));
	    	backends.setEmployees_id(resulSet.getInt("a.EMPLOYEES_ID"));
	    	backends.setName_employee(resulSet.getString("e.NAME_EMPLOYEE"));
	    	backends.setDate_of_birth(resulSet.getDate("e.DATE_OF_BIRTH"));
	    	backends.setSalary(resulSet.getInt("e.SALARY")); 
	    	LOGGER.info(backends);

		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			ConnectionPoolDB.getInstance().putBackConnection(connection);
		}
	
		return backends;
	}

	@Override
	public void update(Backends backends) {
		PreparedStatement preparedStatement1 =null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
				
		String sql1 = "UPDATE EMPLOYEES SET NAME_EMPLOYEE=?, DATE_OF_BIRTH=?, SALARY=? WHERE ID=?";
		String sql2 = "UPDATE DEVEOPMENT SET EMPLOYEES_ID=? WHERE ID_DEVELOPMENT=?";
		String sql3 = "UPDATE BACKENDS SET DEVELOPMENT_ID=? WHERE ID_FRONTENDS=?";
		try {
			
			preparedStatement1 = connection.prepareStatement(sql1);
			//preparedStatement1.setInt(1, backends.getId());
			preparedStatement1.setString(2, backends.getName_employee());
			preparedStatement1.setDate(3, backends.getDate_of_birth());
			preparedStatement1.setInt(4, backends.getSalary());
			preparedStatement1.executeUpdate();
			
			preparedStatement2 = connection.prepareStatement(sql2);
			//preparedStatement2.setInt(1, backends.getId_development());
			preparedStatement2.setInt(2, backends.getEmployees_id());
			preparedStatement2.executeUpdate();
			
			preparedStatement3 = connection.prepareStatement(sql3);	
			preparedStatement3.setInt(1, backends.getId_backend());
			preparedStatement3.setInt(2, backends.getDevelopment_id());	
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
	public void delete(Backends backends) {
		PreparedStatement preparedStatement1 =null;
		PreparedStatement preparedStatement2 =null;
		PreparedStatement preparedStatement3 =null;
		String sql1 = "DELETE FROM EMPLOYEES  WHERE ID=?";
		String sql2 = "DELETE FROM MARKETING  WHERE ID_DEVEOPMENT=?";
		String sql3 = "DELETE FROM BACKENDS WHERE ID_BACKENDS=?";
		try {
			
			preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement1.setInt(1, backends.getId());
			preparedStatement1.executeUpdate();
			
			preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement2.setInt(1, backends.getId_development());
			preparedStatement2.executeUpdate();
			
			preparedStatement3 = connection.prepareStatement(sql3);
			preparedStatement3.setInt(1, backends.getId_backend());
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
