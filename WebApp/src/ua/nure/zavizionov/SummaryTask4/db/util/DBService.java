package ua.nure.zavizionov.SummaryTask4.db.util;


import java.sql.Connection;
import java.sql.SQLException;

import ua.nure.zavizionov.SummaryTask4.db.dao.DaoFactory;
import ua.nure.zavizionov.SummaryTask4.db.dao.UserDao;
import ua.nure.zavizionov.SummaryTask4.db.entity.User;



public class DBService {
	
	//Singleton
	
		private static DBService instance;
		
		public static synchronized DBService getInstance() {
			if (instance == null) {
				instance = new DBService();
			}
			return instance;
		}
		
		public User findUserByLogin(String login){
			DaoFactory factory = DaoFactory.getInstance();
			Connection connection = null;
			UserDao dao = null;
			User user = null;
			try {
				connection = factory.getConnection();
				dao = factory.getUserDao(connection);
				user = dao.getByLogin(login);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return user;
		}
}
