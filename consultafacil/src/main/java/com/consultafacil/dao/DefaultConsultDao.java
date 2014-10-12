package com.consultafacil.dao; 
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager; 
import javax.persistence.NoResultException;

import org.hibernate.Session;

import com.consultafacil.model.Consult; 
import com.consultafacil.model.User;
 
public class DefaultConsultDao implements ConsultDao {

	private final EntityManager entityManager;

	/**
	 * @deprecated CDI eyes only
	 */
	protected DefaultConsultDao() {
		this(null);
	}
 
	@Inject
	public DefaultConsultDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

 

	 

	@Override
	public List<Consult> listAll() {
		return entityManager.createQuery("select c from Consult c", Consult.class).getResultList();
	}
	   

	@Override
	public List<Consult> listAllByUser(int id) { 
		return entityManager.createQuery("select c, p.name from Consult c, User p where p.id = c.patient_id and c.doctor_id = :doctor_id order by date, ini_time desc", 
				Consult.class).setParameter("doctor_id", id).getResultList();
	}
 
	@Override
	public void add(Consult consult) {
		entityManager.persist(consult);
	}

	@Override
	public void refresh(Consult consult) {
		getSession().refresh(consult);  
	}

	@Override
	public void update(Consult consult) {
		entityManager.merge(consult);
	}
	
	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}
}
