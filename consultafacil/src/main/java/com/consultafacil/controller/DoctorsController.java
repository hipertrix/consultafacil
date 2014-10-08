package com.consultafacil.controller;

import javax.inject.Inject; 

import br.com.caelum.vraptor.Get; 
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

import com.consultafacil.dao.UserDao; 

public class DoctorsController {

	private final Validator validator;
	private final Result result;
	private final UserDao userDao; 

		
		protected DoctorsController() {
			this(null, null, null);
		}
	 		
		@Inject
		public DoctorsController(UserDao dao, Result result, Validator validator) {			
			this.userDao = dao;
			this.result = result;
			this.validator = validator; 
		}
		
		@Get("/doctors/new")
		public void form() { 
		}
		
}
