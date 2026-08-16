package com.example.lab4111;

public class NoteController {
    private AddNoteActivity addNoteView;

    public NoteController(AddNoteActivity view) {
        this.addNoteView = view;
    }

    public void addUserTextNote(String strUser, String strOfTitle, String strOfContent, String strOfDate) {
        User user = new User();
        user.setUsername(strUser);

        Note note = new TextNote();
        note.setTitle(strOfTitle);
        note.setCreatedDate(strOfContent);
        note.setCreatedDate(strOfDate);

        UserNote userNote = new UserNote();
        userNote.setUser(user);
        userNote.setNote(note);

        addNoteView.displayText(userNote.showNote());
    }
}