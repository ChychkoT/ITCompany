package dao.services;

import java.util.List;

import mybatis.MyBatisAddressDAO;
import mybatis.MyBatisSalesDAO;

import org.apache.log4j.Logger;

import dao.tables.Address;
import dao.tables.Sales;
import dao.tablesdao.JDBCAddressDao;
import dao.tablesdao.JDBCSalesDao;


public class ServiceSales {
	private static final Logger LOGGER = Logger.getLogger(ServiceSales.class);
	
	/*JDBCSalesDao salesDao = new JDBCSalesDao();
	JDBCAddressDao addressDao = new JDBCAddressDao();*/
	
	MyBatisSalesDAO salesDao = new MyBatisSalesDAO();
	MyBatisAddressDAO addressDao = new MyBatisAddressDAO();
	
	public Sales getByIdSales (int id){
		Sales sales= salesDao.getById(id);	
		sales.setAddress(addressDao.getById(sales.getId()));
		//Address address = addressDao.getById(sales.getEmployees_id());
		LOGGER.info(sales);
		//LOGGER.info(address);
		return sales;

	}
	
	public List<Sales> ListSales(){
		List<Sales> saleslist = salesDao.getAll();
		saleslist.stream().forEach((s) -> s.setAddress(addressDao.getById(s.getId())));
		LOGGER.info(saleslist);	
		return saleslist;
	}
	
	
	public void insertSales(Sales sales, Address address){
		salesDao.insert(sales);
		addressDao.insert(address);
		
		//addressDao.insert(sales.getAddress());
		
	}
	
	public void updateSales(Sales sales){
		addressDao.update(sales.getAddress());
		salesDao.update(sales);
		
	}
	
	
	public void deleteSales(Sales sales){
		addressDao.delete(sales.getAddress());
		salesDao.delete(sales);
		
	}
	
}
