package com.example.lab4111;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "notes")
public class NoteEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String username; // เพิ่ม field นี้

    @NonNull
    public String title;

    @NonNull
    public String type;

    public String checklistItemsJson;
    public String content;

    public Date createdDate;

    public NoteEntity(@NonNull String title, @NonNull String type, String checklistItemsJson, String content, Date createdDate) {
        this.title = title;
        this.type = type;
        this.checklistItemsJson = checklistItemsJson;
        this.content = content;
        this.createdDate = createdDate;
    }
}