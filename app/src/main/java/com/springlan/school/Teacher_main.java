package com.springlan.school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Teacher_main extends AppCompatActivity {

    private Button addstu;
    private Button deletestu;
    private Button viewallstu;
    private Button viewapply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_main);
        addstu = findViewById(R.id.add_stu);
        deletestu=findViewById(R.id.delete_stu);
        viewallstu = findViewById(R.id.view_all_stu);
        viewapply = findViewById(R.id.view_apply);
        addstu.setOnClickListener(v -> CreateIntent(AddStudent.class));
        viewapply.setOnClickListener(v -> CreateIntent(ViewUser.class));
    }
    private void CreateIntent(Object ToIntent){
        Intent intent = new Intent();
        intent.setClass(Teacher_main.this,(Class<?>) ToIntent);
        startActivity(intent);
    }
}