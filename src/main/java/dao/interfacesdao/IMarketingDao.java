package dao.interfacesdao;

import java.util.List;

import dao.tables.Marketing;

public interface IMarketingDao {
	
    void insert (Marketing marketing);
	
	List<Marketing> getAll();
	
	Marketing getById(int id);
	
	void update (Marketing marketing);
	
	void delete (Marketing marketing);

}
