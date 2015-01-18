package ua.nure.zavizionov.SummaryTask4.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ua.nure.zavizionov.SummaryTask4.db.bean.TrainBean;

public class TrainBeanDao extends AbstractDao<TrainBean> {

	public TrainBeanDao(Connection connection) {
		super(connection);
	}

	@Override
	public TrainBean create() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSelectQuery() {
		return SELECT  FROM 
	}

	@Override
	public String getUpdateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDeleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCreateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<TrainBean> parseResultSet(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement,
			TrainBean object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement,
			TrainBean object) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
