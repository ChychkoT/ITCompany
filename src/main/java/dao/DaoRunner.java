package dao;

import java.util.Calendar;
import java.util.List;

import dao.service.AddressService;
import dao.service.AdministrationService;
import dao.service.CountryService;
import dao.service.DirectorsService;
import dao.service.EmployeesService;
import dao.tables.Address;
import dao.tables.Administration;
import dao.tables.Country;
import dao.tables.Directors;
import dao.tables.Employees;

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
    	
    	
		

	}

}