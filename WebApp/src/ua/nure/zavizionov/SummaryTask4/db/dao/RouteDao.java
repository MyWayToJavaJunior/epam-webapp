package ua.nure.zavizionov.SummaryTask4.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.db.entity.Route;

public class RouteDao extends AbstractDao<Route>{
	
	private static final Logger LOG = Logger.getLogger(RouteDao.class);

	public RouteDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Route create() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSelectQuery() {
		// TODO Auto-generated method stub
		return null;
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
	protected List<Route> parseResultSet(ResultSet rs) {
		LOG.debug("Parsing starts");
		List<Route> result = new ArrayList<Route>();
		DaoFactory factory = DaoFactory.getInstance();
		
		LOG.debug("Getting station DAO");
		RoleDao roleDao = factory.getRoleDao(connection);
		
		try {
			while (rs.next()){
				Route route = new Route();
				user.setId(rs.getInt(Fields.ID));
				user.setLogin(rs.getString(Fields.USER_LOGIN));
				user.setPassword(rs.getString(Fields.USER_PASSWORD));
				user.setEmail(rs.getString(Fields.USER_EMAIL));
				user.setRole(roleDao.getByPK(rs.getInt(Fields.USER_ROLE_ID)));
				result.add(user);
			}
		} catch (SQLException e) {
			LOG.error("Error occured while parsing", e);
		}
		LOG.debug("Parsed.");
		return result;
		
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement,
			Route object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement,
			Route object) {
		// TODO Auto-generated method stub
		
	}
	

}
