package com.example.loginapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context) {
        super(context, "user1.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS USER1(username text, password text primary key, name text, phone text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user1");
        onCreate(db);
    }

    public boolean addUser(String username, String password,String name, String phone){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);
        values.put("name",name);
        values.put("phone",phone);
        long result = db.insert("user1", null, values);
        return result != -1;

    }

    public boolean check(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        String q = "select * from user1 where password=? and username=?";
        Cursor c = db.rawQuery(q,new String[]{password,username});
        return c.getCount()!= -1;
    }
}
