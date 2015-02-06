package ua.nure.zavizionov.SummaryTask4.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.db.Fields;
import ua.nure.zavizionov.SummaryTask4.db.entity.Train;

public class TrainDao extends AbstractDao<Train> {

	private static final Logger LOG = Logger.getLogger(TrainDao.class);

	public TrainDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Train create() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSelectQuery() {
		return "SELECT * FROM trains ";
	}

	@Override
	public String getUpdateQuery() {
		return "UPDATE trains SET " + Fields.TRAIN_ARRIVAL_DATE + " = ?, "
				+ Fields.TRAIN_DEPARTURE_DATE + " = ?, "
				+ Fields.TRAIN_ROUTE_ID + " = ? WHERE id = ?";
	}

	@Override
	public String getDeleteQuery() {
		return "DELETE FROM trains WHERE id = ?;";
	}

	@Override
	public String getCreateQuery() {
		return "INSERT INTO trains (" + Fields.TRAIN_ARRIVAL_DATE + ", "
				+ Fields.TRAIN_DEPARTURE_DATE + ", " + Fields.TRAIN_ROUTE_ID
				+ ") VALUES (?, ?, ?)";
	}

	@Override
	protected List<Train> parseResultSet(ResultSet rs) {
		LOG.debug("Parsing starts");
		List<Train> result = new ArrayList<Train>();
		DaoFactory factory = DaoFactory.getInstance();
		LOG.debug("Getting route DAO");
		RouteDao routeDao = factory.getRouteDao(connection);
		LOG.debug("Getting wagon DAO");
		WagonDao wagonDao = factory.getWagonDao(connection);

		try {
			while (rs.next()) {
				Train train = new Train();
				train.setId(rs.getInt(Fields.ID));
				train.setDepartureDate(rs.getDate(Fields.TRAIN_DEPARTURE_DATE));
				train.setArrivalDate(rs.getDate(Fields.TRAIN_ARRIVAL_DATE));
				train.setRoute(routeDao.getByPK(rs
						.getInt(Fields.TRAIN_ROUTE_ID)));
				train.setWagons(wagonDao.findWagonsByTrain(train.getId()));
				result.add(train);
			}
		} catch (SQLException e) {
			LOG.error("Error occured while parsing", e);
		}
		LOG.debug("Parsed.");
		return result;
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement,
			Train object) {
		LOG.trace("Prepearing statement for insert");
		try {
			statement.setDate(1, new java.sql.Date(object.getArrivalDate()
					.getTime()));
			statement.setDate(2, new java.sql.Date(object.getDepartureDate()
					.getTime()));
			statement.setInt(3, object.getRoute().getId());
		} catch (SQLException e) {
			LOG.error("Error occured while prepearing statement", e);
		}
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement,
			Train object) {
		LOG.trace("Prepearing statement for update");
		try {
			statement.setDate(1, new java.sql.Date(object.getArrivalDate()
					.getTime()));
			statement.setDate(2, new java.sql.Date(object.getDepartureDate()
					.getTime()));
			statement.setInt(3, object.getRoute().getId());;
			statement.setInt(4, object.getId());
		} catch (SQLException e) {
			LOG.error("Error occured.", e);
		}

	}

	public List<Train> findTrainsByDate(Date startDate, Date endDate)
			throws SQLException {
		List<Train> list = new ArrayList<Train>();
		String sql = getSelectQuery();
		sql += " WHERE " + Fields.TRAIN_DEPARTURE_DATE + " between ? and ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setDate(1, new java.sql.Date(startDate.getTime()));
			statement.setDate(2, new java.sql.Date(endDate.getTime()));
			ResultSet rs = statement.executeQuery();
			list = parseResultSet(rs);
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return list;
	}
	
	public List<Train> findTrainsByRoute(int routeId)
			throws SQLException {
		List<Train> list = new ArrayList<Train>();
		String sql = getSelectQuery();
		sql += " WHERE " + Fields.TRAIN_ROUTE_ID + " = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, routeId);
			ResultSet rs = statement.executeQuery();
			list = parseResultSet(rs);
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return list;
	}

}
