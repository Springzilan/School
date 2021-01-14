package com.springlan.school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
//还要实现一个选择是老师还是学生
public class MainActivity extends AppCompatActivity {

    private Button mbtnlog;
    private Button mbtnregeist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtnlog=findViewById(R.id.btn_login);
        mbtnregeist=findViewById(R.id.btn_regeist);
//        mbtnlog.setOnClickListener(this);
//        mbtnregeist.setOnClickListener(this);
        mbtnlog.setOnClickListener(v -> CreateIntent(Login.class));
        mbtnregeist.setOnClickListener(v -> CreateIntent(AddUser.class));
    }
    private void CreateIntent(Object ToIntent){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,(Class<?>) ToIntent);
        startActivity(intent);
    }
}