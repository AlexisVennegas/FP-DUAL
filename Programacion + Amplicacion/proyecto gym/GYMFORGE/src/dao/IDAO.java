package dao;

import java.util.List;

public interface IDAO<K, T> {
	
	List<T> findAll() throws DAOException;

	T findOne(K key) throws DAOException;

	Long createReturnId(T item) throws DAOException;
	
	void create(T item) throws DAOException;

	void update(T item) throws DAOException;

	void delete(K key) throws DAOException;
}
