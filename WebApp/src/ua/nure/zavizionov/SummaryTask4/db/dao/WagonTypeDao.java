package ua.nure.zavizionov.SummaryTask4.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.db.Fields;
import ua.nure.zavizionov.SummaryTask4.db.entity.Route;
import ua.nure.zavizionov.SummaryTask4.db.entity.WagonType;
import ua.nure.zavizionov.SummaryTask4.db.util.DBService;

public class WagonTypeDao extends AbstractDao<WagonType>{
	
	private static final Logger LOG = Logger.getLogger(WagonTypeDao.class);

	public WagonTypeDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public WagonType create() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSelectQuery() {
		return "SELECT * FROM wagon_types ";
	}

	@Override
	public String getUpdateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDeleteQuery() {
		return "DELETE FROM wagon_types WHERE id = ?;";
	}

	@Override
	public String getCreateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<WagonType> parseResultSet(ResultSet rs) {
		LOG.debug("Parsing starts");
		List<WagonType> result = new ArrayList<WagonType>();
		try {
			while (rs.next()){
				WagonType wt = new WagonType();
				wt.setId(rs.getInt(Fields.ID));
				wt.setSeats(rs.getInt(Fields.WAGON_TYPE_SEATS));
				wt.setTypeName(rs.getString(Fields.WAGON_TYPE_NAME));
				result.add(wt);
			}
		} catch (SQLException e) {
			LOG.error("Error occured while parsing", e);
		}
		LOG.debug("Parsed.");
		return result;
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement,
			WagonType object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement,
			WagonType object) {
		// TODO Auto-generated method stub
		
	}

	
	
}
