package com.example.assignment10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {

   public StudentAdapter(Context context, ArrayList<Student> students){
       super(context,0,students);
   }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

       Student student = getItem(position);
        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_student, parent, false);
        }
        TextView rollNo = convertView.findViewById(R.id.rollNo);
        TextView name = convertView.findViewById(R.id.name);
        TextView email = convertView.findViewById(R.id.Email);
        TextView branch = convertView.findViewById(R.id.branch);
        TextView gender = convertView.findViewById(R.id.gender);
        TextView languages = convertView.findViewById(R.id.language);

        rollNo.setText(Integer.toString(student.getRollNo()));
        name.setText(student.getName());
        email.setText(student.getEmail());
        branch.setText(student.getBranch());
        languages.setText(student.getLanguagesKnown());
        gender.setText(student.getGender());
        return convertView;
    }
}
