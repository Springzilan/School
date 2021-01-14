package com.springlan.school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

import DBHelper.UserDBHelper;
import School.User;

public class Login extends AppCompatActivity {

    private ImageButton btn_login_main;
    private EditText username;
    private EditText password;
    private UserDBHelper userDBHelper;
    private RadioButton rba;
    private RadioButton rbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_stu);
        username = findViewById(R.id.l_username);
        password = findViewById(R.id.l_password);
        rba= findViewById(R.id.rb1);
        rbs=findViewById(R.id.rb2);
        btn_login_main=findViewById(R.id.im_btn_log);
        userDBHelper = new UserDBHelper(this);
        btn_login_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //.trim()是去掉两边的空格
                String username1 = username.getText().toString().trim();
                String password1 = password.getText().toString().trim();
                //账户密码不为空
                if(!TextUtils.isEmpty(username1)&&!TextUtils.isEmpty(password1)){
                    ArrayList<User> data = userDBHelper.getOneData(username1);
                    boolean match = false;
                    //在数据库中匹配   match是看是否匹配上了
                    for (int i=0;i< data.size();i++){
                        User user = data.get(i);
                        if (username1.equals(user.getUsername())&&password1.equals(user.getPassword())){
                            match = true;
                            break;
                        }else {
                            match=false;
                        }
                    }
                    if(match){
                        Toast.makeText(Login.this,"登录成功",Toast.LENGTH_SHORT).show();
                        if(username1.equals("admin")){
                            Intent intent = new Intent(Login.this, Teacher_main.class);
                            startActivity(intent);
                        }else {
                            Intent intent = new Intent(Login.this, Stu_main.class);
                            startActivity(intent);
                        }
                        finish();
                    }else {
                        Toast.makeText(Login.this,"用户名或密码不正确",Toast.LENGTH_SHORT).show();
                    }
                    //break;
                }
            }
        });
    }
}