package dao.services;

import java.util.List;

import org.apache.log4j.Logger;

import dao.tables.Address;
import dao.tables.Backends;
import dao.tablesdao.JDBCAddressDao;
import dao.tablesdao.JDBCBackendsDao;

public class ServiceBackends {
	
private static final Logger LOGGER = Logger.getLogger(ServiceBackends.class);
	
    JDBCBackendsDao backendsDao = new JDBCBackendsDao();
	JDBCAddressDao addressDao = new JDBCAddressDao();
	
	public void getByIdBackends(int id){
		Backends backends = backendsDao.getById(id);	
		Address address = addressDao.getById(backends.getEmployees_id());

	}
	
	public void ListBackends(){
		List<Backends> backendslist = backendsDao.getAll();
		for(Backends b:backendslist){
			LOGGER.info(b);
		}
	}
	
	
	public void insertFBackends(Backends backends, Address address){
		backendsDao.insert(backends);
		addressDao.insert(address);
		
	}

	
	public void updateBackends(Backends backends){
		backendsDao.update(backends);
		addressDao.update(backends.getAddress());
	}
	
	
	public void deleteBackends(Backends backends){
		backendsDao.delete(backends);
		addressDao.delete(backends.getAddress());
	}

}
