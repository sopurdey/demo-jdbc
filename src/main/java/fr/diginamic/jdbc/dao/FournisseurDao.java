package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entites.Fournisseur;

public interface FournisseurDao {
	List<Fournisseur> extraire() throws SQLException;

	void insert(Fournisseur fournisseur) throws SQLException;

	void update(Fournisseur fournisseur) throws SQLException;

	void delete(Fournisseur fournisseur) throws SQLException;

}
