package com.example.app.scoms;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewStudentReg extends AppCompatActivity {
    EditText ST_ID ,CLASS_YEAR ,FIRST_NAME ,LAST_NAME ,PASSWORD,CONF_PASSWORD;
    String st_id,class_year,first_name,last_name,password,conf_password;
    Button SUBMIT;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student_reg);
        ST_ID = (EditText) findViewById(R.id.stid);
        CLASS_YEAR = (EditText) findViewById(R.id.classyear);
        FIRST_NAME = (EditText) findViewById(R.id.firstname);
        LAST_NAME = (EditText) findViewById(R.id.lastname);
        PASSWORD = (EditText) findViewById(R.id.password);
        CONF_PASSWORD = (EditText) findViewById(R.id.confpassword);
        SUBMIT = (Button) findViewById(R.id.studentsubmit);
        SUBMIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                st_id = ST_ID.getText().toString();
                class_year = CLASS_YEAR.getText().toString();
                first_name = FIRST_NAME.getText().toString();
                last_name = LAST_NAME.getText().toString();
                password = PASSWORD.getText().toString();
                conf_password = CONF_PASSWORD.getText().toString();
                if(!(password.equals(conf_password)))
                {
                    Toast.makeText(getBaseContext(),"PASSWORDS DONOT MATCH.",Toast.LENGTH_LONG).show();
                    ST_ID.setText("");
                    CLASS_YEAR.setText("");

                    FIRST_NAME.setText("");
                    LAST_NAME.setText("");


                    PASSWORD.setText("");
                    CONF_PASSWORD.setText("");




                }
                else
                {
                    DatabaseHelper DB = new DatabaseHelper(ctx);
                    DB.putInformation(DB,st_id,class_year,first_name,last_name,password);
                    Toast.makeText(getBaseContext(),"REGISTRATION SUCCESS.",Toast.LENGTH_LONG).show();
                    finish();
                }







            }
        });




    }
}
