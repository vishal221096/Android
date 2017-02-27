package com.example.app.scoms;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdminPage extends AppCompatActivity {

    final ThreadLocal<DatabaseHelper> DB = new ThreadLocal<DatabaseHelper>() {
        @Override
        protected DatabaseHelper initialValue() {
            return new DatabaseHelper(ctx);
        }
    };
    Context ctx = this;



    Button view_registrations;
    Button view_complaints;
    Button delete_complaints;
    Button delete_registrations;




    final ThreadLocal<DatabaseOperations> DBA = new ThreadLocal<DatabaseOperations>() {
        @Override
        protected DatabaseOperations initialValue() {
            return new DatabaseOperations(ct);
        }
    };
    Context ct = this;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        view_registrations = (Button) findViewById(R.id.viewregistrations);
        view_complaints = (Button) findViewById(R.id.viewcomplaints);
        delete_complaints = (Button)findViewById(R.id.deletecomplaints);
        delete_registrations = (Button)findViewById(R.id.deleteregistrations);

        viewRegistrations();
        viewComplaints();
        DeleteComplaints();
        DeleteRegistrations();
    }


    public void viewRegistrations()
    {
        view_registrations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Cursor result = DB.get().getAllData();
                if (result.getCount() == 0 )
                {
                    showMessage("Error" , "No Registrations");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (result.moveToNext())
                {
                    buffer.append("ID: " +result.getString(0)+"\n");
                    buffer.append("CLASS: " +result.getString(1)+"\n");
                    buffer.append("FIRST NAME: " +result.getString(2)+"\n");
                    buffer.append("LAST NAME: " +result.getString(3)+"\n");
                    buffer.append("PASSWORD: " +result.getString(4)+"\n\n");


                }
                showMessage("Data" , buffer.toString());


            }
        });
    }



    public void viewComplaints()
    {
        view_complaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DBA.get().getComplaint();
                if(res.getCount()==0)
                {
                 showComplaints("Error","Nothing Found");
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext())
                {
                    buffer.append("STUDENT ID: " +res.getString(0)+"\n");
                    buffer.append("COMPLAINT: " +res.getString(1)+"\n\n");


                }
                showComplaints("Complaints",buffer.toString());

            }
        });
    }

    public void showComplaints(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }








    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }


    public void DeleteComplaints()
    {
        delete_complaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               DatabaseOperations DBA = new DatabaseOperations(ct);
                Integer deletedcomplaints = DBA.deleteComplaint();
                if(deletedcomplaints > 0)
                    Toast.makeText(getBaseContext(),"Complaints Deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(),"No Complaints Found",Toast.LENGTH_LONG).show();


            }
        });
    }





    public void DeleteRegistrations()
    {
        delete_registrations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper DB = new DatabaseHelper(ctx);
                Integer deletedregistrations = DB.deleteRegistrations();
                if(deletedregistrations > 0)
                    Toast.makeText(getBaseContext(),"Registrations Deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(),"No Registrations Found",Toast.LENGTH_LONG).show();


            }
        });
    }



}

