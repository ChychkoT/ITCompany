package dao.interfacesdao;

import java.util.List;

import dao.tables.Directors;

public interface IDirectorsDao {
	
    void insert (Directors directors);
	
	List<Directors> getAll();
	
	Directors getById(int id);
	
	void update (Directors directors);
	
	void delete (Directors directors);

}
