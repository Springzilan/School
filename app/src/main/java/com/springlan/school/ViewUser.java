package com.springlan.school;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.AbsListView;

import DBHelper.UserDBHelper;
import TableContanst.TableContanst;

import static TableContanst.TableContanst.USER_TABLE;

public class ViewUser extends AppCompatActivity {

    private Cursor cursor;
    private SimpleCursorAdapter adapter;
    private AbsListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user);
    }
    // 调用load()方法将数据库中的所有记录显示在当前页面
    @Override
    protected void onStart() {
        super.onStart();
        load();

    }
    // 自定义一个加载数据库中的全部记录到当前页面的无参方法
    public void load() {
        UserDBHelper userDBHelper = new UserDBHelper(
                ViewUser.this);
        SQLiteDatabase database = userDBHelper.getWritableDatabase();
        cursor = database.query(USER_TABLE, null, null, null,
                null, null, TableContanst.UserColumns.USERNAME);
        startManagingCursor(cursor);
        adapter = new SimpleCursorAdapter(this, R.layout.user_list_item,
                cursor, new String[] { TableContanst.UserColumns.USERNAME,
                TableContanst.UserColumns.USERNAME,
                TableContanst.UserColumns.PASSWORD }, new int[] {
                R.id.tv_user_id, R.id.tv_user_name, });
        listView.setAdapter(adapter);
    }
}