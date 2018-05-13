package dao;

import java.util.Calendar;
import java.util.List;

import dao.services.ServiceSales;
import dao.services.SeviceMarketologs;
import dao.tables.Address;
import dao.tables.Administration;
import dao.tables.Country;
import dao.tables.Directors;
import dao.tables.Employees;
import dao.tables.Marketologs;
import dao.tables.Sales;
import dao.tablesdao.JDBCMarketologsDao;

public class DaoRunner {
	
	public static void main(String[] args) {
		
		//ConnectionDB connnectiondb = new ConnectionDB();
		//connnectiondb.getConnection();
		
		/*EmployeesService employesservice = new EmployeesService();
		Employees employees = new Employees();
		employees.setId(13);
		employees.setName_employee("Demin Ivan");
		Calendar calendar =Calendar.getInstance();
		calendar.set(1990,Calendar.MAY,05);
		employees.setDate_of_birth(new java.sql.Date(calendar.getTime().getTime()));
		employees.setSalary(2500);
		
		AddressService addressservice = new AddressService();
		Address address = new Address();
		address.setId(13);
    	address.setContry_id(4);
    	address.setCity("Gdansk");
    	address.setStreet("Gdanskaja");
    	address.setHouse("5");
    	address.setEmployees_id(13);
		
    	CountryService countryservice = new CountryService();
    	Country country = new Country();
    	country.setId(7);
    	country.setCountry_name("USA");
    	
    	AdministrationService administrationService = new AdministrationService();
    	Administration administration = new Administration();
    	administration.setId_administration(5);
    	administration.setEmployees_id(13);
    	
    	
    	DirectorsService directorsService =new DirectorsService();
    	Directors directors = new Directors();
    	directors.setAdministration_id(5);
    	*/
    	
		
		//employesservice.insert(employees);
		/*List<Employees> emploeeslist = employesservice.getAll();
		for(Employees e:emploeeslist){
			System.out.println(e);
			
		}*/
		//System.out.println(employesservice.getById(5));
		//employesservice.update(employees);
		//employesservice.delete(employees);
    	
		//SeviceOutputMarketologs seviceOutputMarketologs = new SeviceOutputMarketologs();
		//seviceOutputMarketologs.outputMarketologs();
			
		/*JDBCMarketologsDao mar = new JDBCMarketologsDao();
		List<Marketologs> emploeeslist = mar.getAll();
		for(Marketologs e:emploeeslist){
			System.out.println(e);
		}*/
	
		//mar.getById(2);
		
		
	//////////////////////////////////////////////////////////////////////////////////////////////	
		
		
		ServiceSales servicSales = new ServiceSales();
		SeviceMarketologs seviceMarketologs = new SeviceMarketologs();
		Marketologs marketologs = new Marketologs();
		Address address = new Address();
		
//////////////GET BY ID MARKETOLOG///////////		
		//seviceMarketologs.getByIdMarcetolog(2);
		servicSales.getByIdSales(2);
		
//////////////GET LIST MARKETOLOGS///////////			
		//seviceMarketologs.ListMarketologs();
		
//////////////INSERT MARKETOLOG///////////	
		/*marketologs.setId(13);
    	marketologs.setName_employee("Livanov Ilia");
		Calendar calendar =Calendar.getInstance();
		calendar.set(1990,Calendar.AUGUST,06);
		marketologs.setDate_of_birth(new java.sql.Date(calendar.getTime().getTime()));
		marketologs.setSalary(2600);
		marketologs.setId_marketing(5);
		marketologs.setEmployees_id(13);
		marketologs.setId_marketolog(3);
		marketologs.setMarketing_id(5);
		
				
		address.setId(13);
    	address.setCountry_id(4);
        address.setCity("Gdansk");
    	address.setStreet("Gdanskaja");
    	address.setHouse("15");
    	//address.setEmployees_id(13);
    	marketologs.setAddress(address);*/
    	
		//seviceMarketologs.insertMarketolog(marketologs, address);

		
		
///////////DELETE MARKETOLOG/////////////
		
		/*marketologs.setId(13);
		marketologs.setId_marketing(5);
		marketologs.setId_marketolog(3);
		address.setId(14);
		marketologs.setAddress(address);
		seviceMarketologs.deleteMarketolog(marketologs);*/

///////////UPDATE MARKETOLOG/////////////		
		seviceMarketologs.updateMarketolog(marketologs);

	}

}