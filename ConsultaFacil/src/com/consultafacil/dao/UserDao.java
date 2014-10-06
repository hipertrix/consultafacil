package com.consultafacil.dao;

import com.consultafacil.model.User;



import java.util.List;

import org.hibernate.HibernateException;

public interface  UserDao {

	/**
	 * Finds an user by login and password.
	 *
	 * @return found user if it is unique
	 * @throws HibernateException, if there are more than one user
	 */
	User find(String cpf, String pwd);

	/**
	 * Finds an user by login
	 *
	 * @return found user if it is unique
	 * @throws HibernateException, if there are more than one user
	 */
	User find(String cpf);

	/**
	 * Adds the user on database
	 */
	void add(User user);

	/**
	 * Synchronize the user data with the database. 
	 * Any not saved modification on user will be overwritten.
	 * @return 
	 */
	void refresh(User user);

	/**
	 * Update the user on database.
	 */
	void update(User user);

	/**
	 * Retrieves all users from database.
	 */
	List<User> listAll();

	/**
	 * Checks if there is already an user with given login.
	 *
	 * @return true if there exists a user
	 */
	boolean containsUserWithLogin(String cpf);

	
}
