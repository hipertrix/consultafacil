package com.consultafacil.controller;

 
import javax.inject.Inject;

import com.consultafacil.dao.UserDao;
import com.consultafacil.interceptor.Public;
import com.consultafacil.interceptor.UserInfo;
import com.consultafacil.model.User;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result; 
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
 
@Controller
public class HomeController {

	private final Result result;
	private final Validator validator;
	private final UserInfo userInfo;
	private final UserDao dao;
	
	/**
	 * @deprecated CDI eyes only
	 */
	protected HomeController() {
		this(null, null, null, null);
	}

	
	@Inject
	public HomeController(UserDao dao, UserInfo userInfo, Result result, Validator validator) {
	    this.dao = dao;
		this.result = result;
	    this.validator = validator;
        this.userInfo = userInfo;
	}

	
	@Post
	@Public
	public void login(String login, String pwd) {
	
		final User currentUser = dao.find(login, pwd);

		validator.check(currentUser != null, new SimpleMessage("login", "invalid_login_or_password"));
		
		validator.onErrorUsePageOf(this).login();

		userInfo.login(currentUser);

		result.redirectTo(UsersController.class).home();
	}

	
	public void logout() {
	    userInfo.logout();
	    result.redirectTo(this).login();
	}

	
	@Public
	@Get
	public void login() {
	}

}