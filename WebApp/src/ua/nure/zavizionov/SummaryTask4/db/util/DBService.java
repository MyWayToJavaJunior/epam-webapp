package ua.nure.zavizionov.SummaryTask4.db.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.derby.client.am.SqlException;
import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.db.dao.DaoFactory;
import ua.nure.zavizionov.SummaryTask4.db.dao.RoleDao;
import ua.nure.zavizionov.SummaryTask4.db.dao.RouteCompositionDao;
import ua.nure.zavizionov.SummaryTask4.db.dao.RouteDao;
import ua.nure.zavizionov.SummaryTask4.db.dao.StationDao;
import ua.nure.zavizionov.SummaryTask4.db.dao.TrainDao;
import ua.nure.zavizionov.SummaryTask4.db.dao.UserDao;
import ua.nure.zavizionov.SummaryTask4.db.dao.WagonDao;
import ua.nure.zavizionov.SummaryTask4.db.dao.WagonTypeDao;
import ua.nure.zavizionov.SummaryTask4.db.entity.Route;
import ua.nure.zavizionov.SummaryTask4.db.entity.RouteComposition;
import ua.nure.zavizionov.SummaryTask4.db.entity.Station;
import ua.nure.zavizionov.SummaryTask4.db.entity.Train;
import ua.nure.zavizionov.SummaryTask4.db.entity.User;
import ua.nure.zavizionov.SummaryTask4.db.entity.Wagon;
import ua.nure.zavizionov.SummaryTask4.db.entity.WagonType;
import ua.nure.zavizionov.SummaryTask4.db.exception.ElementAlreadyExistsException;
import ua.nure.zavizionov.SummaryTask4.db.exception.ElementNotFoundException;
import ua.nure.zavizionov.SummaryTask4.db.exception.NoTicketsException;

public class DBService {

	private static final Logger LOG = Logger.getLogger(DBService.class);

	private DaoFactory factory = null;

	private DBService() {
		factory = DaoFactory.getInstance();
		LOG.debug("DBService created.");
	}

	// Singleton

	private static DBService instance;

	public static synchronized DBService getInstance() {
		if (instance == null) {
			instance = new DBService();
		}
		return instance;
	}

	public User findUserByLogin(String login) {
		LOG.trace("Searching user: " + login);
		UserDao dao = null;
		User user = null;
		Connection connection = null;
		try {
			LOG.debug("Opening connection with DB.");
			connection = factory.getConnection();
			LOG.debug("Geting DAO");
			dao = factory.getUserDao(connection);
			user = dao.getByLogin(login);
		} catch (SQLException e) {
			LOG.error("Error occured: ", e);
		} finally {
			try {
				LOG.debug("Closing connection with DB.");
				connection.close();
			} catch (SQLException e) {
				LOG.error("Error occured: ", e);
			}
		}
		return user;
	}

	public List<Train> findTrainsByDate(Date startDate, Date endDate) {
		LOG.trace("Searching trains from : " + startDate + " to " + endDate);
		TrainDao dao = null;
		List<Train> result = null;
		Connection connection = null;
		try {
			LOG.debug("Opening connection with DB.");
			connection = factory.getConnection();
			LOG.debug("Geting DAO");
			dao = factory.getTrainDao(connection);
			result = dao.findTrainsByDate(startDate, endDate);
		} catch (SQLException e) {
			LOG.error("Error occured: ", e);
		} finally {
			try {
				LOG.debug("Closing connection with DB.");
				connection.close();
			} catch (SQLException e) {
				LOG.error("Error occured: ", e);
			}
		}
		return result;
	}

	public List<RouteComposition> findRouteComposition(int routeId) {
		LOG.trace("Searching route composition for route #" + routeId);
		RouteCompositionDao dao = null;
		List<RouteComposition> result = null;
		Connection connection = null;
		try {
			LOG.debug("Opening connection with DB.");
			connection = factory.getConnection();
			LOG.debug("Geting DAO");
			dao = factory.getRouteCompositionDao(connection);
			result = dao.getByRoute(routeId);
		} catch (SQLException e) {
			LOG.error("Error occured: ", e);
		} finally {
			try {
				LOG.debug("Closing connection with DB.");
				connection.close();
			} catch (SQLException e) {
				LOG.error("Error occured: ", e);
			}
		}
		return result;
	}

	public void addStation(String stationName) throws ElementAlreadyExistsException {
		StationDao dao = null;
		Connection connection = null;
		Station station = new Station();
		station.setName(stationName);
		try {
			LOG.debug("Opening connection with DB.");
			connection = factory.getConnection();
			LOG.debug("Geting DAO");
			dao = factory.getStationDao(connection);
			if (dao.findByName(stationName) == null) {
				LOG.trace("Adding station " + stationName);
				dao.persist(station);
			} else {
				LOG.trace("Station already exists, generating exception");
				throw new ElementAlreadyExistsException();
			}
		} catch (SQLException e) {
			LOG.error("Error occured: ", e);
		} finally {
			try {
				LOG.debug("Closing connection with DB.");
				connection.close();
			} catch (SQLException e) {
				LOG.error("Error occured: ", e);
			}
		}
	}

	public List<Route> findRoutes() {
		LOG.trace("Searching for routes");
		RouteDao dao = null;
		List<Route> result = null;
		Connection connection = null;
		try {
			LOG.debug("Opening connection with DB.");
			connection = factory.getConnection();
			LOG.debug("Geting DAO");
			dao = factory.getRouteDao(connection);
			result = dao.getAll();
		} catch (SQLException e) {
			LOG.error("Error occured: ", e);
		} finally {
			try {
				LOG.debug("Closing connection with DB.");
				connection.close();
			} catch (SQLException e) {
				LOG.error("Error occured: ", e);
			}
		}
		return result;
	}

	public Route findRoute(int routeId){
		
		LOG.trace("Searching for route");
		RouteDao dao = null;
		Route result = null;
		Connection connection = null;
		try {
			LOG.debug("Opening connection with DB.");
			connection = factory.getConnection();
			LOG.debug("Geting DAO");
			dao = factory.getRouteDao(connection);
			result = dao.getByPK(routeId);
		} catch (SQLException e) {
			LOG.error("Error occured: ", e);
		} finally {
			try {
				LOG.debug("Closing connection with DB.");
				connection.close();
			} catch (SQLException e) {
				LOG.error("Error occured: ", e);
			}
		}
		return result;
	}
	
	public void buyTicket(int wagonId, int count) throws ElementNotFoundException, NoTicketsException {
		WagonDao dao = null;
		Connection connection = null;
		try {
			LOG.debug("Opening connection with DB.");
			connection = factory.getConnection();
			LOG.debug("Geting DAO");
			dao = factory.getWagonDao(connection);
			Wagon wagon = dao.getByPK(wagonId);
			if (dao.getByPK(wagonId) == null) {
				LOG.trace("Can't find wagon with such id");
				throw new ElementNotFoundException();
			}
			if (wagon.getSeats()<=0){
				LOG.trace("No sears in this wagon.");
				throw new NoTicketsException();
			}
			LOG.trace("Wagon obtained, decreasing number of seats.");
			int seatsLeft = wagon.getSeats() - count;
			LOG.trace(seatsLeft + " seats left in wagon.");
			wagon.setSeats(seatsLeft);
			dao.update(wagon);
		} catch (SQLException e) {
			LOG.error("Error occured: ", e);
		} finally {
			try {
				LOG.debug("Closing connection with DB.");
				connection.close();
			} catch (SQLException e) {
				LOG.error("Error occured: ", e);
			}
		}
	}
	
	@Deprecated
	public List<Wagon> findWagonsByTrain(int trainId){
		WagonDao dao = null;
		Connection connection = null;
		List<Wagon> wagons = null;
		try {
			LOG.debug("Opening connection with DB.");
			connection = factory.getConnection();
			LOG.debug("Geting DAO");
			dao = factory.getWagonDao(connection);
			wagons = dao.findWagonsByTrain(trainId);
			if (wagons == null || wagons.isEmpty()) {
				LOG.trace("Can't find wagons with such train");
			}
		} catch (SQLException e) {
			LOG.error("Error occured: ", e);
		} finally {
			try {
				LOG.debug("Closing connection with DB.");
				connection.close();
			} catch (SQLException e) {
				LOG.error("Error occured: ", e);
			}
		}
		return wagons;
	}

	public void addTrain(int routeId, Date departureDate, Date arrivalDate) throws SqlException {
		TrainDao dao = null;
		RouteDao routeDao = null;
		Connection connection = null;
		Train train = new Train();
		train.setArrivalDate(arrivalDate);
		train.setDepartureDate(departureDate);
		try {
			LOG.debug("Opening connection with DB.");
			connection = factory.getConnection();
			LOG.debug("Geting DAO");
			dao = factory.getTrainDao(connection);
			//TODO
			routeDao = factory.getRouteDao(connection);
			train.setRoute(routeDao.getByPK(routeId));
			dao.persist(train);
		} catch (SQLException e) {
			LOG.error("Error occured: ", e);
			throw new SqlException(e);
		} finally {
			try {
				LOG.debug("Closing connection with DB.");
				connection.close();
			} catch (SQLException e) {
				LOG.error("Error occured: ", e);
			}
		}
	}
	
	public void addUser(String login, String password, String email, String fullName, int roleId) throws ElementAlreadyExistsException{
		UserDao dao = null;
		RoleDao roleDao = null;
		Connection connection = null;
		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		user.setEmail(email);
		user.setFullName(fullName);
		try {
			LOG.debug("Opening connection with DB.");
			connection = factory.getConnection();
			LOG.debug("Geting DAO");
			dao = factory.getUserDao(connection);
			if(dao.getByLogin(login) != null){
				throw new ElementAlreadyExistsException();
			}
			roleDao = factory.getRoleDao(connection);
			user.setRole(roleDao.getByPK(roleId));
			dao.persist(user);
		} catch (SQLException e) {
			LOG.error("Error occured: ", e);
		} finally {
			try {
				LOG.debug("Closing connection with DB.");
				connection.close();
			} catch (SQLException e) {
				LOG.error("Error occured: ", e);
			}
		}
	}
	
	public void addWagon(int trainId, int wagonTypeId, int wagonNumber, double ticket_price) throws SQLException{
		WagonDao dao = null;
		WagonTypeDao wagonTypeDao = null;
		WagonType wagonType = null;
		Connection connection = null;
		Wagon wagon = new Wagon();
		wagon.setNumber(wagonNumber);
		wagon.setTrainId(trainId);
		wagon.setTicketPrice(ticket_price);
		try {
			LOG.debug("Opening connection with DB.");
			connection = factory.getConnection();
			LOG.debug("Geting DAO");
			dao = factory.getWagonDao(connection);
			wagonTypeDao = factory.getWagonTypeDao(connection);
			LOG.trace("Getting wagon type by id");
			wagonType = wagonTypeDao.getByPK(wagonTypeId);
			wagon.setSeats(wagonType.getSeats());
			wagon.setType(wagonType);
			dao.persist(wagon);
		} catch (SQLException e) {
			LOG.error("Error occured: ", e);
			throw new SQLException(e);
		} finally {
			try {
				LOG.debug("Closing connection with DB.");
				connection.close();
			} catch (SQLException e) {
				LOG.error("Error occured: ", e);
			}
		}
	}

	public Train findTrainById(int trainId){
		LOG.trace("Searching for train");
		TrainDao dao = null;
		Train result = null;
		Connection connection = null;
		try {
			LOG.debug("Opening connection with DB.");
			connection = factory.getConnection();
			LOG.debug("Geting DAO");
			dao = factory.getTrainDao(connection);
			result = dao.getByPK(trainId);
		} catch (SQLException e) {
			LOG.error("Error occured: ", e);
		} finally {
			try {
				LOG.debug("Closing connection with DB.");
				connection.close();
			} catch (SQLException e) {
				LOG.error("Error occured: ", e);
			}
		}
		return result;
	}

	


}
