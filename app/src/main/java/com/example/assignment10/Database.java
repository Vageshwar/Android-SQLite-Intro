package com.example.assignment10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    public static final String DATABASENAME = "myDB";
    public static final int VERSION = 1;
    public  static  String COLUMN1 = "ROLL_NO";
    public  static  String COLUMN2 = "NAME";
    public  static  String COLUMN3 = "EMAIL";
    public  static  String COLUMN4 = "BRANCH";
    public  static  String COLUMN5 = "GENDER";
    public  static  String COLUMN6 = "LANGUAGE";


    public Database(Context context){
        super(context,DATABASENAME,null,VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql = "CREATE TABLE STUDENT(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN1 + " INTEGER," + COLUMN2 + " TEXT," +
                COLUMN3 + " TEXT," + COLUMN4 + " TEXT," +
                COLUMN5 + " TEXT," + COLUMN6 + " TEXT)";
        sqLiteDatabase.execSQL(sql);

    }

    public  Student getRoll(String RollNo){
        Student s = new Student(0,"Null","NULL","Null","NULL","NULL");
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * from STUDENT WHERE "+ COLUMN1 +" = ?";
        Cursor cursor = db.rawQuery(sql,new String[]{RollNo});

        if(cursor !=null){
            cursor.moveToFirst();
           s.setRollNo(cursor.getInt(1));
           s.setName(cursor.getString(2));
           s.setBranch(cursor.getString(4));
           s.setGender(cursor.getString(5));
           s.setEmail(cursor.getString(3));
           s.setLanguagesKnown(cursor.getString(6));
        }
        return  s;
    }

    public ArrayList<Student> getAll(){
        ArrayList<Student> students = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * from STUDENT";
        Cursor cursor = db.rawQuery(sql,new String[]{});

        if(cursor !=null){
            cursor.moveToFirst();
        }
        while (!cursor.isAfterLast()){

            students.add(new Student(cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6)));
            cursor.moveToNext();
        }


        return  students;
    }

    public void insertStudent(Student s){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN1,s.getRollNo());
        contentValues.put(COLUMN2,s.getName());
        contentValues.put(COLUMN3,s.getEmail());
        contentValues.put(COLUMN4,s.getBranch());
        contentValues.put(COLUMN5,s.getGender());
        contentValues.put(COLUMN6,s.getLanguagesKnown());
        db.insert("STUDENT",null,contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
