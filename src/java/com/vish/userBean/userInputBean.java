/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vish.userBean;

import java.util.List;

/**
 *
 * @author vishwa_p
 */
public class userInputBean {
    
    private int userId;
    private String userName;
    private String nic;
    private String password;
    private String gender;
    
    /*------------------------list data table  ------------------------------*/
    private List<userDataBean> gridModel;
    private List<userDataBean> gridModel2;

    public List<userDataBean> getGridModel2() {
        return gridModel2;
    }

    public void setGridModel2(List<userDataBean> gridModel2) {
        this.gridModel2 = gridModel2;
    }
    
    
    
    
    
    public void setGridModel(List<userDataBean> gridModel) {
        this.gridModel = gridModel;
    }

    public List<userDataBean> getGridModel() {
        return gridModel;
    }
    

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getNic() {
        return nic;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
    
}
