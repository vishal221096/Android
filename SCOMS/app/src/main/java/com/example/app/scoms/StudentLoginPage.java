package com.example.app.scoms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentLoginPage extends AppCompatActivity {
        private static Button student_login;
        private static Button newstudent_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login_page);
        OnClickButtonListner();
        OnClickButtonListner();
    }
    public void OnClickButtonListner(){
        student_login = (Button) findViewById(R.id.studentlogin);
        newstudent_register = (Button) findViewById(R.id.newstudentregister);
        student_login.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.app.scoms.StudentPage");
                        startActivity(intent);
                    }
                }
        );
        newstudent_register.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.app.scoms.NewStudentReg");
                        startActivity(intent);
                    }
                }
        );


    }
}
