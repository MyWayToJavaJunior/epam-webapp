package ua.nure.zavizionov.SummaryTask4.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.db.entity.User;

public class UserDao extends AbstractDao<User> {
	
	private static final Logger LOG = Logger.getLogger(User.class);
	public UserDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ua.nure.zavizionov.SummaryTask4.db.entity.User create()
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSelectQuery() {
		return "SELECT * FROM users";
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
	protected List<User> parseResultSet(
			ResultSet rs) {
		LOG.debug("Parsing starts");
		List<User> result = new ArrayList<User>();
		try {
			while (rs.next()){
				User user = new User();
				user.setId(rs.getInt(Fields.ID));
				user.setLogin(rs.getString(Fields.USER_LOGIN));
				user.setPassword(rs.getString(Fields.USER_PASSWORD));
				user.setEmail(rs.getString(Fields.USER_EMAIL));
				user.setRoleId(rs.getInt(Fields.USER_ROLE_ID));
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
			User object) {
		
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement, User object) {
	}

	public User getByLogin(String login) throws SQLException {
		List<User> list = null;
		String sql = getSelectQuery();
		sql += " WHERE login = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, login);
			ResultSet rs = statement.executeQuery();
			list = parseResultSet(rs);
		}catch (SQLException e){
			throw new SQLException(e);
		}
		if (list == null || list.size() == 0){
			return null;
		}
		if (list.size() > 1){
			throw new SQLException("Recieved more then 1 value");
		}
		return list.iterator().next();
	}

}
