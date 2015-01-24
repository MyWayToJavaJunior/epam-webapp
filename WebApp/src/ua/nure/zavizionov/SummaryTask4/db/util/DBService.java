package ua.nure.zavizionov.SummaryTask4.db.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.db.dao.DaoFactory;
import ua.nure.zavizionov.SummaryTask4.db.dao.RoleDao;
import ua.nure.zavizionov.SummaryTask4.db.dao.RouteCompositionDao;
import ua.nure.zavizionov.SummaryTask4.db.dao.RouteDao;
import ua.nure.zavizionov.SummaryTask4.db.dao.StationDao;
import ua.nure.zavizionov.SummaryTask4.db.dao.TrainDao;
import ua.nure.zavizionov.SummaryTask4.db.dao.UserDao;
import ua.nure.zavizionov.SummaryTask4.db.dao.WagonDao;
import ua.nure.zavizionov.SummaryTask4.db.entity.Route;
import ua.nure.zavizionov.SummaryTask4.db.entity.RouteComposition;
import ua.nure.zavizionov.SummaryTask4.db.entity.Station;
import ua.nure.zavizionov.SummaryTask4.db.entity.Train;
import ua.nure.zavizionov.SummaryTask4.db.entity.User;
import ua.nure.zavizionov.SummaryTask4.db.entity.Wagon;

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

	public String addStation(String stationName) {
		StationDao dao = null;
		String message = null;
		Connection connection = null;
		Station station = new Station();
		station.setName(stationName);
		try {
			LOG.debug("Opening connection with DB.");
			connection = factory.getConnection();
			LOG.debug("Geting DAO");
			dao = factory.getStationDao(connection);
			if (dao.findByName(stationName) == null) {
				LOG.trace("Adding station");
				dao.persist(station);
				message = "Station added.";
			} else {
				message = "Station already exists.";
				LOG.trace(message);
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
		return message;
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

	public String buyTicket(int wagonId, int count) {
		WagonDao dao = null;
		String message = null;
		Connection connection = null;
		try {
			LOG.debug("Opening connection with DB.");
			connection = factory.getConnection();
			LOG.debug("Geting DAO");
			dao = factory.getWagonDao(connection);
			Wagon wagon = dao.getByPK(wagonId);
			if (dao.getByPK(wagonId) == null) {
				message = "No wagon with such id in db";
				LOG.trace(message);
				return message;
			}
			if (wagon.getSeats()<=0){
				message = "No seats in this wagon";
				LOG.trace(message);
				return message;
			}
			wagon.setSeats(wagon.getSeats() - count);
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
		return message;
	}
}
