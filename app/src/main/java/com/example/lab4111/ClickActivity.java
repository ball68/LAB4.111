package com.example.lab4111;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ClickActivity extends AppCompatActivity {

    private Button clickMeBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_click);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        clickMeBack = findViewById(R.id.button3);


        clickMeBack.setOnClickListener(v -> {

            Toast.makeText(this, "กำลังย้อนกลับ...", Toast.LENGTH_SHORT).show();


            getOnBackPressedDispatcher().onBackPressed();

            // กรณีถ้าเปิดมาจากหน้าอื่นแล้วยังไม่ย้อน ให้เปิดไปหน้า MainActivity โดยตรง
            // Intent intent = new Intent(ClickActivity.this, MainActivity.class);
            // startActivity(intent);
            // finish();
        });
    }
}