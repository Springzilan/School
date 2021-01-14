package Dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import DBHelper.StudentDBHelper;
import DBHelper.UserDBHelper;

public class StudentDao {
    private final String stu_id;
    private final String name;
    private final String batch;
    private final int age;
    private final String DOB;
    private final String bloodgroup;
    private final String address;
    private final String phone;
    private final String email;
    private Cursor cursor;
    private StudentDBHelper studentDBHelper;
    private SQLiteDatabase db;

    public StudentDao(String stu_id,String name,String batch,int age,String DOB,String bloodgroup,String address,String phone,String email){
        this.stu_id=stu_id;
        this.name=name;
        this.batch=batch;
        this.age=age;
        this.DOB=DOB;
        this.bloodgroup=bloodgroup;
        this.address=address;
        this.phone=phone;
        this.email=email;
    }
}
