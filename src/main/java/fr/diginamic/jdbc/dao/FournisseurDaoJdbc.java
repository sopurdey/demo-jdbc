package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.PersistenceManager;
import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDaoJdbc implements IDAO<Fournisseur, Integer> {

	private final String EXTRACT_QUERY = "SELECT * FROM FOURNISSEUR";
	private final String INSERT_QUERY = "INSERT INTO FOURNISSEUR (NOM) VALUES (?)";
	private final String UPDATE_QUERY = "UPDATE FOURNISSEUR SET NOM='?'  WHERE ID = ?";
	private final String DELETE_QUERY = "DELETE FROM FOURNISSEUR WHERE ID = ?";

	@Override
	public List<Fournisseur> extraire() throws SQLException {
		List<Fournisseur> fournisseurs = new ArrayList<>();
		Connection connection = PersistenceManager.getConnection();
		try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(EXTRACT_QUERY)) {
			while (rs.next()) {
				Fournisseur fournisseur = new Fournisseur(rs.getInt(1), rs.getString("NOM"));
				fournisseurs.add(fournisseur);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return fournisseurs;
	}

	@Override
	public void insert(Fournisseur fournisseur) throws SQLException {
		Connection connection = PersistenceManager.getConnection();
		try (PreparedStatement pst = connection.prepareStatement(INSERT_QUERY)) {
			pst.setString(1, fournisseur.getNom());
			pst.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void update(Fournisseur fournisseur) throws SQLException {
		Connection connection = PersistenceManager.getConnection();
		try (PreparedStatement pst = connection.prepareStatement(UPDATE_QUERY)) {
			pst.setString(1, fournisseur.getNom());
			pst.setInt(2, fournisseur.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
	}

	@Override
	public void delete(Fournisseur fournisseur) throws SQLException {
		Connection connection = PersistenceManager.getConnection();
		try (PreparedStatement pst = connection.prepareStatement(DELETE_QUERY)) {
			pst.setInt(1, fournisseur.getId());
			pst.setInt(1, fournisseur.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}		
	}

}
