package ua.nure.zavizionov.SummaryTask4.db.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.db.Fields;
import ua.nure.zavizionov.SummaryTask4.db.entity.Route;
import ua.nure.zavizionov.SummaryTask4.db.util.DBService;

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
		return "DELETE FROM routes WHERE id = ?;";
	}

	@Override
	public String getCreateQuery() {
		return "INSERT INTO routes (" + Fields.ROUTE_DEPARTURE_STATION_ID +", " + Fields.ROUTE_DEPARTURE_TIME +
				", " + Fields.ROUTE_ARRIVAL_STATION_ID + ", " + Fields.ROUTE_ARRIVAL_TIME + ") VALUES (?, ?, ?, ?)";
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
				route.setRouteComposition(factory.getRouteCompositionDao(connection).getByRoute(route.getId()));
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
		LOG.debug("Prepearing statemant");
		try {
			statement.setInt(1, object.getDepartureStation().getId());
			statement.setTime(2, new java.sql.Time(object.getDepartureTime().getTime()));
			statement.setInt(3, object.getArrivalStation().getId());
			statement.setTime(4, new java.sql.Time(object.getArrivalTime().getTime()));
		} catch (SQLException e) {
			LOG.error("Error occured", e);
		}
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement,
			Route object) {
		// TODO Auto-generated method stub
		
	}
	

}
