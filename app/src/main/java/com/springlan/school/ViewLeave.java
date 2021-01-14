package com.springlan.school;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DBHelper.LeaveDBHelper;
import School.Leave;
import TableContanst.TableContanst;

import static DBHelper.UserDBHelper.DB_NAME;
import static TableContanst.TableContanst.APPLY_LEAVE_TABLE;

public class ViewLeave extends AppCompatActivity {
    private LeaveDBHelper LeaveDBHelper;
    private Cursor cursor;
    private SimpleAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_leave);
        Log.i("AllQuery", "data.toString()");
        ListView listView = findViewById(R.id.listview);
        LeaveDBHelper = new LeaveDBHelper(this);
        String[] strings ={"id","2","3"};
        Log.i("AllQuery", "data.toString()");
        List<HashMap<String,Object>> data = LeaveDBHelper.AllQuery();
        Log.i("AllQuery", data.toString());
        int[] ids ={R.id.tv_stu_id,R.id.tv_stu_date,R.id.tv_stu_reason};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,data,R.layout.leave_list_item,strings,ids);
        listView.setAdapter(simpleAdapter);
    }

}