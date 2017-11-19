package com.nostacktrace.images;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static final String JDBC_URL = "jdbc:postgresql://33.33.33.50:5432/whatever?user=whatever&password=whatever";

	public static void init() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection connection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL);
	}
}
