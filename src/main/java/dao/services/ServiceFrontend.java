package dao.services;

import java.util.List;

import org.apache.log4j.Logger;

import dao.tables.Address;
import dao.tables.Frontends;
import dao.tablesdao.JDBCAddressDao;
import dao.tablesdao.JDBCFrontendsDao;

public class ServiceFrontend {
	
private static final Logger LOGGER = Logger.getLogger(ServiceFrontend.class);
	
    JDBCFrontendsDao frontendsDao = new JDBCFrontendsDao();
	JDBCAddressDao addressDao = new JDBCAddressDao();
	
	public void getByIdFrontends(int id){
		Frontends frontends = frontendsDao.getById(id);	
		Address address = addressDao.getById(frontends.getEmployees_id());

	}
	
	public void ListFrontends(){
		List<Frontends> frontendslist = frontendsDao.getAll();
		for(Frontends f:frontendslist){
			LOGGER.info(f);
		}
	}
	
	
	public void insertFrontends(Frontends frontends, Address address){
		frontendsDao.insert(frontends);
		addressDao.insert(address);
		
	}

	
	public void updateFrontends(Frontends frontends){
		frontendsDao.update(frontends);
		addressDao.update(frontends.getAddress());
	}
	
	
	public void deleteFrontends(Frontends frontends){
		frontendsDao.delete(frontends);
		addressDao.delete(frontends.getAddress());
	}

}
