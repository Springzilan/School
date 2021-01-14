package com.springlan.school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Stu_main extends AppCompatActivity {
private Button bstuview;
    private Button bapply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_main);
        bstuview= findViewById(R.id.stu_view);
        bapply=findViewById(R.id.apply);
        bstuview.setOnClickListener(v -> CreateIntent(Stu_Message.class));
        bapply.setOnClickListener(v -> CreateIntent(ApplyLeave.class));
    }
    private void CreateIntent(Object ToIntent){
        Intent intent = new Intent();
        intent.setClass(Stu_main.this,(Class<?>) ToIntent);
        startActivity(intent);
    }
}