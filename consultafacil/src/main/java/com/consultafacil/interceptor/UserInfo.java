package com.consultafacil.interceptor;


import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
 

import com.consultafacil.model.User;
 
 
@SessionScoped
@Named
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 773496171272411714L;
    private User user; 

    public User getUser() {
        return user;
    }

    public void login(User user) {
        this.user = user;
    }

    public void logout() {
        this.user = null;
    }
    
   
}