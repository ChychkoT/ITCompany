package mybatis;

import dao.tables.Employees;

public class RannerMyBatis {
	
	public static void main(String args[]){
		
		EmployeesMyBatisService employeesMyBatisService = new EmployeesMyBatisService(MyBatisConnectionFactory.getSqlSessionFactory());
		//Employees employees = new Employees();
		System.out.println(employeesMyBatisService.getById(5));
	}

}
