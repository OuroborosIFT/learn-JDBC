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
		System.out.println("Static initialize");
		try {
			connection = DriverManager.getConnection(url, login, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/*{
		System.out.println("Initialiuze 1");
	}

	static {
		System.out.println("Static initialize 2");

	}

	public Connect() {
		System.out.println("Constructor");
	}

	{
		System.out.println("Initialiuze 2");
	}

	static {
		System.out.println("Static initialize 3");
	}
*/
	public static Connection getConnection() {
		return connection;
	}

	public void stopConnect() {
		try {
			connection.close();
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
	}

}

