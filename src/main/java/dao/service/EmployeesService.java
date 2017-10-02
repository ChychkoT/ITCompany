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
import dao.interfacesdao.IEmployeesDao;
import dao.tables.Employees;

public class EmployeesService extends ConnectionPoolDB implements IEmployeesDao {
	
	private static final Logger LOGGER = Logger.getLogger(EmployeesService.class);
	
	//Connection connection = getConnection();
	Connection connection = ConnectionPoolDB.getInstance().getConnection();

	@Override
	public void insert(Employees employees) {
		PreparedStatement preparedStatement =null;
		String sql = "INSERT INTO EMPLOYEES (ID, NAME_EMPLOYEE, DATE_OF_BIRTH,SALARY) VALUES (?,?,?,?)";
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, employees.getId());
			preparedStatement.setString(2, employees.getName_employee());
			preparedStatement.setDate(3, employees.getDate_of_birth());
			preparedStatement.setInt(4, employees.getSalary());
			
			preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
		}
		
	}

	
	@Override
	public List<Employees> getAll()  {
		
		List<Employees> emploeeslist = new ArrayList<>();

		String sql = "SELECT * FROM EMPLOYEES";
		
		Statement preparedStatement =null;
		try{
			preparedStatement = connection.prepareStatement(sql);
			
		    ResultSet resulSet = preparedStatement.executeQuery(sql);
		    
		    while(resulSet.next()){
		    	
		    	Employees employees = new Employees();
		    	
		    	employees.setId(resulSet.getInt("ID"));
		    	employees.setName_employee(resulSet.getString("NAME_EMPLOYEE"));
		    	employees.setDate_of_birth(resulSet.getDate("DATE_OF_BIRTH"));
		    	employees.setSalary(resulSet.getInt("SALARY"));
		    	
		    	emploeeslist.add(employees);
		    }
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
		}

		return emploeeslist;
	}

	
	
	@Override
	public Employees getById(int id) {
		PreparedStatement preparedStatement =null;
		String sql = "SELECT ID,NAME_EMPLOYEE,DATE_OF_BIRTH,SALARY FROM EMPLOYEES WHERE ID=?";
		
		Employees employees = new Employees();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resulSet = preparedStatement.executeQuery();
	
			employees.setId(resulSet.getInt("ID"));
	    	employees.setName_employee(resulSet.getString("NAME_EMPLOYEE"));
	    	employees.setDate_of_birth(resulSet.getDate("DATE_OF_BIRTH"));
	    	employees.setSalary(resulSet.getInt("SALARY"));
	    
	    	preparedStatement.executeUpdate();
		    
			
		}catch(SQLException e){
			LOGGER.error(e.getMessage());
		}finally{
			close(preparedStatement);
			close(connection);
		}
	
		return employees;
	}

	
	
	@Override
	public void update(Employees employees) {
		PreparedStatement preparedStatement =null;
		String sql = "UPDATE EMPLOYEES SET NAME_EMPLOYEE=?,DATE_OF_BIRTH=?,SALARY=? WHERE ID=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, employees.getName_employee());
			preparedStatement.setDate(2, employees.getDate_of_birth());
			preparedStatement.setInt(3, employees.getSalary());
			preparedStatement.setInt(4, employees.getId());
	    	
			preparedStatement.executeUpdate();
			
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement);
				close(connection);
			}
	}

	
	
	@Override
	public void delete(Employees employees) {
		PreparedStatement preparedStatement =null;
		String sql = "DELETE FROM EMPLOYEES WHERE ID=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, employees.getId());
	    	
			preparedStatement.executeUpdate();
			
			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement);
				close(connection);
			}
		
	}



}