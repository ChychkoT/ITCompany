package dao.interfacesdao;

import java.util.List;

import dao.tables.Backends;

public interface IBackendsDao {
	
    void insert (Backends backends);
	
	List<Backends> getAll();
	
	Backends getById(int id);
	
	void update (Backends backends);
	
	void delete (Backends backends);

}
