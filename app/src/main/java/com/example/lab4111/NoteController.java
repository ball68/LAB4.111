package com.example.lab4111;

import android.content.Context;
import android.util.Log;

import java.util.concurrent.Executors;

public class NoteController {
    private AddNoteActivity addNoteView;

    public NoteController(AddNoteActivity view) {
        this.addNoteView = view;
    }

    public void addUserTextNote(String strUser, String strOfTitle, String strOfContent, String strOfDate) {
        User user = new User();
        user.setUsername(strUser);

        // เปลี่ยนประเภทตัวแปรเป็น TextNote เพื่อให้เรียก setContent ได้
        TextNote note = new TextNote();
        note.setUsername(strUser);
        note.setTitle(strOfTitle);
        note.setContent(strOfContent); // แก้ไข: กำหนด content ให้ถูกต้อง
        note.setCreatedDate(strOfDate);

        UserNote userNote = new UserNote();
        userNote.setUser(user);
        userNote.setNote(note);

        addNoteView.displayText(userNote.showNote());


        NoteEntity entity = NoteMapper.toEntity(note);


        Context context = addNoteView;
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                // save note to Database
                AppDatabase.getInstance(context).noteDao().insert(entity);

                // alert if Insert successful
                Log.d("DatabaseAction", "Insert successful: Note saved to database.");

            } catch (Exception e) {
                // alert if Error inserting
                Log.e("DatabaseAction", "Error inserting note: " + e.getMessage());
            }
        });
    }
}