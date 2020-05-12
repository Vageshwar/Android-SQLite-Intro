package com.example.assignment10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AddActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener, CheckBox.OnCheckedChangeListener {

    Student student;
    EditText user,pass,email,rollno;
    Button register;
    String gender,branch;
    Spinner br;
    ArrayList<String> languagesKnown;
    RadioGroup rg;
    Database database;
    CheckBox[] languages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        user = findViewById(R.id.etUser);
        pass = findViewById(R.id.etPass);
        email = findViewById(R.id.etEmail);
        br = findViewById(R.id.spinner);
        rollno = findViewById(R.id.rollNumber);
        languagesKnown = new ArrayList<>();

        student = new Student();
        database = new Database(this);
        languages = new CheckBox[6];
        languages[0] = findViewById(R.id.lC);
        languages[1] = findViewById(R.id.lCpp);
        languages[2] = findViewById(R.id.jcs);
        languages[3] = findViewById(R.id.ljava);
        languages[4] = findViewById(R.id.lpython);
        languages[5] = findViewById(R.id.lphp);
        for(CheckBox c: languages)
            c.setOnCheckedChangeListener(this);
        rg = findViewById(R.id.GenderGroup);
        rg.setOnCheckedChangeListener(this);
        br.setOnItemSelectedListener(this);

    }

    public void Register(View view) {
        if(!user.getText().toString().isEmpty() || !pass.getText().toString().isEmpty() ||
                !email.getText().toString().isEmpty()||gender!=null || !rollno.getText().toString().isEmpty())
        {
            student.setRollNo(Integer.parseInt(rollno.getText().toString()));
            student.setName(user.getText().toString());
            student.setEmail(email.getText().toString());
            student.setGender(gender);
            student.setBranch(branch);
            if(!languagesKnown.isEmpty()){
                String t = languagesKnown.get(0);
                for(int i=1;i<languagesKnown.size();i++)
                    t+=","+ languagesKnown.get(i);
                student.setLanguagesKnown(t);
            }
            else{
                Toast.makeText(this,"No Languages are Selected",Toast.LENGTH_SHORT).show();
                student.setLanguagesKnown("Null");
            }
            database.insertStudent(student);
            finish();


        }
        else
            Toast.makeText(this,"Enter All Fields First",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        branch = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        branch = "CSE";
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        switch (i){
            case R.id.male:
                gender = "Male";
                break;
            case R.id.female:
                gender = "Female";
                break;
            case R.id.other:
                gender = "Other";
                break;
        }
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        boolean checked = b;
        switch (compoundButton.getId())
        {
            case R.id.lC:
                if(checked)
                    languagesKnown.add("C");
                else
                    languagesKnown.remove("C");
                break;
            case R.id.lCpp:
                if(checked)
                    languagesKnown.add("Cpp");
                else
                    languagesKnown.remove("Cpp");
                break;
            case R.id.jcs:
                if(checked)
                    languagesKnown.add("C#");
                else
                    languagesKnown.remove("C#");
                break;
            case R.id.ljava:
                if(checked)
                    languagesKnown.add("JAVA");
                else
                    languagesKnown.remove("JAVA");
                break;
            case R.id.lphp:
                if(checked)
                    languagesKnown.add("PHP");
                else
                    languagesKnown.remove("PHP");
                break;
            case R.id.lpython:
                if(checked)
                    languagesKnown.add("Python");
                else
                    languagesKnown.remove("Python");
                break;
        }
    }
}
