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
		return "SELECT * FROM routes ";
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
		StationDao stationDao = factory.getStationDao(connection);
		try {
			while (rs.next()){
				Route route = new Route();
				route.setId(rs.getInt(Fields.ID));
				route.setDepartureStation(stationDao.getByPK(
						rs.getInt(Fields.ROUTE_DEPARTURE_STATION_ID)));
				route.setArrivalStation(stationDao.getByPK(
						rs.getInt(Fields.ROUTE_ARRIVAL_STATION_ID)));
				route.setDepartureTime(rs.getTime(Fields.ROUTE_DEPARTURE_TIME));
				route.setArrivalTime(rs.getTime(Fields.ROUTE_ARRIVAL_TIME));
				result.add(route);
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
