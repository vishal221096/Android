package com.example.app.scoms;

import android.provider.BaseColumns;

/**
 * Created by Vishal on 17/02/2017.
 */

public class TableData {

    public TableData()
    {

    }

    public static abstract class TableInfo implements BaseColumns
    {
        public static String DATABASE_NAME = "student";
        public static String TABLE_NAME = "registration";
        public static String ST_ID = "stid";
        public static String CLASS_YEAR  = "classandyear";


        public static final String FIRST_NAME = "firstname";
        public static String LAST_NAME = "lastname";
        public static final String PASSWORD = "password";






    }
}
