package ua.nure.zavizionov.SummaryTask4.db.dao.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Init {
	
	public static final String PATH = "jdbc:mysql://localhost:3306/train_booking?useEncoding=true&amp;characterEncoding=UTF-8";
	
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			con = DriverManager.getConnection(PATH,
					"root", "");
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}

}
