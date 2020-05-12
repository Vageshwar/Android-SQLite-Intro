package com.example.assignment10;

import android.database.sqlite.SQLiteDatabase;

public class Student {
    int rollNo;
    String name,email,gender,branch,languagesKnown;

    public Student() {
    }

    public Student(int rollNo, String name, String email, String gender, String branch, String languagesKnown) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.branch = branch;
        this.languagesKnown = languagesKnown;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getLanguagesKnown() {
        return languagesKnown;
    }

    public void setLanguagesKnown(String languagesKnown) {
        this.languagesKnown = languagesKnown;
    }
}
