package com.example.lab4111;

public class UserNote {
    private User user;
    private Note note;
    public void setUser(User user){
        this.user = user;

    }
    public void setNote(Note note){
        this.note = note;
    }
    public void showNote(){
        System.out.println("User : " + user.getUsername());
        note.getSummary();

    }
}
