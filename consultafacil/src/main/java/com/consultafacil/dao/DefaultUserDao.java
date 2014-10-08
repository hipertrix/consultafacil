package com.consultafacil.dao;
 

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Session;

import com.consultafacil.model.User;

/**
 * Default implementation for UserDao
 *
 * @author Lucas Cavalcanti
 * @author Rodrigo Turini
 */
public class DefaultUserDao implements UserDao {

	private final EntityManager entityManager;

	/**
	 * @deprecated CDI eyes only
	 */
	protected DefaultUserDao() {
		this(null);
	}
 
	@Inject
	public DefaultUserDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public User find(String login, String password) {
		try {
			User user = entityManager
				.createQuery("select u from User u where u.login = :login and u.pwd = :pwd", User.class)
					.setParameter("login", login)
					.setParameter("pwd", password)
					.getSingleResult();
			return user;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public User find(String login) {
		return entityManager.find(User.class, login);
	}

	@Override
	public List<User> listAll() {
		return entityManager.createQuery("select u from User u", User.class).getResultList();
	}
	
	@Override
	public boolean containsUserWithLogin(String login) {
		Long count = entityManager
				.createQuery("select count(u) from User u where u.login = :login", Long.class)
				.setParameter("login", login)
				.getSingleResult();
		return count > 0;
	}
	
	@Override
	public void add(User User) {
		entityManager.persist(User);
	}

	@Override
	public void refresh(User user) {
		getSession().refresh(user);  
	}

	@Override
	public void update(User user) {
		entityManager.merge(user);
	}
	
	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}
}
