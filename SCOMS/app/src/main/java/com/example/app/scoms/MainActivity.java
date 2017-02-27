package com.example.app.scoms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
        private static Button admin_login_page;
        private static Button student_login_page;
    /**     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickButtonListner();
        onClickButtonListner();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }
    public void onClickButtonListner(){
        admin_login_page = (Button) findViewById(R.id.adminloginpage);
        student_login_page = (Button) findViewById(R.id.studentloginpage);
        admin_login_page.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.app.scoms.AdminLoginPage");
                        startActivity(intent);
                    }
                }
        );
        student_login_page.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.app.scoms.StudentLoginPage");
                        startActivity(intent);
                    }
                }
        );
    }



}
