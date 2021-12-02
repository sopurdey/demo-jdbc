package fr.digi.d16.demoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnexionJdbc {

	private static final String DB_URL = "jdbc:mariadb://localhost:3306/compta";
	private static final String DB_LOGIN = "root";
	private static final String DB_PWD = "root";

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PWD)) {
			System.out.println(connection);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

}
