/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vish.model;

/**
 *
 * @author vishwa_p
 */
public class User {
    
    String userName;
    String Password;
    int userId;
    String userGender;
    String nic;

    public User(String userName, String Password, int userId, String userGender, String nic) {
        this.userName = userName;
        this.Password = Password;
        this.userId = userId;
        this.userGender = userGender;
        this.nic = nic;
        
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserGender() {
        return userGender;
    }

    public String getNic() {
        return nic;
    }
    
    
    

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public User(String userName, String Password) {
        this.userName = userName;
        this.Password = Password;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return Password;
    }
    
    
    
    
    
}
