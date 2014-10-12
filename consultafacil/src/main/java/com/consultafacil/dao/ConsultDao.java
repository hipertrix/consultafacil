package com.consultafacil.dao;

import java.util.List;

import com.consultafacil.model.Consult; 
public interface ConsultDao {
	 
 
	void add(Consult consult);

	void refresh(Consult consult);

	void update(Consult consult);

	List<Consult> listAll();	 
	
	
	List<Consult> listAllByUser(int i);	 
	
	
	
 
	
}

