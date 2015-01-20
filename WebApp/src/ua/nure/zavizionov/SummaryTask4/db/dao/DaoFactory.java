package ua.nure.zavizionov.SummaryTask4.db.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ua.nure.zavizionov.SummaryTask4.db.entity.User;

public class DaoFactory {
	
	
	//Singleton
	
	private static DaoFactory instance;
	
	public static synchronized DaoFactory getInstance() {
		if (instance == null) {
			instance = new DaoFactory();
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/mysql");
			con = ds.getConnection();
		} catch (NamingException ex) {
					
		}
		if(con == null){
			throw new SQLException();
		}
		return con;
	}
	
	public RoleDao getRoleDao(Connection connection){
		return new RoleDao(connection);
	}
	
	public UserDao getUserDao(Connection connection){
		return new UserDao(connection);
	}
	
	public TrainBeanDao getTrainBeanDao(Connection connection){
		return new TrainBeanDao(connection);
	}
	
	
	
	
	

	private DaoFactory() {
		
	}
	
	

}
