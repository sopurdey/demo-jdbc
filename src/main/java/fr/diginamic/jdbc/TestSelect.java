package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class TestSelect {

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
		// Exo 4 - Connectez vous à la base de données
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PWD);
				Statement st = connection.createStatement(); ResultSet curseur = st.executeQuery("SELECT * FROM FOURNISSEUR");) {
			// puis réalisez une requête qui permet d’extraire la liste de tous les
			// fournisseurs.
			// Les données recueillies de la base de données permettront de créer des
			// instances de fournisseurs qui seront stockées dans une ArrayList
			
			ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
			
			while (curseur.next()) {
				Integer id = curseur.getInt("ID");
				String nom = curseur.getString("NOM");
				
				Fournisseur fournisseur = new Fournisseur(id, nom);
				fournisseurs.add(fournisseur);
				System.out.println(fournisseur);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
	}

}
