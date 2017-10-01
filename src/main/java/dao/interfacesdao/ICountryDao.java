package dao.interfacesdao;

import java.util.List;

import dao.tables.Country;

public interface ICountryDao {
	
    void insert (Country country);
	
	List<Country> getAll();
	
	Country getById(int id);
	
	void update (Country country);
	
	void delete (Country country);

}
