package com.consultafacil.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import com.consultafacil.dao.UserDao;
import com.consultafacil.interceptor.Public;
import com.consultafacil.interceptor.UserInfo;
import com.consultafacil.model.User;
import com.consultafacil.validation.LoginAvailable;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
//import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
//import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class UsersController {


   private final Validator validator;
	private final Result result;
	private final UserDao userDao;
	private final UserInfo userInfo;

	
	protected UsersController() {
		this(null, null, null, null);
	}
 
	
	@Inject
	public UsersController(UserDao dao, Result result, Validator validator, 
			UserInfo userInfo) {
		
		this.userDao = dao;
		this.result = result;
		this.validator = validator;
		this.userInfo = userInfo; 
	}

	
	@Get("/")
	public void home() {
		result.include("users", userDao.listAll());
	}

	
	@Get("/users")
	public void list() {
        result.include("users", userDao.listAll());
    }

	
	
	@Path("/users")
	@Post
	@Public
	public void add(@Valid @LoginAvailable User user) {
        validator.onErrorUsePageOf(HomeController.class).login();
        
		userDao.add(user);

		result.include("notice", "User " + user.getName() + " successfully added");
		result.redirectTo(HomeController.class).login();
	}

	
	
	@Path("/users/{user.login}")
	@Get
	public void show(User user) {
	    result.include("user", userDao.find(user.getLogin()));

	    result.forwardTo("/WEB-INF/jsp/users/view.jsp");
	    
	}
	
}