package ua.nure.zavizionov.SummaryTask4.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.db.entity.Station;


public class StationDao extends AbstractDao<Station>{
	private static final Logger LOG = Logger.getLogger(StationDao.class);
	

	public StationDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Station create() throws SQLException {
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
	protected List<Station> parseResultSet(ResultSet rs) {
		LOG.debug("Parsing starts");
		List<Station> result = new ArrayList<Station>();	
		try {
			while (rs.next()){
				Station station = new Station();
				station.setId(rs.getInt(Fields.ID));
				station.setName(rs.getString(Fields.STATION_NAME));
				result.add(station);
			}
		} catch (SQLException e) {
			LOG.error("Error occured while parsing", e);
		}
		LOG.debug("Parsed.");
		return result;
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement,
			Station object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement,
			Station object) {
		// TODO Auto-generated method stub
		
	}
	
	

}
