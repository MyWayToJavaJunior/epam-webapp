package ua.nure.zavizionov.SummaryTask4.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.db.Fields;
import ua.nure.zavizionov.SummaryTask4.db.entity.User;

public class UserDao extends AbstractDao<User> {
	
	private static final Logger LOG = Logger.getLogger(UserDao.class);
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
		return "INSERT INTO users (" + Fields.USER_LOGIN + ", " + Fields.USER_PASSWORD +
				", " + Fields.USER_EMAIL + ", " + Fields.USER_ROLE_ID + ", " + Fields.USER_FULL_NAME + ") VALUES (?, ?, ?, ?, ?)";
	}

	@Override
	protected List<User> parseResultSet(
			ResultSet rs) {
		LOG.debug("Parsing starts");
		List<User> result = new ArrayList<User>();
		DaoFactory factory = DaoFactory.getInstance();
		LOG.debug("Getting role DAO");
		RoleDao roleDao = factory.getRoleDao(connection);
		try {
			while (rs.next()){
				User user = new User();
				user.setId(rs.getInt(Fields.ID));
				user.setLogin(rs.getString(Fields.USER_LOGIN));
				user.setPassword(rs.getString(Fields.USER_PASSWORD));
				user.setEmail(rs.getString(Fields.USER_EMAIL));
				user.setRole(roleDao.getByPK(rs.getInt(Fields.USER_ROLE_ID)));
				user.setFullName(rs.getString(Fields.USER_FULL_NAME));
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
		LOG.debug("Prepearing statemant for object: " + object);
		try {
			statement.setString(1, object.getLogin());
			statement.setString(2, object.getPassword());
			statement.setString(3, object.getEmail());
			statement.setInt(4, object.getRole().getId());
			statement.setString(5, object.getFullName());
		} catch (SQLException e) {
			LOG.error("Error occured", e);
		}
		
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement, User object) {
	}

	public User getByLogin(String login) throws SQLException {
		LOG.debug("Begin to search user");
		LOG.trace("Searching user with login " + login);
		List<User> list = null;
		String sql = getSelectQuery();
		sql += " WHERE login = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, login);
			ResultSet rs = statement.executeQuery();
			list = parseResultSet(rs);
		}
		if (list == null || list.size() == 0){
			return null;
		}
		if (list.size() > 1){
			throw new SQLException("Recieved more then 1 value");
		}
		LOG.debug("User was founded.");
		return list.iterator().next();
	}

	
}
