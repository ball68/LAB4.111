package com.example.lab4111;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddNoteActivity extends AppCompatActivity {

    private EditText title;
    private EditText content;
    private Button addButton;
    private Button nodButton;
    private TextView showNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_add_note2);

        if (findViewById(R.id.main) != null) {
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }


        title = findViewById(R.id.editTextText);
        content = findViewById(R.id.editTextText2);
        addButton = findViewById(R.id.button5);

        showNote = findViewById(R.id.textView2);


        if (addButton != null) {
            addButton.setOnClickListener(v -> {
                String inputTitle = title != null ? title.getText().toString().trim() : "";
                String inputContent = content != null ? content.getText().toString().trim() : "";

                SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'GMT'XXX yyyy", Locale.ENGLISH);
                String currentDate = sdf.format(new Date());

                // เช็กเฉพาะ Title และ Content
                if (!inputTitle.isEmpty() && !inputContent.isEmpty()) {
                    String resultText = "Title : " + inputTitle + "\n" +
                            "Date : " + currentDate + "\n" +
                            "Content : " + inputContent;

                    if (showNote != null) {
                        showNote.setText(resultText);
                    }


                    if (title != null) title.setText("");
                    if (content != null) content.setText("");
                } else {
                    Toast.makeText(this, "กรุณากรอกข้อมูลให้ครบถ้วน", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}