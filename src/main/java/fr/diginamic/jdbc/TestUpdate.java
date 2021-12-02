package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestUpdate {

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
		// Exo 2 - Connectez vous à la base de données compta puis réalisez une requête qui
		// permet de modifier le nom du fournisseur en « La Maison des Peintures ».
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PWD);
				Statement st = connection.createStatement();) {
			int nb = st.executeUpdate("UPDATE FOURNISSEUR SET NOM='La Maison des Peintures' WHERE ID = 4");
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

}
