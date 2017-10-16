package mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import dao.interfacesdao.IEmployeesDao;
import dao.tables.Employees;

public class EmployeesMyBatisService extends MyBatisConnectionFactory implements IEmployeesDao {
	
	

	/*public EmployeesMyBatisService() {
		
	}*/

	private static final Logger LOGGER = Logger
			.getLogger(EmployeesMyBatisService.class);
	private SqlSessionFactory sqlSessionFactory = null;

	public EmployeesMyBatisService(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void insert(Employees employees) {

		SqlSession session = sqlSessionFactory.openSession();

		try {
			session.insert("mybatis.EmployeesMyBatisService.insert", employees);
			session.commit();
		} finally {
			
			session.close();
		}
		LOGGER.info("insert(" + employees + ") --> " + employees.getId());

	}

	@Override
	public List<Employees> getAll() {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			return session.selectList("mybatis.EmployeesMyBatisService.getAll");
		} finally {
			session.close();
		}
	}

	@Override
	public Employees getById(int id) {
		Employees employees = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			employees = session.selectOne("mybatis.EmployeesMyBatisService.getById", id);

		} finally {
			session.close();
		}

		LOGGER.info("getById(" + id + ") --> " + employees);
		return employees;
	}

	@Override
	public void update(Employees employees) {

		SqlSession session = sqlSessionFactory.openSession();

		try {
			session.update("mybatis.EmployeesMyBatisService.update", employees);
			session.commit();
		} finally {
		
			session.close();
		}
		LOGGER.info("update(" + employees + ") --> updated");
	}

	@Override
	public void delete(Employees employees) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			session.delete("mybatis.EmployeesMyBatisService.delete");
			session.commit();
		} finally {
			
			session.close();
		}
		LOGGER.info("delete");

	}

}
