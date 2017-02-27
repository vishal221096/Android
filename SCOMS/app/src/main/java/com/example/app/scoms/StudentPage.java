package com.example.app.scoms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentPage extends AppCompatActivity {
    private static Button new_complaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_page);
        OnClickButtonListner();

    }

    public void OnClickButtonListner() {
        new_complaint = (Button) findViewById(R.id.newcomplaint);

        new_complaint.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.app.scoms.SubmitComplaint");
                        startActivity(intent);
                    }
                }
        );

    }
}