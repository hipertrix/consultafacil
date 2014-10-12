package com.consultafacil.controller;

 
 

import javax.inject.Inject; 
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get; 
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

import com.consultafacil.dao.UserDao; 
import com.consultafacil.interceptor.Public;
import com.consultafacil.model.User;
import com.consultafacil.validation.LoginAvailable;

@Controller
public class PatientsController {

	private final Validator validator;
	private final Result result;
	private final UserDao userDao; 
	
		protected PatientsController() {
			this(null, null, null);
		}
	 		
		@Inject
		public PatientsController(UserDao dao, Result result, Validator validator) {			
			this.userDao = dao;
			this.result = result;
			this.validator = validator; 
		}
		
		@Get("/new_patient")
		public void new_patient() { 
		}
		
		
		@Get("/patients")
		public void list() { 
			result.include("users", userDao.listPatients());
	    }

		
		
		
		@Path("/patients")
		@Post
		@Public
		public void add(@Valid @LoginAvailable User user) {
	        validator.onErrorUsePageOf(HomeController.class).login();
	        
	        user.setUser_type(3);
	        
			userDao.add(user);

			result.include("notice", "Médico " + user.getName() + " cadastrado com sucesso");
			result.redirectTo(UsersController.class).home();
		}	
		
		
		@Path("/patients/{user.login}")
		@Get
		public void show(User user) {
		    result.include("user", userDao.find(user.getLogin()));

		    result.forwardTo("/WEB-INF/jsp/patients/view.jsp");
		    
		}
		
		
}
