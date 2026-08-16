package com.example.lab4111;


public class TextNote extends Note {


    String username;
    String title;
    String content;
    String createdDate;



    public void setUsername(String username){

        this.username = username;

    }



    public void setTitle(String title){

        this.title = title;

    }



    public void setContent(String content){

        this.content = content;

    }



    public void setCreatedDate(String createdDate){

        this.createdDate = createdDate;

    }




    public String getSummary(){

        return "UserName : " + username + "\n" +
                "Title : " + title + "\n" +
                "Date : " + createdDate + "\n" +
                "Content : " + content;

    }

}