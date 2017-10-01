package dao.interfacesdao;

import java.util.List;

import dao.tables.Sales;

public interface ISalesDao {
	
    void insert (Sales sales);
	
	List<Sales> getAll();
	
	Sales getById(int id);
	
	void update (Sales sales);
	
	void delete (Sales sales);

}
