package com.example.lab4111;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button clickMeButton;
    private Button addNoteButton;
    private Button browseNoteButton;
    private ProgressBar loadData;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.main) != null) {
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        // ผูก View จาก XML
        logo = findViewById(R.id.imageView);
        loadData = findViewById(R.id.loadData);
        clickMeButton = findViewById(R.id.button1);
        addNoteButton = findViewById(R.id.button2);
        browseNoteButton = findViewById(R.id.button23);

        if (clickMeButton != null) {
            clickMeButton.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, ClickActivity.class);
                startActivity(intent);
            });
        }

        if (addNoteButton != null) {
            addNoteButton.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
                startActivity(intent);
            });
        }

        if (browseNoteButton != null) {
            browseNoteButton.setOnClickListener(v -> {

                // สั่งให้ ProgressBar แสดงตัวหมุนๆ
                if (loadData != null) {
                    loadData.setVisibility(View.VISIBLE);
                }

                new Thread(() -> {
                    try {
                        Thread.sleep(2000); // รอ 2 วินาที
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    runOnUiThread(() -> {
                        // เมื่อโหลดเสร็จให้ซ่อน ProgressBar
                        if (loadData != null) {
                            loadData.setVisibility(View.GONE);
                        }

                        // ย้ายหน้าไป BrowseNoteActivity
                        Intent intent = new Intent(MainActivity.this, BrowseNoteActivity.class);
                        startActivity(intent);
                    });
                }).start();

            });
        }
    } // <- วงเล็บปิด onCreate
} // <- วงเล็บปิด Classฆ