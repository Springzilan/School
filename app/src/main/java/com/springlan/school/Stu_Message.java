package com.springlan.school;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import DBHelper.StudentDBHelper;
import School.User;

public class Stu_Message extends AppCompatActivity {
    private TextView stuidText;
    private EditText nameText;
    private EditText batchText;
    private EditText ageText;
    private EditText DOBText;
    private EditText bloodgroupText;
    private EditText addressText;
    private EditText phoneText;
    private EditText emailText;
    private Button savestudent;
    private StudentDBHelper studentdbhelper;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stu_message);
        stuidText = findViewById(R.id.add_stu_id);
        nameText = findViewById(R.id.add_name);
        batchText = findViewById(R.id.add_batch);
        ageText = findViewById(R.id.add_age);
        DOBText = findViewById(R.id.add_DOB);
        bloodgroupText = findViewById(R.id.add_bloodgroup);
        addressText = findViewById(R.id.add_address);
        phoneText = findViewById(R.id.add_phone);
        emailText = findViewById(R.id.add_email);
        savestudent =findViewById(R.id.savestumes);
        studentdbhelper=new StudentDBHelper(this);
        initView();
    }
     public void initView(){
        savestudent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String stu_id= user.getUsername();
                String name= nameText.getText().toString();
                String batch= batchText.getText().toString();
                int age=Integer.parseInt(ageText.getText().toString());
                String DOB=DOBText.getText().toString();
                String bloodgroup=bloodgroupText.getText().toString();
                String address=addressText.getText().toString();
                String phone =phoneText.getText().toString();
                String email=emailText.getText().toString();
                studentdbhelper.updateStudent(stu_id,name,batch,age,DOB,bloodgroup,address,phone,email);
                Toast.makeText(Stu_Message.this, "保存成功",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
     }
}