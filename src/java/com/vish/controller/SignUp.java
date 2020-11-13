/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vish.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vish.Dao.Dao;
import com.vish.entity.Student;
import com.vish.model.User;

/**
 *
 * @author vishwa_p
 */
public class SignUp extends ActionSupport implements ModelDriven{
    
    Student s = new Student();

    public void setS(Student s) {
        this.s = s;
    }

    public Student getS() {
        return s;
    }
    
    
   
    public String SignUp() {
        
        System.out.println("----------------Sign up Start working----------------------");
        
        String Result=Dao.registerUser(s);
        
        System.out.println("----------------Sign up end working----------------------"+Result);
        
        return Result;
    }
    
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getModel() {
        return s;
    }

    
    
}
