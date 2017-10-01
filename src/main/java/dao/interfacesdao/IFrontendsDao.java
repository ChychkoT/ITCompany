package dao.interfacesdao;

import java.util.List;

import dao.tables.Frontends;

public interface IFrontendsDao {
	
    void insert (Frontends frontends);
	
	List<Frontends> getAll();
	
	Frontends getById(int id);
	
	void update (Frontends frontends);
	
	void delete (Frontends frontends);


}
