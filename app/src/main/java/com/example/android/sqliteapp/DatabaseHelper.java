package com.example.android.sqliteapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by VenkataManohar on 26/02/2016.
 * This is a SQLiteOpenHelper extended class for Student Database
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DB_NAME = "student.db";
    public final String TBL_NAME = "student_tbl";
    //    public static final String ID_COL = "ID";
    public final String NAME_COL = "NAME";
    public final String SURNAME_COL = "SURNAME";
    public final String MARKS_COL = "MARKS";


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 3);
//        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TBL_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SURNAME TEXT, MARKS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(db);

    }


}
