package com.example.sqliteapp;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnStudentItemClickListener{

    DbHelper dbHelper;
    RecyclerView recyclerView;
    StudentAdapter studentAdapter;
    ArrayList<Student> list;
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
        list=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        dbHelper=new DbHelper(MainActivity.this);
        Student student=new Student("Rahul","Mumbai");
        long id=dbHelper.insertStudent(student);
        Log.d("mytag",""+id);
        list=dbHelper.getAllStudents();

        studentAdapter=new StudentAdapter(list,this);
        recyclerView.setAdapter(studentAdapter);
        for(int i=0;i<list.size();i++)
        {
            Log.d("mytag","---------------------------------------------------------");
            Log.d("mytag",""+list.get(i).getId());
            Log.d("mytag",""+list.get(i).getName());
            Log.d("mytag",""+list.get(i).getCity());
        }
    }

    @Override
    public void onItemClick(Student student,int position,String action) {

        Log.d("mytag",""+student.getId());

        if(action.equals("delete"))
        {

            int count= dbHelper.deleteStudent(student.getId());
            if(count>0)
            {

//            list=dbHelper.getAllStudents();
//            studentAdapter=new StudentAdapter(list,MainActivity.this);
//            recyclerView.setAdapter(studentAdapter);
//            studentAdapter.notifyDataSetChanged();

                list.remove(position);
                studentAdapter.notifyDataSetChanged();

            }
        }else
        {
            /*student.setName(student.getName()+" Updated");
            int count= dbHelper.updateStudent(student);
            if(count>0)
            {
                list.set(position,student);
                studentAdapter.notifyDataSetChanged();
            }*/

            ArrayList<Student> studentArrayList=dbHelper.searchStudent("Rahul");
            Log.d("mytag",""+studentArrayList.size());


        }
    }


}