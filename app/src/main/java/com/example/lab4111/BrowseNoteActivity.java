package com.example.lab4111;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class BrowseNoteActivity extends AppCompatActivity {
    private TextView showNote;
    private Button browseButton;
    private EditText searchEditText;
    private Button searchButton;
    private ProgressBar searchProgressBar;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); //[cite: 2]
        setContentView(R.layout.activity_browse_note); //[cite: 2]

        if (findViewById(R.id.main) != null) { //[cite: 2]
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> { //[cite: 2]
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars()); //[cite: 2]
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom); //[cite: 2]
                return insets; //[cite: 2]
            });
        }

        showNote = findViewById(R.id.textView4);
        browseButton = findViewById(R.id.button23); //[cite: 2]
        searchEditText = findViewById(R.id.searchEditText);
        searchButton = findViewById(R.id.searchButton);
        searchProgressBar = findViewById(R.id.searchProgressBar);
        resultTextView = findViewById(R.id.resultTextView);

        // โหลดข้อมูลจาก DB บน Background Thread
        Executors.newSingleThreadExecutor().execute(() -> {
            List<NoteEntity> entities = AppDatabase.getInstance(this).noteDao().getAll();
            List<Note> notes = new ArrayList<>();
            for (NoteEntity e : entities) {
                Note note = NoteMapper.fromEntity(e);
                if (note != null) {
                    notes.add(note);
                }
            }

            // แสดงผลบน UI thread
            runOnUiThread(() -> {
                StringBuilder sb = new StringBuilder();
                for (Note n : notes) {
                    sb.append(n.getSummary()).append("\n\n-------------------\n\n");
                }
                if (showNote != null) {
                    showNote.setText(sb.toString());
                }
            });
        });

        if (browseButton != null) { //[cite: 2]
            browseButton.setOnClickListener(v -> finish()); //[cite: 2]
        }

        if (searchButton != null) {
            searchButton.setOnClickListener(v -> {

                if (resultTextView != null) {
                    resultTextView.setVisibility(View.GONE);
                }
                if (searchProgressBar != null) {
                    searchProgressBar.setVisibility(View.VISIBLE);
                }

                new Thread(() -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    runOnUiThread(() -> {
                        if (searchProgressBar != null) {
                            searchProgressBar.setVisibility(View.GONE);
                        }

                        if (resultTextView != null) {
                            resultTextView.setText("ไม่พบข้อมูล");
                            resultTextView.setVisibility(View.VISIBLE);
                        }
                    });
                }).start();

            });
        }
    }
}