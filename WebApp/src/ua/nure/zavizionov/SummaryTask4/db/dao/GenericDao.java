package ua.nure.zavizionov.SummaryTask4.db.dao;

import java.sql.SQLException;
import java.util.List;

import ua.nure.zavizionov.SummaryTask4.db.entity.Entity;

public interface GenericDao<T extends Entity> {
	
	public T create() throws PersistException;
	
	public T persist(T object) throws PersistException;
	
	public T getByPK(int key) throws PersistException;
	
	public void update(T object) throws PersistException;
	
	public void delete(T object) throws PersistException;
	
	public List<T> getAll() throws PersistException;
	
}
