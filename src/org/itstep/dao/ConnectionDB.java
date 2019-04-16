package org.itstep.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
	private static final String URL = "jdbc:h2:~/my_first_db";
	private static final String USER_NAME = "anelia";
	private static final String PASSWORD = "1qaz2wsx";
	
	protected static Connection getConnection() {
		
//		Class.forName("");
		try {
			Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	

}
