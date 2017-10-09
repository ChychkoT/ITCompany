package mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import dao.tables.Employees;

public class RannerMyBatis {
	private static final Logger LOGGER = Logger.getLogger(RannerMyBatis.class);
	
	public static void main(String args[]){
		
		SqlSessionFactory sf = MyBatisConnectionFactory.getSqlSessionFactory();
		EmployeesMyBatisService employeesMyBatisService = new EmployeesMyBatisService(sf);
		//Employees employees = new Employees();
		System.out.println(employeesMyBatisService.getById(5));
	}

}
