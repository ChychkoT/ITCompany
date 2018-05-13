package dao.services;

import java.util.List;

import org.apache.log4j.Logger;

import dao.tables.Address;
import dao.tables.Directors;
import dao.tablesdao.JDBCAddressDao;
import dao.tablesdao.JDBCDirectorsDao;

public class ServiceDirectors {
	
private static final Logger LOGGER = Logger.getLogger(ServiceDirectors.class);
	
    JDBCDirectorsDao directorsDao = new JDBCDirectorsDao();
	JDBCAddressDao addressDao = new JDBCAddressDao();
	
	public void getByIdDirectors(int id){
		Directors directors = directorsDao.getById(id);	
		Address address = addressDao.getById(directors.getEmployees_id());

	}
	
	public void ListDirectors(){
		List<Directors> directorslist = directorsDao.getAll();
		for(Directors d:directorslist){
			LOGGER.info(d);
		}
	}
	
	
	public void insertDirectors(Directors directors, Address address){
		directorsDao.insert(directors);
		addressDao.insert(address);
		
	}

	
	public void updateDirectors(Directors directors){
		directorsDao.update(directors);
		addressDao.update(directors.getAddress());
	}
	
	
	public void deleteDirectors(Directors directors){
		directorsDao.delete(directors);
		addressDao.delete(directors.getAddress());
	}

}
