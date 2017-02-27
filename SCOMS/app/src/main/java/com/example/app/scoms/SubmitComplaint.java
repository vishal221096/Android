package com.example.app.scoms;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SubmitComplaint extends AppCompatActivity {
    EditText STUD_ID ,COMPLAINT;
    String stud_id,complaint;
    Button COMP;

    Context ctx = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_complaint);
        STUD_ID =(EditText)findViewById(R.id.studid);
        COMPLAINT =(EditText)findViewById(R.id.regcomplaint);
        COMP = (Button)findViewById(R.id.complaintsubmit);
        COMP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stud_id = STUD_ID.getText().toString();
                complaint = COMPLAINT.getText().toString();

                DatabaseOperations DBA = new DatabaseOperations(ctx);
                DBA.putComplaint(DBA,stud_id,complaint);
                Toast.makeText(getBaseContext(),"Submission Successful & Logging Out",Toast.LENGTH_LONG).show();

                finish();



            }
        });
    }
}
