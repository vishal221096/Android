package com.example.app.scoms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Int2;
import android.support.annotation.IntegerRes;
import android.util.Log;
import com.example.app.scoms.TableDataComplaint.TableInfoComplaint;
/**
 * Created by Vishal on 24/02/2017.
 */

public class DatabaseOperations extends SQLiteOpenHelper {

    public static final int databaseversion = 1;
    public String CREATE_QUERY_COMPLAINT = "CREATE TABLE " +TableInfoComplaint.TABLE_NAME_1+ " (" +TableInfoComplaint.STUD_ID+ " TEXT," +TableInfoComplaint.COMPLAINT+ " TEXT);" ;

    public DatabaseOperations(Context context) {
        super(context, TableInfoComplaint.DATABASE_NAME_2, null, databaseversion);
        Log.d("DATABASE OPERATIONS ","DATABASE CREATED");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY_COMPLAINT);
        Log.d("DATABASE OPERATIONS","TABLE CREATED");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void putComplaint(DatabaseOperations dop,String sid,String complaint)
    {
      SQLiteDatabase SQL = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableInfoComplaint.STUD_ID,sid);
        cv.put(TableInfoComplaint.COMPLAINT,complaint);
        SQL.insert(TableInfoComplaint.TABLE_NAME_1,null,cv);
        Log.d("DATABASE OPERATIONS ","DATA INSERTED");

    }
    public Cursor getComplaint() {
        SQLiteDatabase SQ = this.getWritableDatabase();
        Cursor res = SQ.rawQuery("SELECT * FROM " +TableInfoComplaint.TABLE_NAME_1,null);
        return res;

    }


    public Integer deleteComplaint()
    {
        SQLiteDatabase SQ = this.getWritableDatabase();
        return SQ.delete(TableInfoComplaint.TABLE_NAME_1,null,null);
    }

}
