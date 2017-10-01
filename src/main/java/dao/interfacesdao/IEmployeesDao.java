package dao.interfacesdao;

import java.util.List;

import dao.tables.Employees;

public interface IEmployeesDao {
	
	void insert (Employees employees);
	
	List<Employees> getAll();
	
	Employees getById(int id);
	
	void update (Employees employees);
	
	void delete (Employees employees);


}
