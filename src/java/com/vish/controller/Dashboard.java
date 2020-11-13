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
import java.util.List;
import com.vish.model.User;
import com.vish.userBean.userDataBean;
import com.vish.userBean.userInputBean;

/**
 *
 * @author vishwa_p
 */
public class Dashboard extends ActionSupport implements ModelDriven<Object>{
    
    
    
    userInputBean inputBean =new userInputBean();
    
    public Dashboard() {
    }
    
    public String execute() throws Exception {
        return null;
        
    }
    public String view(){
        
       System.out.println("----------------Dashboard Start working--------------------");
        
        List<userDataBean> userLis= Dao.selectAll();
        
        inputBean.setGridModel(userLis);
        
       
       System.out.println("----------------Dashboard End working----------------------");
       
       return "success";
    }
    
    public String jRetrive(){
        System.out.println("----------jRetriveCalled----------");
        
        List<userDataBean> userLis= Dao.selectAll();
        
        inputBean.setGridModel2(userLis);
        
        System.out.println("----------jRetrive Ended----------");
        
        return "jRetrive";
        
        
    }
    
    public String Find(){
        System.out.println("-----------------jFindCalled---------------------------");
        
        System.out.println("--------userID-------------"+inputBean.getUserId());
        
        Student  userLis= Dao.selectUserj(inputBean.getUserId());
        
        inputBean.setUserName(userLis.getStudentName());
        
        inputBean.setNic(userLis.getNic());
        
        inputBean.setGender(userLis.getGender());
        
        return "Find";
        
    }
    
    public String EditJ(){
        System.out.println("-----------------EditJCalled---------------------------");
        
        System.out.println("--------userID-------------"+inputBean.getUserId());
        
        String results= Dao.editUser(inputBean);
        
        System.out.println("----------update user End working------------------"+results);
        
        return "EditJSuccess";
        
    }
    
    public  String DeleteJ(){
    
        System.out.println("----------Deletej user start working------------------");
        
        System.out.println("user id"+ inputBean.getUserId());
        
        String result= Dao.deleteUser(inputBean.getUserId());
        
        System.out.println("------------------------deletedj user-----------"+result);
        
        return "DeletedJSuccess";
    }
    
    
    

    @Override
    public Object getModel() {
        return inputBean;
    }
    
    
    
    
}
