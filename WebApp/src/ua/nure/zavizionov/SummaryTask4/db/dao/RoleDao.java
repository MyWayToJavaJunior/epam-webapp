package ua.nure.zavizionov.SummaryTask4.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.db.Fields;
import ua.nure.zavizionov.SummaryTask4.db.entity.Role;
import ua.nure.zavizionov.SummaryTask4.db.entity.User;

public class RoleDao extends AbstractDao<Role>{
	
	private static final Logger LOG = Logger.getLogger(RoleDao.class);

	public RoleDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Role create() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSelectQuery() {
		return "SELECT * FROM roles ";
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
	protected List<Role> parseResultSet(ResultSet rs) {
		LOG.debug("Parsing starts");
		List<Role> result = new ArrayList<Role>();
		try {
			while (rs.next()){
				Role role = new Role();
				role.setId(rs.getInt(Fields.ID));
				role.setName(rs.getString(Fields.ROLE_NAME));
				role.setDescription(rs.getString(Fields.ROLE_DESCRIPTION));
				result.add(role);
			}
		} catch (SQLException e) {
			LOG.error("Error occured while parsing", e);
		}
		LOG.debug("Parsed.");
		return result;
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement,
			Role object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement,
			Role object) {
		// TODO Auto-generated method stub
		
	}
	
	

}
