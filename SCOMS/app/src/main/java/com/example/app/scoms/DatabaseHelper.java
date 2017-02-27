package com.example.app.scoms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.app.scoms.TableData.TableInfo;
/**
 * Created by Vishal on 17/02/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE " +TableInfo.TABLE_NAME+ " (" +TableInfo.ST_ID+ " TEXT," +TableInfo.CLASS_YEAR+ " TEXT," +TableInfo.FIRST_NAME+ " TEXT," +TableInfo.LAST_NAME+ " TEXT," +TableInfo.PASSWORD+ " TEXT);";


    public DatabaseHelper(Context context) {
        super(context, TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database operations","Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(CREATE_QUERY);
        Log.d("Database operations","Table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void putInformation(DatabaseHelper dop, String stid, String classyear, String firstname, String lastname, String password)
    {
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableInfo.ST_ID,stid);
        cv.put(TableInfo.CLASS_YEAR,classyear);
        cv.put(TableInfo.FIRST_NAME,firstname);
        cv.put(TableInfo.LAST_NAME,lastname);
        cv.put(TableInfo.PASSWORD,password);
        SQ.insert(TableInfo.TABLE_NAME,null,cv);
        Log.d("Database operations","Submitted");


    }

    public Cursor getAllData() {
        SQLiteDatabase SQ = this.getWritableDatabase();
        Cursor res = SQ.rawQuery("select * from " + TableInfo.TABLE_NAME, null);
        return res;

    }



    public Integer deleteRegistrations()
    {
        SQLiteDatabase SQ = this.getWritableDatabase();
        return SQ.delete(TableInfo.TABLE_NAME,null,null);
    }


}






