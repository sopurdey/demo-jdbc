package fr.digi.d16.demoJDBC;

import java.sql.SQLException;

import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.dao.IDAO;
import fr.diginamic.jdbc.entites.Fournisseur;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		creerFournisseur();
	}

	private static void creerFournisseur() {
		IDAO<Fournisseur, Integer> fournisseurDao = new FournisseurDaoJdbc();
		Fournisseur fournisseurTest = new Fournisseur(4, "L'Espace Création");
		try {
			fournisseurDao.insert(fournisseurTest);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
