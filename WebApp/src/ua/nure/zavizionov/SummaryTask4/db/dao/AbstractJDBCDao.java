package ua.nure.zavizionov.SummaryTask4.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import ua.nure.zavizionov.SummaryTask4.db.entity.Entity;

public abstract class AbstractJDBCDao<T extends Entity> implements GenericDao<T> {
	
	private Connection connection;

	public abstract String getSelectQuery();
	
	public abstract String getUpdateQuery();
	
	public abstract String getDeleteQuery();
	
	public abstract String getCreateQuery();
		
	protected abstract List<T> parseResultSet(ResultSet rs);
	
	protected abstract void prepareStatementForInsert(PreparedStatement statement, T object);
	
	protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object);
	
	@Override
	public T getByPK(int key) throws PersistException{
		List<T> list;
		String sql = getSelectQuery();
		sql += " WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1, key);
			ResultSet rs = statement.executeQuery();
			list = parseResultSet(rs);
		}catch (Exception e){
			throw new PersistException(e);
		}
		if (list == null || list.size() == 0){
			return null;
		}
		if (list.size() > 1){
			throw new PersistException("Recieved more the 1 value");
		}
		return list.iterator().next();
	}
	@Override
	public List<T> getAll() throws PersistException{
		List<T> list;
		String sql = getSelectQuery();
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			ResultSet rs = statement.executeQuery();
			list = parseResultSet(rs);
		}catch (Exception e){
			throw new PersistException(e);
		}
		return list;
	}
	
	

	@Override
	public T persist(T object) throws PersistException {
		if (object.getId()!=null){
			throw new PersistException("Object is already persist.");
		}
		T persistInstance;
		String sql = getCreateQuery();
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			prepareStatementForInsert(statement, object);
			int count = statement.executeUpdate();
			if (count != 1){
				throw new PersistException("On persist modify " + count + " rows, expected 1");
			}
		}catch (Exception e){
			throw new PersistException(e);
		}
		
		sql = getSelectQuery() + "WHERE id = last_insert_id();";
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			ResultSet rs = statement.executeQuery();
			List<T> list = parseResultSet(rs);
			if (list == null || list.size() == 0){
				throw new PersistException("Cant find inserted data");
			}
			persistInstance = list.iterator().next();
		}catch(Exception e){
			throw new PersistException(e);
		}
		return persistInstance;
	}
	
	@Override
	public void update(T object) throws PersistException {
		String sql = getUpdateQuery();
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			prepareStatementForUpdate(statement, object);
			int count = statement.executeUpdate();
			if (count != 1){
				throw new PersistException("Updated " + count + " rows, expected 1");
			}
		}catch (Exception e){
			throw new PersistException(e);
		}
	}
	
	@Override
	public void delete(T object) throws PersistException {
		String sql = getDeleteQuery();
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			try{
				statement.setInt(1, object.getId());
			}catch(Exception e){
				throw new PersistException(e);
			}
			int count = statement.executeUpdate();
			if (count != 1){
				throw new PersistException("Deleted " + count + " rows, expected 1");
			}
			statement.close();
		}catch(Exception e){
			throw new PersistException(e);
		}
		
	}
	public AbstractJDBCDao(Connection connection){
		this.connection = connection;
	}

}
