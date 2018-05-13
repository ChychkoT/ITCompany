package dao.services;

import java.util.List;

import org.apache.log4j.Logger;

import dao.tables.Address;
import dao.tables.Marketologs;
import dao.tablesdao.JDBCAddressDao;
import dao.tablesdao.JDBCMarketologsDao;


public class SeviceMarketologs {
	private static final Logger LOGGER = Logger.getLogger(SeviceMarketologs.class);
	
	JDBCMarketologsDao marketologsDao = new JDBCMarketologsDao();
	JDBCAddressDao addressDao = new JDBCAddressDao();
	
	public void getByIdMarcetolog(int id){
		Marketologs marketologs = marketologsDao.getById(id);	
		Address address = addressDao.getById(marketologs.getEmployees_id());

	}
	
	public void ListMarketologs(){
		List<Marketologs> marketologslist = marketologsDao.getAll();
		for(Marketologs m:marketologslist){
			LOGGER.info(m);
		}
		//marketologslist.stream().forEach((m) -> m.setAddress(addressDao.getById(m.getEmployees_id())));
	}
	
	
	public void insertMarketolog(Marketologs marketologs, Address address){
		marketologsDao.insert(marketologs);
		addressDao.insert(address);
		
	}

	
	public void updateMarketolog(Marketologs marketologs){
		marketologsDao.update(marketologs);
		addressDao.update(marketologs.getAddress());
	}
	
	
	public void deleteMarketolog(Marketologs marketologs){
		marketologsDao.delete(marketologs);
		addressDao.delete(marketologs.getAddress());
	}
	
	
}

