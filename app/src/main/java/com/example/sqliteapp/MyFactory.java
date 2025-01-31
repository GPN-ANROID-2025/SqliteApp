package com.example.sqliteapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.util.Log;

public class MyFactory implements SQLiteDatabase.CursorFactory {
    @Override
    public Cursor newCursor(SQLiteDatabase sqLiteDatabase, SQLiteCursorDriver sqLiteCursorDriver, String s, SQLiteQuery sqLiteQuery) {

        Log.d("mytag",sqLiteQuery.toString());
    return null;
    }
}
