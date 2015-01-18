package ua.nure.zavizionov.SummaryTask4.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ua.nure.zavizionov.SummaryTask4.db.entity.Entity;

public abstract class AbstractDao<T extends Entity> implements GenericDao<T> {
	
	
	protected Connection connection;

	public abstract String getSelectQuery();
	
	public abstract String getUpdateQuery();
	
	public abstract String getDeleteQuery();
	
	public abstract String getCreateQuery();

	protected abstract List<T> parseResultSet(ResultSet rs);
	
	protected abstract void prepareStatementForInsert(PreparedStatement statement, T object);
	
	protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object);
	
	@Override
	public T getByPK(int key) throws SQLException{
		List<T> list;
		String sql = getSelectQuery();
		sql += " WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1, key);
			ResultSet rs = statement.executeQuery();
			list = parseResultSet(rs);
		}catch (Exception e){
			throw new SQLException(e);
		}
		if (list == null || list.size() == 0){
			return null;
		}
		if (list.size() > 1){
			throw new SQLException("Recieved more the 1 value");
		}
		return list.iterator().next();
	}
	
	@Override
	public List<T> getAll() throws SQLException{
		List<T> list;
		String sql = getSelectQuery();
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			ResultSet rs = statement.executeQuery();
			list = parseResultSet(rs);
		}catch (Exception e){
			throw new SQLException(e);
		}
		return list;
	}

	@Override
	public T persist(T object) throws SQLException {
		if (object.getId()!=null){
			throw new SQLException("Object is already persist.");
		}
		T persistInstance;
		String sql = getCreateQuery();
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			prepareStatementForInsert(statement, object);
			int count = statement.executeUpdate();
			if (count != 1){
				throw new SQLException("On persist modify " + count + " rows, expected 1");
			}
		}catch (Exception e){
			throw new SQLException(e);
		}
		
		sql = getSelectQuery() + "WHERE id = last_insert_id();";
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			ResultSet rs = statement.executeQuery();
			List<T> list = parseResultSet(rs);
			if (list == null || list.size() == 0){
				throw new SQLException("Cant find inserted data");
			}
			persistInstance = list.iterator().next();
		}catch(Exception e){
			throw new SQLException(e);
		}
		return persistInstance;
	}
	
	@Override
	public void update(T object) throws SQLException {
		String sql = getUpdateQuery();
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			prepareStatementForUpdate(statement, object);
			int count = statement.executeUpdate();
			if (count != 1){
				throw new SQLException("Updated " + count + " rows, expected 1");
			}
		}catch (Exception e){
			throw new SQLException(e);
		}
	}
	
	@Override
	public void delete(T object) throws SQLException {
		String sql = getDeleteQuery();
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			try{
				statement.setInt(1, object.getId());
			}catch(Exception e){
				throw new SQLException(e);
			}
			int count = statement.executeUpdate();
			if (count != 1){
				throw new SQLException("Deleted " + count + " rows, expected 1");
			}
			statement.close();
		}catch(Exception e){
			throw new SQLException(e);
		}
		
	}
	
	public AbstractDao(Connection connection){
		this.connection = connection;
	}
	

}
