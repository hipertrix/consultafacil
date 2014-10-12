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
public class HelpersController {

	private final Validator validator;
	private final Result result;
	private final UserDao userDao; 
	
		protected HelpersController() {
			this(null, null, null);
		}
	 		
		@Inject
		public HelpersController(UserDao dao, Result result, Validator validator) {			
			this.userDao = dao;
			this.result = result;
			this.validator = validator; 
		}
		
		@Get("/new_helper")
		public void new_helper() { 
		}
		
		
		@Get("/helpers")
		public void list() { 
			result.include("users", userDao.listHelpers());
	    }

		
		
		
		@Path("/helpers")
		@Post
		@Public
		public void add(@Valid @LoginAvailable User user) {
	        validator.onErrorUsePageOf(HomeController.class).login();
	        
	        user.setUser_type(2);
	        
			userDao.add(user);

			result.include("notice", "Médico " + user.getName() + " cadastrado com sucesso");
			result.redirectTo(UsersController.class).home();
		}	
		
		
		@Path("/helpers/{user.login}")
		@Get
		public void show(User user) {
		    result.include("user", userDao.find(user.getLogin()));

		    result.forwardTo("/WEB-INF/jsp/helpers/view.jsp");
		    
		}
		
		
}
