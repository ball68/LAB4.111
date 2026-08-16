package com.example.lab4111;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;

public class AddNoteActivity extends AppCompatActivity {

    EditText username;
    EditText title;
    EditText content;
    Button addButton;
    Button clickMeback;
    TextView showNote;

    NoteController noteController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_note2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.editTextText3);
        title = findViewById(R.id.editTextText);
        content = findViewById(R.id.editTextText2);
        addButton = findViewById(R.id.button5);
        showNote = findViewById(R.id.textView2);
        clickMeback = findViewById(R.id.button7);

        noteController = new NoteController(this);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strOfUsername = username.getText().toString();
                String strOfTitle = title.getText().toString();
                String strOfContent = content.getText().toString();
                String strOfDate = new Date().toString();


                noteController.addUserTextNote(strOfUsername, strOfTitle, strOfContent, strOfDate);


                String resultText = "User: " + strOfUsername + "\nTitle: " + strOfTitle + "\nContent: " + strOfContent + "\nDate: " + strOfDate;
                showNote.setText(resultText);
            }
        });

        clickMeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddNoteActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void displayText(TextNote note) {
        if (showNote != null && note != null) {
            showNote.setText(note.getSummary());
        }
    }
}