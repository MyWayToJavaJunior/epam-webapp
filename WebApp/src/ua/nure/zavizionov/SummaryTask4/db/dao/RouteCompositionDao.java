package ua.nure.zavizionov.SummaryTask4.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.db.Fields;
import ua.nure.zavizionov.SummaryTask4.db.entity.Entity;
import ua.nure.zavizionov.SummaryTask4.db.entity.Role;
import ua.nure.zavizionov.SummaryTask4.db.entity.RouteComposition;

public class RouteCompositionDao extends AbstractDao<RouteComposition>{

	private static final Logger LOG = Logger.getLogger(RouteCompositionDao.class);
	
	public RouteCompositionDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public RouteComposition create() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSelectQuery() {
		return "SELECT * from route_compositions " ;
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
		return "INSERT INTO route_compositions (" + Fields.ROUTE_COMPOSITION_ROUTE_ID +", " + Fields.ROUTE_COMPOSITION_STATION_ID +
				", " + Fields.ROUTE_COMPOSITION_ARRIVAL_TIME + ", " + Fields.ROUTE_COMPOSITION_DEPARTURE_TIME 
				+ ", " + Fields.ROUTE_COMPOSITION_STAY +") VALUES (?, ?, ?, ?, ?)";
	}

	@Override
	protected List<RouteComposition> parseResultSet(ResultSet rs) {
		LOG.debug("Parsing starts");
		List<RouteComposition> result = new ArrayList<RouteComposition>();
		DaoFactory factory = DaoFactory.getInstance();
		LOG.debug("Getting station DAO");
		StationDao stationDao = factory.getStationDao(connection);
		try {
			while (rs.next()){
				RouteComposition rc = new RouteComposition();
				rc.setDepartureTime(rs.getTime(Fields.ROUTE_COMPOSITION_DEPARTURE_TIME));
				rc.setArrivalTime(rs.getTime(Fields.ROUTE_COMPOSITION_ARRIVAL_TIME));
				rc.setStay(rs.getInt(Fields.ROUTE_COMPOSITION_STAY));
				rc.setStation(stationDao.getByPK(rs.getInt(Fields.ROUTE_COMPOSITION_STATION_ID)));
				result.add(rc);
			}
		} catch (SQLException e) {
			LOG.error("Error occured while parsing", e);
		}
		LOG.debug("Parsed.");
		return result;
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement,
			RouteComposition object) {
		LOG.trace("Prepearing statement for insert");
		try {
			statement.setInt(1, object.getRouteId());
			statement.setInt(2, object.getStation().getId());
			statement.setTime(3, new java.sql.Time(object.getArrivalTime().getTime()));
			statement.setTime(4, new java.sql.Time(object.getDepartureTime().getTime()));
			statement.setInt(5,object.getStay());
		} catch (SQLException e) {
			LOG.error("Error occured",e);
		}
		
		
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement,
			RouteComposition object) {
		// TODO Auto-generated method stub
		
	}
	
	public List<RouteComposition> getByRoute(int routeId) throws SQLException{
		List<RouteComposition> list = null;
		String sql = getSelectQuery();
		sql += " WHERE " + Fields.ROUTE_COMPOSITION_ROUTE_ID + " = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1, routeId);
			ResultSet rs = statement.executeQuery();
			list = parseResultSet(rs);
		}catch (Exception e){
			LOG.error("SQL exception occured", e);
			throw new SQLException(e);
		}
		if (list == null || list.size() == 0){
			LOG.warn("Empry route composition.");
		}
		return list;
	}

	

}
