package dao.interfacesdao;

import java.util.List;

import dao.tables.Address;

public interface IAddressDao {

	void insert (Address address);
	
	List<Address> getAll();
	
	Address getById(int id);
	
	void update (Address address);
	
	void delete (Address address);


}
