package com.springlan.school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

import DBHelper.UserDBHelper;
import Dao.UserDao;
import School.User;
import TableContanst.TableContanst;

public class AddUser extends AppCompatActivity{

    private boolean isAdd = true;
    private EditText usernameText;
    private EditText passwordText;
    private UserDao dao;
    private Button adduser;
    private UserDBHelper userdbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        usernameText = findViewById(R.id.username);
        passwordText = findViewById(R.id.password);
        adduser =findViewById(R.id.adduser);
        userdbhelper=new UserDBHelper(this);
        initView();
}
    private void initView(){
        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=usernameText.getText().toString();
                String password=passwordText.getText().toString();
                userdbhelper.addUser(username,password);
                Toast.makeText(AddUser.this, "保存成功",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}