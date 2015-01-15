package ua.nure.zavizionov.SummaryTask4.db.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoFactory {
	
	public Connection getConnection() throws SQLException;
	
	

}
