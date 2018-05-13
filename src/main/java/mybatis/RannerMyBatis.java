package mybatis;

import java.util.Calendar;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import dao.services.ServiceSales;
import dao.tables.Address;
import dao.tables.Sales;

public class RannerMyBatis {
	private static final Logger LOGGER = Logger.getLogger(RannerMyBatis.class);
	
	public static void main(String args[]){
		
		//SqlSessionFactory sf = MyBatisConnectionFactory.getSqlSessionFactory();
		ServiceSales servicSales = new ServiceSales();
		Sales sales = new Sales();
		Address address =new Address();
		//MyBatisSalesDAO myBatisSalesDAO =new MyBatisSalesDAO();
		//MyBatisAddressDAO myBatisAddressDAO =new MyBatisAddressDAO();
		
		//servicSales.getByIdSales(2);
		//ervicSales.ListSales();
		
		
		/*sales.setId(14);
		sales.setName_employee("Livanov Ilia");
		Calendar calendar =Calendar.getInstance();
		calendar.set(1990,Calendar.AUGUST,06);
		sales.setDate_of_birth(new java.sql.Date(calendar.getTime().getTime()));
		sales.setSalary(2600);
		sales.setId_marketing(6);
		sales.setEmployees_id(14);
		sales.setId_sale(3);
		sales.setMarketing_id(6);
		
				
		address.setId(14);
    	address.setCountry_id(4);
        address.setCity("Gdansk");
    	address.setStreet("Gdanskaja");
    	address.setHouse("15");
    	address.setEmployees_id(14);
    	sales.setAddress(address);
		
    	servicSales.insertSales(sales, address);*/
		
		/*sales.setId(7);
		sales.setName_employee("Livanov Ilia");
		Calendar calendar =Calendar.getInstance();
		calendar.set(1990,Calendar.AUGUST,06);
		sales.setDate_of_birth(new java.sql.Date(calendar.getTime().getTime()));
		sales.setSalary(2600);
		sales.setId_marketing(3);
		sales.setEmployees_id(7);
		sales.setId_sale(1);
		sales.setMarketing_id(3);
		
				
		address.setId(7);
    	address.setCountry_id(4);
        address.setCity("Gdansk");
    	address.setStreet("Gdanskaja");
    	address.setHouse("15");
    	address.setEmployees_id(7);
    	sales.setAddress(address);
    	
    	servicSales.updateSales(sales);*/
		
		address.setId(8);
		sales.setId_sale(2);
		sales.setId_marketing(4);
		sales.setId(8);		
		sales.setAddress(address);
		servicSales.deleteSales(sales);
    	
    	
		//myBatisAddressDAO.getById(2);
		//LOGGER.info(myBatisSalesDAO.getById(2));
		//LOGGER.info(myBatisAddressDAO.getById(2));
	}

}
 