package com.example.baitest1.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DtabaseName = "sqlThuchi";
    public static final int version = 5;
    public static final String Loaichi = "CREATE TABLE Loaichi (Maloaichi text PRIMARY KEY, Tenloaichi text )";
    public static final String Khoanchi = "CREATE TABLE Khoanchi(Makhoanchi text primary key, Maloaichi text, Tenkhoanchi text, sotien decimal, ngaychi text )";
    public static final String Loaithu = "CREATE TABLE Loaithu (Maloaithu text PRIMARY KEY, Tenloaithu text )";
    public static final String Khoanthu = "CREATE TABLE Khoanthu (Makhoanthu text primary key,Maloaithu text, Tenkhoanthu text, sotien decimal, ngaychi text )";

    public DatabaseHelper(Context context) {
        super(context, DtabaseName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Loaithu);
        db.execSQL(Khoanthu);
        db.execSQL(Loaichi);
        db.execSQL(Khoanchi);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Loaichi");
        db.execSQL("DROP TABLE IF EXISTS Khoanchi");
        db.execSQL("DROP TABLE IF EXISTS Loaithu");
        db.execSQL("DROP TABLE IF EXISTS Khoanthu");
        onCreate(db);
    }
}
