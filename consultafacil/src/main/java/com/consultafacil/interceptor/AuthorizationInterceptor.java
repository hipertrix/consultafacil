package com.consultafacil.interceptor;

import static java.util.Arrays.asList;

import java.util.ResourceBundle;

import javax.inject.Inject;

import com.consultafacil.controller.HomeController;
import com.consultafacil.dao.UserDao;
import com.consultafacil.model.User;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack; 
import br.com.caelum.vraptor.validator.I18nMessage;
 
@Intercepts
public class AuthorizationInterceptor {

	private final UserInfo info;
	private final UserDao dao;
	private final Result result;
	private final ResourceBundle bundle;

	@Inject
	public AuthorizationInterceptor(UserInfo info, UserDao dao, 
			Result result, ResourceBundle bundle) {
		this.info = info;
		this.dao = dao;
		this.result = result;
		this.bundle = bundle;
	}
	 
	public AuthorizationInterceptor() {
		this(null, null, null, null);
	}

	@Accepts
	public boolean accepts(ControllerMethod method) {
		return !method.containsAnnotation(Public.class);
	}
 
	@AroundCall
	public void intercept(SimpleInterceptorStack stack) {

		User current = info.getUser();
		try {
			dao.refresh(current);
		} catch (Exception e) {
			// 
		}
 
		if (current == null) {
		 	I18nMessage msg = new I18nMessage("user", "not_logged_user");
			msg.setBundle(bundle);
			result.include("errors", asList(msg));
			result.redirectTo(HomeController.class).login();
			return;
		}
		stack.next();
	}

}
