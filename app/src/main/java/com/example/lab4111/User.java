package com.example.lab4111;

public class User {
    private String userId;
    private String username;
    private String email;
    private String password;
    public void setUserId(String userId){
        this.userId = userId;
    }
    public void setUsername(String username){
        this.username = username;

    }
    public String getUsername(){
        return username;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void login(){
        System.out.println(username + " Login Success");
    }

}