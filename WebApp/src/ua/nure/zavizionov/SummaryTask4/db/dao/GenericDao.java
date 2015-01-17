package ua.nure.zavizionov.SummaryTask4.db.dao;

import java.sql.SQLException;
import java.util.List;

import ua.nure.zavizionov.SummaryTask4.db.entity.Entity;

public interface GenericDao<T extends Entity> {
	
	public T create() throws SQLException;
	
	public T persist(T object) throws SQLException;
	
	public T getByPK(int key) throws SQLException;
	
	public void update(T object) throws SQLException;
	
	public void delete(T object) throws SQLException;
	
	public List<T> getAll() throws SQLException;
	
	
}
