package com.ars.db.contacts.connect;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Connect implements ConnectDB {

	private Connection connection;

	@Override
	public Connection startConnect() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, login, password);
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}

		return connection;
	}

	@Override
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

