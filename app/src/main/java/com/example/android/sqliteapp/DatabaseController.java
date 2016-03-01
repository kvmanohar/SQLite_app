package com.example.android.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

/**
 * Created by VenkataManohar on 27/02/2016.
 * This class contains Student Database Functions (ADD, Update, Insert adn Delete)
 */
public class DatabaseController {

    private DatabaseHelper dbHelper;
    private Context ourContext;
    private SQLiteDatabase database;

    /**
     * Constructor class
     * @param c  - pass the context to the contructure
     */
    public DatabaseController(Context c){
        ourContext = c;
    }

    /**
     * This Method Opens the database file.
     * @return a new DatabaseController Object.
     * @throws SQLiteException
     */
    public DatabaseController openDB() throws SQLiteException{
        dbHelper = new DatabaseHelper(ourContext);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    /**
     * Close the SQlite database.
     */
    public void closeDB(){
        dbHelper.close();
    }

    /**
     * Inter a row into the Student table
     * @param name Name string of the student
     * @param surname - Surname String of the student
     * @param marks - marks int of the student
     */
    public void insertDbRow(String name, String surname, int marks){
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.NAME_COL,name);
        contentValues.put(dbHelper.SURNAME_COL,surname);
        contentValues.put(dbHelper.MARKS_COL,marks);

        database.insert(dbHelper.TBL_NAME, null, contentValues);

    }

    public Cursor fetchDbRow() {

        String[] columns = new String[] {"_ID",dbHelper.NAME_COL, dbHelper.SURNAME_COL, dbHelper.MARKS_COL};

        Cursor cursor = database.query(dbHelper.TBL_NAME,columns,null,null,null,null,null);
        if (cursor != null)   cursor.moveToFirst();
        return cursor;
    }


}
