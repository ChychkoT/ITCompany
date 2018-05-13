package mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import dao.interfacesdao.IAddressDao;
import dao.tables.Address;

public class MyBatisAddressDAO extends MyBatisConnectionFactory implements IAddressDao{
	
public MyBatisAddressDAO() {
		
	}

	private static final Logger LOGGER = Logger.getLogger(MyBatisSalesDAO.class);
	
	//private SqlSessionFactory sqlSessionFactory ;

	/*public MyBatisAddressDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}*/

	@Override
	public void insert(Address address) {

		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession();
			session.insert("mybatis.MyBatisAddressDAO.createAddress", address);
		} finally {
			session.close();
		}
		LOGGER.info("insert(" + address + ") --> " + address.getId());

	}

	@Override
	public List<Address> getAll() {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			return session.selectList("mybatis.MyBatisAddressDAO.getAddressAll");
		} finally {
			session.close();
		}
	}

	@Override
	public Address getById(int id) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
		   return session.selectOne("mybatis.MyBatisAddressDAO.getAddressById", id);

		} finally {
			session.close();
		}

	}

	@Override
	public void update(Address address) {

		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession();
			session.update("mybatis.MyBatisAddressDAO.updateAddress", address);
			session.commit();
		} finally {
		
			session.close();
		}
		LOGGER.info("update(" + address + ") --> updated");
	}

	@Override
	public void delete(Address address) {
		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession();
			session.delete("mybatis.MyBatisAddressDAO.deleteAddress");
			session.commit();
		} finally {
			
			session.close();
		}
		LOGGER.info("delete");

	}


}
