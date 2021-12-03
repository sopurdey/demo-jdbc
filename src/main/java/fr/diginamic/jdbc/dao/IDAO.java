package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDAO <T, ID> {
	
	List<T> extraire() throws SQLException;
	void insert( T object ) throws SQLException;
	void update(T object) throws SQLException;
	void delete(T object) throws SQLException;
}
