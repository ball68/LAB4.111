package com.example.lab4111;

public class TextNote extends Note {

    String username;
    String content;

    public void setUsername(String username){
        this.username = username;
    }

    @Override
    public void setTitle(String title){
        super.setTitle(title);
    }

    public void setContent(String content){
        this.content = content;
    }

    @Override
    public void setCreatedDate(String createdDate){
        super.setCreatedDate(createdDate);
    }

    @Override
    public String getSummary(){
        String userStr = (username != null && !username.isEmpty()) ? "UserName : " + username + "\n" : "";
        return userStr +
                "Title : " + getTitle() + "\n" +
                "Date : " + getCreatedDate() + "\n" +
                "Content : " + content;
    }
}