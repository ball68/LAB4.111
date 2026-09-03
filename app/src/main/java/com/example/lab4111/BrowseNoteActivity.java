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

public class BrowseNoteActivity extends AppCompatActivity {

    private Button browseButton; // ปุ่มย้อนกลับ Back[cite: 2]
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

        // ผูก View จาก XML
        browseButton = findViewById(R.id.button23); //[cite: 2]
        searchEditText = findViewById(R.id.searchEditText);
        searchButton = findViewById(R.id.searchButton);
        searchProgressBar = findViewById(R.id.searchProgressBar);
        resultTextView = findViewById(R.id.resultTextView);

        // ปุ่มย้อนกลับ[cite: 2]
        if (browseButton != null) { //[cite: 2]
            browseButton.setOnClickListener(v -> finish()); //[cite: 2]
        }

        // โค้ดเมื่อคลิกปุ่มค้นหา
        if (searchButton != null) {
            searchButton.setOnClickListener(v -> {

                // 1. ซ่อนข้อความผลลัพธ์เก่า และแสดง ProgressBar ขึ้นมาระหว่างรอ
                if (resultTextView != null) {
                    resultTextView.setVisibility(View.GONE);
                }
                if (searchProgressBar != null) {
                    searchProgressBar.setVisibility(View.VISIBLE);
                }

                // 2. ใช้ Thread ในการจำลองการโหลดข้อมูล
                new Thread(() -> {
                    try {
                        // ดีเลย์ 2 วินาที (2000 ms)
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // 3. เมื่อโหลดเสร็จ ให้อัปเดต UI กลับมาใน Main Thread
                    runOnUiThread(() -> {
                        // ซ่อน ProgressBar
                        if (searchProgressBar != null) {
                            searchProgressBar.setVisibility(View.GONE);
                        }

                        // แสดงข้อความ "ไม่พบข้อมูล"
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