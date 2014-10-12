package com.consultafacil.controller;

  
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject; 

import com.consultafacil.dao.ConsultDao; 
import com.consultafacil.interceptor.Public;
import com.consultafacil.interceptor.UserInfo;
import com.consultafacil.model.Consult;
import com.consultafacil.model.User;
import com.consultafacil.dao.UserDao; 

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
//import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
//import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class ConsultsController {


   private final Validator validator;
	private final Result result;
	private final ConsultDao consultDao;
	private final UserDao userDao; 
	private final UserInfo userInfo;

	
	protected ConsultsController() {
		this(null, null, null, null, null);
	} 
	
	@Inject
	public ConsultsController(ConsultDao dao,UserInfo userInfo, UserDao userDao, Result result, Validator validator) {		
		this.consultDao = dao;
		this.userDao = userDao;
		this.result = result;
		this.validator = validator; 
		this.userInfo = userInfo;
	}
	 	
	@Get("/consults")
	public void list() { 
		  
		result.include("consults", consultDao.listAllByUser(1));
    }
	
	@Get("/new_consult")
	public void new_consult() {
		result.include("patients", userDao.listPatients());
		result.include("doctors", userDao.listDoctors()); 
    }	
	
	@Path("/consult")
	@Post
	@Public
	public void add(Consult consult) { 
		 
		         
		consult.setCreated_at(new Date());
		consultDao.add(consult);

		result.include("notice", "Consulta agendada com sucesso");
		result.redirectTo(ConsultsController.class).list();
	}

	 
	
}