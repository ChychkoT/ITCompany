package dao.services;

import java.util.List;

import org.apache.log4j.Logger;

import dao.tables.Address;
import dao.tables.HrManagers;
import dao.tables.Marketologs;
import dao.tablesdao.JDBCAddressDao;
import dao.tablesdao.JDBCHrManagersDao;

public class ServiceHrManagers {
	
private static final Logger LOGGER = Logger.getLogger(ServiceHrManagers.class);
	
    JDBCHrManagersDao hrmanagersDao = new JDBCHrManagersDao();
	JDBCAddressDao addressDao = new JDBCAddressDao();
	
	public void getByIdHrManagers(int id){
		HrManagers hrManagers = hrmanagersDao.getById(id);	
		Address address = addressDao.getById(hrManagers.getEmployees_id());

	}
	
	public void ListHrManagers(){
		List<HrManagers> hrManagerslist = hrmanagersDao.getAll();
		for(HrManagers h:hrManagerslist){
			LOGGER.info(h);
		}
	}
	
	
	public void insertHrManagers(HrManagers hrManagers, Address address){
		hrmanagersDao.insert(hrManagers);
		addressDao.insert(address);
		
	}

	
	public void updateHrManagers(HrManagers hrManagers){
		hrmanagersDao.update(hrManagers);
		addressDao.update(hrManagers.getAddress());
	}
	
	
	public void deleteHrManagers(HrManagers hrManagers){
		hrmanagersDao.delete(hrManagers);
		addressDao.delete(hrManagers.getAddress());
	}
	

}
