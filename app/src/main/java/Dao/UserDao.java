package Dao;

import android.content.ContentValues;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DBHelper.UserDBHelper;
import School.User;
import TableContanst.TableContanst;

public class UserDao {
    private final String username;
    private final String password;
    private Cursor cursor;
    private  UserDBHelper userdbHelper;
    private SQLiteDatabase db;

    public UserDao(String username,String password){
        this.username=username;
        this.password = password;
    }

}
