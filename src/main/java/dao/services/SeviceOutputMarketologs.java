package dao.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import dao.ConnectionPoolDB;
import dao.tables.Employees;
import dao.tables.Marketing;
import dao.tables.Marketologs;
import dao.tablesdao.EmployeesDao;
import dao.tablesdao.MarketingDao;
import dao.tablesdao.MarketologsDao;


public class SeviceOutputMarketologs extends ConnectionPoolDB {

	private static final Logger LOGGER = Logger.getLogger(SeviceOutputMarketologs.class);

	//Connection connection = getConnection();
	Connection connection = ConnectionPoolDB.getInstance().getConnection();

	public void outputMarketologs () {	
		/*MarketologsDao mar = new MarketologsDao();
		EmployeesDao emp = new EmployeesDao();
		MarketingDao markDao =new MarketingDao();*/

			PreparedStatement preparedStatement =null;
			String sql = "SELECT ID_MARKETOLOGS,MARKETING_ID,ID_MARKETING,EMPLOYEES_ID,ID,NAME_EMPLOYEE,DATE_OF_BIRTH,SALARY FROM  MARKETOLOGS h left join MARKETING ad  on h.MARKETING_ID = ad.ID_MARKETING left join EMPLOYEES e  on e.ID = ad.EMPLOYEES_ID";

			Marketologs marketologs = new Marketologs();
			Marketing marketing = new Marketing();
			Employees employees = new Employees();
			try {
				preparedStatement = connection.prepareStatement(sql);
				//preparedStatement.setInt(1, id);
				ResultSet resulSet = preparedStatement.executeQuery();
				while(resulSet.next()){
                marketologs.setId_marketolog(resulSet.getInt("ID_MARKETOLOGS"));
				marketologs.setMarketing_id(resulSet.getInt("MARKETING_ID"));
				marketing.setId_marketing(resulSet.getInt("ID_MARKETING"));
				marketing.setEmployees_id(resulSet.getInt("EMPLOYEES_ID"));
				employees.setId(resulSet.getInt("ID"));
		    	employees.setName_employee(resulSet.getString("NAME_EMPLOYEE"));
		    	employees.setDate_of_birth(resulSet.getDate("DATE_OF_BIRTH"));
		    	employees.setSalary(resulSet.getInt("SALARY"));
		    	LOGGER.info(marketologs);
		    	LOGGER.info(marketing);
		    	LOGGER.info(employees);
				}

			}catch(SQLException e){
				LOGGER.error(e.getMessage());
			}finally{
				close(preparedStatement);
				//close(connection);
				putBackConnection(connection);
			}
	}
	
	
}

