package mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.interfacesdao.IEmployeesDao;
import dao.tables.Employees;


public class EmployeesMyBatisService extends MyBatisConnectionFactory implements IEmployeesDao {
	
	
	   private SqlSessionFactory sqlSessionFactory = null;
	 
	    public EmployeesMyBatisService(SqlSessionFactory sqlSessionFactory){
	        this.sqlSessionFactory = sqlSessionFactory;
	    }
	    

		@Override
		public void insert(Employees employees) {
			
	        SqlSession session = sqlSessionFactory.openSession();
	 
	        try {
	           session.insert("Employees.insert", employees);
	        } finally {
	            session.commit();
	            session.close();
	        }
	        System.out.println("insert("+employees+") --> "+employees.getId());
			
		}

		@Override
		public List<Employees> getAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Employees getById(int id) {
			Employees employees = null;
		        SqlSession session = sqlSessionFactory.openSession();
		        try {
		        	employees = session.selectOne("mybatis.Employees.getById", id);
		 
		        } finally {
		            session.close();
		        }
		        System.out.println("getById("+id+") --> "+employees);
		        return employees;
		}

		@Override
		public void update(Employees employees) {
	
	      SqlSession session = sqlSessionFactory.openSession();
	      
	      try {
	          session.update("Employees.update", employees);
	 
	      } finally {
	          session.commit();
	          session.close();
	      }
	      System.out.println("update("+employees+") --> updated");
		}

		@Override
		public void delete(Employees employees) {
			 SqlSession session = sqlSessionFactory.openSession();
			 
		        try {
		            session.delete("Employees.delete");
		        } finally {
		            session.commit();
		            session.close();
		        }
		        System.out.println("delete");
			
		} 

}
