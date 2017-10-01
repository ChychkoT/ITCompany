package dao.interfacesdao;

import java.util.List;

import dao.tables.Marketologs;

public interface IMarketologsDao {

    void insert (Marketologs marketologs);
	
	List<Marketologs> getAll();
	
	Marketologs getById(int id);
	
	void update (Marketologs marketologs);
	
	void delete (Marketologs marketologs);
}
