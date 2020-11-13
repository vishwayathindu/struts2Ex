/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vish.controller;

import com.opensymphony.xwork2.ActionContext;
import com.vish.Dao.Dao;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import com.vish.model.User;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author vishwa_p
 */
public class Login extends ActionSupport implements ModelDriven, SessionAware {

    private User user = new User();
    private Map<String, Object> session;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    public String check() {
        System.out.println("----------------Login Start working----------------------");

        String result = Dao.loginCheck(user);

        if (result == "success") {
            this.session = ActionContext.getContext().getSession();
            
            session.put("loginId", user.getUserName());
            
            System.out.println("---------- Assigned a session------------");
        }

        System.out.println("-------------------------Login End Working-----------------" + result);

        return result;
    }

    public String execute() throws Exception {
        return null;
    }

    @Override
    public Object getModel() {
        return user;
    }

}
