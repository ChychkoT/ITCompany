package mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import dao.interfacesdao.ISalesDao;
import dao.tables.Sales;
import dao.tables.Address;

public class MyBatisSalesDAO extends MyBatisConnectionFactory implements ISalesDao {

	public MyBatisSalesDAO() {
		
	}

	private static final Logger LOGGER = Logger.getLogger(MyBatisSalesDAO.class);
	
	//private SqlSessionFactory sqlSessionFactory ;

	/*public MyBatisSalesDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}*/

	@Override
	public void insert(Sales sales) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			session.insert("mybatis.MyBatisSalesDAO.createSales", sales);
			session.commit();
		}
		finally {
			
			session.close();
		}
		//LOGGER.info("insert(" + sales + ") --> " + sales.getId());

	}

	@Override
	public List<Sales> getAll() {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			return session.selectList("mybatis.MyBatisSalesDAO.getSalesAll");
		} finally {
			session.close();
		}
	}

	@Override
	public Sales getById(int id) {
		Sales sales = null;
		//Address address =null;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			sales = session.selectOne("mybatis.MyBatisSalesDAO.getSalesById", id);
			//address = session.selectOne("mybatis.MyBatisAddressDAO.getAddressById", id);
			//sales.setAddress(address);
			//LOGGER.info("getById(" + id + ") --> " + sales);

		} finally {
			session.close();
		}
		return sales;
	}

	@Override
	public void update(Sales sales) {
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			session.update("mybatis.MyBatisSalesDAO.updateSales", sales);
			session.commit();
		} finally {
		
			session.close();
		}
		LOGGER.info("update(" + sales + ") --> updated");
	}

	@Override
	public void delete(Sales sales) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			session.delete("mybatis.MyBatisSalesDAO.deleteSales");
			session.commit();
		} finally {
			
			session.close();
		}
		LOGGER.info("delete(" + sales + ") --> deleted");

	}

	
}
