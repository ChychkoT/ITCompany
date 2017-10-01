package dao.interfacesdao;

import java.util.List;

import dao.tables.Administration;

public interface IAdministrationDao {
	
    void insert (Administration administration);
	
	List<Administration> getAll();
	
	Administration getById(int id);
	
	void update (Administration administration);
	
	void delete (Administration administration);

}
