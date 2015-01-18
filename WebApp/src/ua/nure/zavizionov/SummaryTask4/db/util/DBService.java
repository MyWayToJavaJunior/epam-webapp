package ua.nure.zavizionov.SummaryTask4.db.util;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.db.bean.TrainBean;
import ua.nure.zavizionov.SummaryTask4.db.dao.DaoFactory;
import ua.nure.zavizionov.SummaryTask4.db.dao.TrainBeanDao;
import ua.nure.zavizionov.SummaryTask4.db.dao.UserDao;
import ua.nure.zavizionov.SummaryTask4.db.entity.User;



public class DBService {
	
	private static final Logger LOG = Logger.getLogger(DBService.class);
	
	private DaoFactory factory = null;
	
	private DBService(){
		factory = DaoFactory.getInstance();
		LOG.debug("DBService created.");
	}

		//Singleton
	
		private static DBService instance;
		
		
		public static synchronized DBService getInstance() {
			if (instance == null) {
				instance = new DBService();
			}
			return instance;
		}
		
		public User findUserByLogin(String login){
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
			}
			finally{
				try {
					LOG.debug("Closing connection with DB.");
					connection.close();
				} catch (SQLException e) {
					LOG.error("Error occured: ", e);
				}
			}
			return user;
		}
		
		public List<TrainBean> findTrainsByDate(Date startDate, Date endDate){
			LOG.trace("Searching trains from : " + startDate + " to " + endDate);
			TrainBeanDao dao = null;
			List<TrainBean> result = null;
			Connection connection = null;
			try {
				LOG.debug("Opening connection with DB.");
				connection = factory.getConnection();
				LOG.debug("Geting DAO");
				dao = factory.getTrainBeanDao(connection);
				result = dao.findTrainsByDate(startDate, endDate);
			} catch (SQLException e) {
				LOG.error("Error occured: ", e);
			}
			finally{
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
