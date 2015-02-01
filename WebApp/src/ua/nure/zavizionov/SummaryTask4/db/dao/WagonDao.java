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
import ua.nure.zavizionov.SummaryTask4.db.entity.RouteComposition;
import ua.nure.zavizionov.SummaryTask4.db.entity.Wagon;
import ua.nure.zavizionov.SummaryTask4.db.util.DBService;

public class WagonDao extends AbstractDao<Wagon>{
	
	private static final Logger LOG = Logger.getLogger(WagonDao.class);

	public WagonDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Wagon create() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSelectQuery() {
		return "SELECT * FROM wagons ";
	}

	@Override
	public String getUpdateQuery() {
		return "UPDATE wagons SET seats = ?, type_id = ?, number = ?, ticket_price = ? "
				+ "WHERE id = ?";
	}

	@Override
	public String getDeleteQuery() {
		return "DELETE FROM wagons WHERE id = ?";
	}

	@Override
	public String getCreateQuery() {
		return "INSERT INTO wagons (" + Fields.WAGON_SEATS +", " + Fields.WAGON_TYPE_ID +
		", " + Fields.WAGON_NUMBER + ", " + Fields.WAGON_TRAIN_ID + ", " + Fields.WAGON_TICKET_PRICE 
		+ ") VALUES (?, ?, ?, ?, ?)";
	}

	@Override
	protected List<Wagon> parseResultSet(ResultSet rs) {
		LOG.debug("Parsing starts");
		List<Wagon> result = new ArrayList<Wagon>();
		DaoFactory factory = DaoFactory.getInstance();
		LOG.debug("Getting wagon type DAO");
		WagonTypeDao wtDao = factory.getWagonTypeDao(connection);
		try {
			while (rs.next()){
				Wagon wagon = new Wagon();
				wagon.setId(rs.getInt(Fields.ID));
				wagon.setTrainId(rs.getInt(Fields.WAGON_TRAIN_ID));
				wagon.setSeats(rs.getInt(Fields.WAGON_SEATS));
				wagon.setType(wtDao.getByPK(rs.getInt(Fields.WAGON_TYPE_ID)));
				wagon.setNumber(rs.getInt(Fields.WAGON_NUMBER));
				wagon.setTicketPrice(rs.getDouble(Fields.WAGON_TICKET_PRICE));
				result.add(wagon);
			}
		} catch (SQLException e) {
			LOG.error("Error occured while parsing", e);
		}
		LOG.debug("Parsed.");
		return result;
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement,
			Wagon object) {
		LOG.debug("Prepearing statemant");
		try {
			statement.setInt(1, object.getSeats());
			statement.setInt(2, object.getType().getId());
			statement.setInt(3, object.getNumber());
			statement.setInt(4, object.getTrainId());
			statement.setDouble(5, object.getTicketPrice());
		} catch (SQLException e) {
			LOG.error("Error occured", e);
		}
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement,
			Wagon object) {
		try {
			LOG.trace("Prepearing statement fo update");
			statement.setInt(1, object.getSeats());
			statement.setInt(2, object.getType().getId());
			statement.setInt(3, object.getNumber());
			statement.setInt(4, object.getId());
			statement.setDouble(5, object.getTicketPrice());
		} catch (SQLException e) {
			LOG.error("Error occured", e);
		}
		
	}
	
	public List<Wagon> findWagonsByTrain(int trainId) throws SQLException{
		List<Wagon> list = new ArrayList<Wagon>();
		String sql = getSelectQuery();
		sql += " WHERE " + Fields.WAGON_TRAIN_ID + " = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1, trainId);
			ResultSet rs = statement.executeQuery();
			list = parseResultSet(rs);
		}catch (Exception e){
			throw new SQLException(e);
		}
		if (list == null || list.size() == 0){
			LOG.warn("No wagons was founded.");
		}
		return list;
	}
	
}
