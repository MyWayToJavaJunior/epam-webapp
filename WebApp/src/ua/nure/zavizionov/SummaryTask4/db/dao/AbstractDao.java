package ua.nure.zavizionov.SummaryTask4.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.db.Fields;
import ua.nure.zavizionov.SummaryTask4.db.entity.Entity;
import ua.nure.zavizionov.SummaryTask4.db.util.DBService;

public abstract class AbstractDao<T extends Entity> implements GenericDao<T> {
	
	private static final Logger LOG = Logger.getLogger(AbstractDao.class);
	
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
		sql += " WHERE " + Fields.ID + " = ?";
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
		System.out.println(sql);
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			prepareStatementForInsert(statement, object);
			LOG.debug("Executing query");
			int count = statement.executeUpdate();
			if (count != 1){
				LOG.error("Error occured");
				throw new SQLException("On persist modify " + count + " rows, expected 1");
			}
		}catch (Exception e){
			LOG.error("Error occured", e);
			throw new SQLException(e);
		}
		PreparedStatement lastIdStatement = connection.prepareStatement("SELECT LAST_INSERT_ID();");
		ResultSet lastIdRS =  lastIdStatement.executeQuery();
		lastIdRS.next();
		int lastId = lastIdRS.getInt(1);
		LOG.debug("Getting object");
		sql = getSelectQuery() + " WHERE id = ?;";
		System.out.println(sql);
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1, lastId);
			ResultSet rs = statement.executeQuery();
			List<T> list = parseResultSet(rs);
			if (list == null || list.size() == 0){
				LOG.error("Cant find inserted object");
				throw new SQLException("Cant find inserted data");
			}
			persistInstance = list.iterator().next();
		}catch(Exception e){
			throw new SQLException(e);
		}
		LOG.trace("Object founded, commiting changes.");
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
			LOG.trace("Updated successful, commiting changes");
			connection.commit();
		}catch (Exception e){
			throw new SQLException(e);
		}
	}
	
	@Override
	public void delete(T object) throws SQLException {
		String sql = getDeleteQuery();
		LOG.trace("Deleting object " + object);
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
		LOG.trace("Object deleted.");
	}
	
	public AbstractDao(Connection connection){
		this.connection = connection;
	}
	

}
