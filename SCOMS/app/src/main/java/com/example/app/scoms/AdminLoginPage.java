package com.example.app.scoms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLoginPage extends AppCompatActivity {
 private static Button admin_login;
    EditText ADMIN_USER,ADMIN_PASS;
    String admin_user,admin_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login_page);
        OnClickButtonListner();
    }

    public void OnClickButtonListner(){
        admin_login = (Button) findViewById(R.id.adminlogin);
        ADMIN_USER = (EditText)findViewById(R.id.adminuser);
        ADMIN_PASS = (EditText)findViewById(R.id.adminpass);
        admin_user =  ADMIN_USER.getText().toString();
        admin_pass =  ADMIN_PASS.getText().toString();


        admin_login.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (admin_user != null && admin_pass != null ) {
                            Intent intent = new Intent("com.example.app.scoms.AdminPage");
                            startActivity(intent);
                        } else
                            Toast.makeText(getBaseContext(), "Invalid Username Or Password.", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
}

