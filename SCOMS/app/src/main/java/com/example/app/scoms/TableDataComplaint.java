package com.example.app.scoms;

import android.provider.BaseColumns;

/**
 * Created by Vishal on 24/02/2017.
 */

public class TableDataComplaint {


    public TableDataComplaint()
    {

    }

    public static abstract class TableInfoComplaint implements BaseColumns
    {
        public static String DATABASE_NAME_2 = "submitcomplaint";
        public static  String TABLE_NAME_1 = "complaint";
        public static  String STUD_ID = "studid";
        public static  String COMPLAINT = "complaint";
    }


}
