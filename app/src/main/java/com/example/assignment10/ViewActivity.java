package com.example.assignment10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    EditText roll;
    Button search;
    ListView listView;
    Database database;
    ArrayList<Student> students;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        roll = findViewById(R.id.etRollNo);
        search = findViewById(R.id.filter);
        listView = findViewById(R.id.listView);


        database = new Database(this);

        students = new ArrayList<>();

        students = database.getAll();
        StudentAdapter studentAdapter = new StudentAdapter(this,students);
        listView.setAdapter(studentAdapter);
}
    public void onClick(View view) {

        if(roll.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Enter Roll Number",Toast.LENGTH_SHORT).show();
            finish();
            startActivity(getIntent());
        }
        else {
            Student student = database.getRoll(roll.getText().toString());
            students.clear();
            students.add(student);
        }
    }
}