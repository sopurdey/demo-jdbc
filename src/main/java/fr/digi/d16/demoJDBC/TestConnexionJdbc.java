package fr.digi.d16.demoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestConnexionJdbc {

	private static final String DB_URL;
	private static final String DB_LOGIN;
	private static final String DB_PWD;

	static {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
		DB_URL = resourceBundle.getString("jdbc.db.url");
		DB_LOGIN = resourceBundle.getString("jdbc.db.user");
		DB_PWD = resourceBundle.getString("jdbc.db.password");
	}

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PWD)) {
			System.out.println(connection);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

}
