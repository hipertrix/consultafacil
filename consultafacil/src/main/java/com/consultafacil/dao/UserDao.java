package com.consultafacil.dao;

import com.consultafacil.model.User;



import java.util.List;

import org.hibernate.HibernateException;


public interface UserDao {
 
	User find(String login, String pwd);
 
	User find(String login);
 
	void add(User user);

	void refresh(User user);

	void update(User user);

	List<User> listAll();

	boolean containsUserWithLogin(String login);

	
}
