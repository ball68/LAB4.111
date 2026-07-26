package com.example.lab4111;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {

            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            v.setPadding(
                    systemBars.left,
                    systemBars.top,
                    systemBars.right,
                    systemBars.bottom
            );

            return insets;
        });
        User user1 = new User();
        user1.setUserId("6812247013");
        user1.setUsername("Shel");
        user1.setEmail("thiradet.p68@psru.ac.th");
        user1.setPassword("44664");
        user1.login();
        TextNote note1 = new TextNote();
        note1.setTitle("LAB4");
        note1.setCreatedDate("20/07/2026");
        note1.setContent("Class");
        CheckListNote list1 = new CheckListNote();
        list1.setTitle("Task Thiradet");
        list1.setCreatedDate("20/07/2026");
        list1.addItem("Program");
        list1.getSummary();
        UserNote userNote1 = new UserNote();
        userNote1.setUser(user1);
        userNote1.setNote(note1);
        userNote1.showNote();
    }

}