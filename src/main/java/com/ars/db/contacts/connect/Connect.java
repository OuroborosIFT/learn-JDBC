package com.ars.db.contacts.connect;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Connect {

	private static final Connection connection;
	private static final String url = "jdbc:postgresql://localhost:5432/contacts";
	private static final String login = "user";
	private static final String password = "user";

	static {
		try {
			connection = DriverManager.getConnection(url, login, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnection() {
		return connection;
	}

	public static boolean stopConnect() {
		boolean isClose = false;

		try {
			connection.close();
			isClose = connection.isClosed();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
				try {
					DriverManager.deregisterDriver(driver);
				} catch (SQLException sqlEx) {
					sqlEx.printStackTrace();
				}
			});
		}
		
		return isClose;
	}

}
