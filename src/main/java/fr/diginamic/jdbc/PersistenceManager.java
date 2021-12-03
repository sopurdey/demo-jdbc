package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class PersistenceManager {
	
	private static Connection connection;
	
	private static final String DB_URL;
	private static final String DB_LOGIN;
	private static final String DB_PWD;
	
	static {
		ResourceBundle resourceBundle = ResourceBundle.getBundle( "db" );
		DB_URL = resourceBundle.getString( "jdbc.db.url" );
		DB_LOGIN = resourceBundle.getString( "jdbc.db.user" );
		DB_PWD = resourceBundle.getString( "jdbc.db.password" );
	}
	
	private PersistenceManager() {
	}
	
	public static Connection getConnection() throws SQLException {
		if(connection == null || !connection.isValid(2)) {
			connection = DriverManager.getConnection( DB_URL, DB_LOGIN, DB_PWD );
		}
		return connection;
	}
	
	public static void closeConnection() throws SQLException {
		if(connection != null && !connection.isClosed()) {
			connection.close();
		}
	}
}
