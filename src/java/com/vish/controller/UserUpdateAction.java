/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vish.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vish.Dao.Dao;
import com.vish.model.User;
import com.vish.userBean.userDataBean;
import com.vish.userBean.userInputBean;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vishwa_p
 */
public class UserUpdateAction extends ActionSupport implements ModelDriven<Object>{
    
    userInputBean inputBean =new userInputBean();
  
    List<userDataBean> newUser;
    
    private Map<String, Object> session;
    
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
    }
    
    
    public UserUpdateAction() {
    }
    
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String Edit() {
        
        System.out.println("---------------------Edit Start Working--------------");
        
        newUser=Dao.selectUser(inputBean.getUserId());
        
        inputBean.setGridModel(newUser);
        
        System.out.println("----------------Edit End working----------------------");
        
        return "edited";
    }
    
    public String Update() {
        
        System.out.println("----------update user start working------------------");
        
        System.out.println("user id"+ inputBean.getUserId());
        
        String results= Dao.editUser(inputBean);
        
        System.out.println("----------update user End working------------------"+results);
        
        return "updated";
        
    }
    
    public String Delete() {
        
        System.out.println("----------Delete user start working------------------");
        
        System.out.println("user id"+ inputBean.getUserId());
        
        String result= Dao.deleteUser(inputBean.getUserId());
        
        System.out.println("------------------------deleted user-----------"+result);
        
        return "deleted";
        
        
    }
    
    public String LogOut() {
        
        System.out.println("-------------Log Out Start Working----------------------------");
        
        this.session = ActionContext.getContext().getSession();
        
        session.remove("loginId");
        
        System.out.println("---------------------session value--------------"+session.toString());
        
        return "logOut";
    
    }

    @Override
    public Object getModel() {
        return inputBean;
    }
    
}
