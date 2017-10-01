package dao.interfacesdao;

import java.util.List;

import dao.tables.HrManagers;

public interface IHrManagersDao {
	
    void insert (HrManagers hrManagers);
	
	List<HrManagers> getAll();
	
	HrManagers getById(int id);
	
	void update (HrManagers hrManagers);
	
	void delete (HrManagers hrManagers);

}
