package com.springlan.school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

import DBHelper.StudentDBHelper;
import DBHelper.UserDBHelper;
import School.User;
import TableContanst.TableContanst;

public class AddStudent extends AppCompatActivity {
    private StudentDBHelper studentdbhelper;
    private EditText stuidText;
    private EditText nameText;
    private EditText batchText;
    private EditText ageText;
    private EditText DOBText;
    private EditText bloodgroupText;
    private EditText addressText;
    private EditText phoneText;
    private EditText emailText;
    private Button addstudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        stuidText = findViewById(R.id.add_stu_id);
        nameText = findViewById(R.id.add_name);
        batchText = findViewById(R.id.add_batch);
        ageText = findViewById(R.id.add_age);
        DOBText = findViewById(R.id.add_DOB);
        bloodgroupText = findViewById(R.id.add_bloodgroup);
        addressText = findViewById(R.id.add_address);
        phoneText = findViewById(R.id.add_phone);
        emailText = findViewById(R.id.add_email);
        addstudent =findViewById(R.id.addstumes);
        studentdbhelper=new StudentDBHelper(this);
        initView();
    }
    private void initView(){
        addstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stu_id=stuidText.getText().toString();
                String name= nameText.getText().toString();
                String batch= batchText.getText().toString();
                int age=Integer.parseInt(ageText.getText().toString());
                String DOB=DOBText.getText().toString();
                String bloodgroup=bloodgroupText.getText().toString();
                String address=addressText.getText().toString();
                String phone =phoneText.getText().toString();
                String email=emailText.getText().toString();
                studentdbhelper.addStudent(stu_id,name,batch,age,DOB,bloodgroup,address,phone,email);
                Toast.makeText(AddStudent.this, "保存成功",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}