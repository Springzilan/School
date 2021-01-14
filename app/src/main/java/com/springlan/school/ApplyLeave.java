package com.springlan.school;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import DBHelper.LeaveDBHelper;
import DBHelper.UserDBHelper;

public class ApplyLeave extends AppCompatActivity {

    private EditText editdate;
    private EditText editreason;
    private LeaveDBHelper applyleavedbhelper;
    private Button btnapply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_leave);
        editdate= findViewById(R.id.leavedate);
        editreason = findViewById(R.id.leavereason);
        btnapply = findViewById(R.id.applybtn);
        applyleavedbhelper=new LeaveDBHelper(this);
        initView();
    }
    private void initView(){
        btnapply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stu_id = "123";
                String leavedate=editdate.getText().toString();
                String leavereason=editreason.getText().toString();
                applyleavedbhelper.applyleave(stu_id,leavedate,leavereason);
                Toast.makeText(ApplyLeave.this, "保存成功",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}