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
import dao.interfacesdao.IFrontendsDao;
import dao.tables.Address;
import dao.tables.Backends;
import dao.tables.Frontends;

public class JDBCFrontendsDao extends ConnectionPoolDB implements IFrontendsDao{
	
	private static final Logger LOGGER = Logger.getLogger(JDBCFrontendsDao.class);

	//Connection connection = getConnection();
	Connection connection = ConnectionPoolDB.getInstance().getConnection();
	
	@Override
	public void insert(Frontends frontends) {
		PreparedStatement preparedStatement =null;
		PreparedStatement preparedStatement2 =null;
		PreparedStatement preparedStatement3 =null;
		
		String sql1 = "INSERT INTO EMPLOYEES ( ID, NAME_EMPLOYEE, DATE_OF_BIRTH,SALARY) VALUES (?,?,?,?)";
		String sql2 = "INSERT INTO DEVELLOPMENT (ID_DEVELOPMENT, EMPLOYEES_ID) VALUES (?,?)";
		String sql3 = "INSERT INTO FRONTENDS (ID_FRONTENDS, DEVELOPMENT_ID) VALUES (?,?)";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setInt(1, frontends.getId()); 
			preparedStatement.setString(2, frontends.getName_employee());
			preparedStatement.setDate(3, frontends.getDate_of_birth());
			preparedStatement.setInt(4, frontends.getSalary());
			preparedStatement.executeUpdate();
			
			preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement2.setInt(1, frontends.getId_development());
			preparedStatement2.setInt(2, frontends.getEmployees_id());
			preparedStatement2.executeUpdate();
			
			
			preparedStatement3 = connection.prepareStatement(sql3);
			preparedStatement3.setInt(1, frontends.getId_frontend());
			preparedStatement3.setInt(2, frontends.getDevelopment_id());
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
	public List<Frontends> getAll() {
		List<Frontends> frontendslist = new ArrayList<>();

		
		String sql = "SELECT EMPLOYEES_ID,ID_DEVEOPMENT,ID_BACKENDS,NAME_EMPLOYEE,DATE_OF_BIRTH,SALARY FROM FRONTENDS fr "
				+ "LEFT JOIN DEVEOPMENT d ON m.ID_ADMINISTRATION = fr.DEVEOPMENT_ID "
				+ "LEFT JOIN EMPLOYEES e ON e.ID = d.EMPLOYEES_ID "
				+ "LEFT JOIN ADDRESSES a ON e.ID = a.A_EMPLOYEES_ID "
				+ "LEFT JOIN COUNTRY c ON c.ID = a.COUNTRY_ID ";
		//String sql = "SELECT * FROM FRONTENDS";
		
		Statement preparedStatement =null;
		try{
			preparedStatement = connection.prepareStatement(sql);
			
		    ResultSet resulSet = preparedStatement.executeQuery(sql);
		    
		    while(resulSet.next()){
		    	
		    	Frontends frontends = new Frontends();
		    	Address address = new Address();
		    	frontends.setId_frontend(resulSet.getInt("fr.ID_FRONTENDS"));
		    	frontends.setDevelopment_id(resulSet.getInt("fr.DEVELOPMENT_ID"));
		    	frontends.setEmployees_id(resulSet.getInt("d.EMPLOYEES_ID"));
		    	frontends.setName_employee(resulSet.getString("e.NAME_EMPLOYEE"));
		    	frontends.setDate_of_birth(resulSet.getDate("e.DATE_OF_BIRTH"));
		    	frontends.setSalary(resulSet.getInt("e.SALARY")); 
		        address.setCountry_id(resulSet.getInt("COUNTRY_ID"));
				address.setCity(resulSet.getString("CITY"));
				address.setStreet(resulSet.getString("STREET"));
				address.setHouse(resulSet.getString("HOUSE"));
				frontends.setAddress(address);
		    	frontendslist.add(frontends);
		    }
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			ConnectionPoolDB.getInstance().putBackConnection(connection);
		}

		return frontendslist;
	}

	@Override
	public Frontends getById(int id) {
		PreparedStatement preparedStatement =null;
		String sql = "SELECT EMPLOYEES_ID,ID_DEVEOPMENT,ID_BACKENDS,NAME_EMPLOYEE,DATE_OF_BIRTH,SALARY FROM FRONTENDS fr "
				+ "LEFT JOIN DEVEOPMENT d ON m.ID_DEVEOPMENT = fr.DEVEOPMENT_ID "
				+ "LEFT JOIN EMPLOYEES e ON e.ID = d.EMPLOYEES_ID "
				+ "LEFT JOIN ADDRESSES a ON e.ID = a.A_EMPLOYEES_ID "
				+ "LEFT JOIN COUNTRY c ON c.ID = a.COUNTRY_ID "
				+ "WHERE fr.ID_FRONTENDS=?";
		
		Frontends frontends = new Frontends();
		try {
			preparedStatement = connection.prepareStatement(sql);
			//preparedStatement.setInt(1, id);
			ResultSet resulSet = preparedStatement.executeQuery();
			resulSet.next();
			frontends.setId_frontend(resulSet.getInt("fr.ID_FRONTENDS"));
			frontends.setDevelopment_id(resulSet.getInt("fr.DEVEOPMENT_ID"));
			frontends.setEmployees_id(resulSet.getInt("a.EMPLOYEES_ID"));
			frontends.setName_employee(resulSet.getString("e.NAME_EMPLOYEE"));
			frontends.setDate_of_birth(resulSet.getDate("e.DATE_OF_BIRTH"));
			frontends.setSalary(resulSet.getInt("e.SALARY")); 
			LOGGER.info(frontends);

		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			ConnectionPoolDB.getInstance().putBackConnection(connection);
		}
	
		return frontends;
	}

	@Override
	public void update(Frontends frontends) {
		PreparedStatement preparedStatement1 =null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
		String sql1 = "UPDATE EMPLOYEES SET NAME_EMPLOYEE=?, DATE_OF_BIRTH=?, SALARY=? WHERE ID=?";
		String sql2 = "UPDATE DEVEOPMENT SET EMPLOYEES_ID=? WHERE ID_DEVELOPMENT=?";
		String sql3 = "UPDATE FRONTENDS SET DEVELOPMENT_ID=? WHERE ID_FRONTENDS=?";
		try {
			
			preparedStatement1 = connection.prepareStatement(sql1);
			//preparedStatement1.setInt(1, frontends.getId());
			preparedStatement1.setString(2, frontends.getName_employee());
			preparedStatement1.setDate(3, frontends.getDate_of_birth());
			preparedStatement1.setInt(4, frontends.getSalary());
			preparedStatement1.executeUpdate();
			
			preparedStatement2 = connection.prepareStatement(sql2);
			//preparedStatement2.setInt(1, marketologs.getId_development());
			preparedStatement2.setInt(2, frontends.getEmployees_id());
			preparedStatement2.executeUpdate();
			
			preparedStatement3 = connection.prepareStatement(sql3);
			//preparedStatement3.setInt(1, frontends.getId_frontend());
			preparedStatement3.setInt(2, frontends.getDevelopment_id());
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
	public void delete(Frontends frontends) {
		PreparedStatement preparedStatement1 =null;
		PreparedStatement preparedStatement2 =null;
		PreparedStatement preparedStatement3 =null;
		String sql1 = "DELETE FROM EMPLOYEES  WHERE ID=?";
		String sql2 = "DELETE FROM MARKETING  WHERE ID_DEVEOPMENT=?";
		String sql3 = "DELETE FROM FRONTENDS WHERE ID_FRONTENDS=?";
		try {
			
			
			preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement1.setInt(1, frontends.getId());
			preparedStatement1.executeUpdate();
			
			preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement2.setInt(1, frontends.getId_development());
			preparedStatement2.executeUpdate();
			
			preparedStatement3 = connection.prepareStatement(sql3);
			preparedStatement3.setInt(1, frontends.getId_frontend());
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
