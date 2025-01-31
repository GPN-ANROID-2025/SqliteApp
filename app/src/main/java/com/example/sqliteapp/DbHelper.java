package com.example.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {


    public static final  String DB_NAME="mydb";
    public static final  String KEY_NAME="name";
    public static final  String KEY_CITY="city";
    public static final  String TBL_STUDENT="student";
    public static final  String KEY_ID="id";
    public static final  int DB_VERSION=1;


    MyFactory myFactory;
    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME,new MyFactory(), DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create TABLE student (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,city TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertStudent(Student student){

        SQLiteDatabase database=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_NAME,student.getName());
        values.put(KEY_CITY,student.getCity());
        long id=database.insert(TBL_STUDENT,null,values);
        return id;
    }

    public ArrayList<Student> getAllStudents(){

        ArrayList<Student> studentList=new ArrayList<>();

        SQLiteDatabase database=getReadableDatabase();

        Cursor cursor=database.rawQuery("SELECT * FROM "+TBL_STUDENT,null);

        if(cursor.moveToFirst())
        {
            do {


                Student studentObj=new Student();
                /*studentObj.setId(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_ID)));
                studentObj.setName(cursor.getString(cursor.getColumnIndexOrThrow(KEY_NAME)));
                studentObj.setCity(cursor.getString(cursor.getColumnIndexOrThrow(KEY_CITY)));*/

                studentObj.setId(cursor.getInt(0));
                studentObj.setName(cursor.getString(1));
                studentObj.setCity(cursor.getString(2));

                studentList.add(studentObj);

            }while (cursor.moveToNext());

            cursor.close();
        }else{

            Log.d("mytag","No records");
        }


        return studentList;
    }

}
