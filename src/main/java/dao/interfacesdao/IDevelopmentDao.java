
package dao.interfacesdao;

import java.util.List;

import dao.tables.Development;


public interface IDevelopmentDao {
	
    void insert (Development development);
	
	List<Development> getAll();
	
	Development getById(int id);
	
	void update (Development development);
	
	void delete (Development development);

}
