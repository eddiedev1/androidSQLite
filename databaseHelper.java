package com.example.eddie.dunna;

/**
 * Created by eddie on 11/28/15.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper{

    //instantiation of the database plus its name
    public static final String DATABASE_BASE = "UserInfo.db";

    //the columns of the database - (tables in the database)
    public static final String TABLE_NAME = "name_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "EMAIL";
    public static final String COL_4 = "PHONE";





    public DatabaseHelper(Context context){
        super(context, DATABASE_BASE, null, 1);

        //to see database that has been created

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //execute the string query TO CREATE WITH ALL THE TABLES
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, EMAIL TEXT, PHONE TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //drop table if table exists
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }


    //method to insert data to dabase that takes all parameters to be inserted
    public boolean insertData (String name, String email, String phone) {
        //instance of the database
        SQLiteDatabase db = this.getWritableDatabase();

        //instance content values
        ContentValues contentValues = new ContentValues();
        //pass the values to database by columns
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, email);
        contentValues.put(COL_4, phone);

        //if data has not been inserted will return false
        //if and else statement were create to check if data has been inserted
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1){
            return false;
        }
        else{
            return true;
        }
    }


    //cursor is an interface
    public Cursor getAllData () {
        SQLiteDatabase db = this.getWritableDatabase();


        //create a query that takes info form database
        // * means all... so select all from database
        //res to be returned
        Cursor res = db.rawQuery("select * from " +TABLE_NAME, null);
        return res;

    }


}
