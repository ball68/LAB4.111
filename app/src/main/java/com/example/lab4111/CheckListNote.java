package com.example.lab4111;

public class CheckListNote extends Note {
    private String item;

    public void addItem(String item){
        this.item = item;
    }

    public String getItem(){
        return item;
    }

    @Override
    public String getSummary(){

        return "Title : " + getTitle() + "\nDate : " + getCreatedDate() + "\nItem : " + item;
    }
}