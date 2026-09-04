package com.example.lab4111;

import com.google.gson.Gson;
import java.util.Date;

public class NoteMapper {

    static Gson gson = new Gson();

    public static NoteEntity toEntity(Note note) {
        if (note instanceof TextNote) {
            TextNote textNote = (TextNote) note;
            String title = note.getTitle() != null ? note.getTitle() : "";

            NoteEntity entity = new NoteEntity(
                    title,
                    "text",
                    null,
                    textNote.content,
                    new Date()
            );
            entity.username = textNote.username; // ส่งค่า username ไปเก็บใน Entity
            return entity;
        }
        return null;
    }

    public static Note fromEntity(NoteEntity entity) {
        if (entity == null) return null;

        if ("text".equals(entity.type)) {
            TextNote note = new TextNote();
            note.setUsername(entity.username); // ดึงค่า username กลับมาตั้งใน TextNote
            note.setTitle(entity.title);
            note.setContent(entity.content);

            if (entity.createdDate != null) {
                note.setCreatedDate(entity.createdDate.toString());
            } else {
                note.setCreatedDate("");
            }
            return note;
        }
        return null;
    }
}