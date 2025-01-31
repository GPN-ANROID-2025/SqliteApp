package com.example.sqliteapp;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dbHelper=new DbHelper(MainActivity.this);

        Student student=new Student("Sachin","Mumbai");

        long id=dbHelper.insertStudent(student);

        Log.d("mytag",""+id);

        ArrayList<Student> list=dbHelper.getAllStudents();

        for(int i=0;i<list.size();i++)
        {
            Log.d("mytag","---------------------------------------------------------");
            Log.d("mytag",""+list.get(i).getId());
            Log.d("mytag",""+list.get(i).getName());
            Log.d("mytag",""+list.get(i).getCity());
        }
    }
}