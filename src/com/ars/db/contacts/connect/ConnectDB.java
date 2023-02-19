package com.ars.db.contacts.connect;

import java.sql.Connection;

public interface ConnectDB {

	String url = "jdbc:postgresql://localhost:5432/contacts";
	String login = "user";
	String password = "user";

	Connection startConnect();
	void stopConnect();

}
