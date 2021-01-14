package DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

import School.User;
import TableContanst.TableContanst;

import static TableContanst.TableContanst.USER_TABLE;

public class UserDBHelper extends SQLiteOpenHelper {
    private Cursor cursor;
    private SQLiteDatabase db;
    private static final String TAG ="UserDBHelper";
    public static final String DB_NAME = "student_manager.db";
    public static final int VERSION =1;
    private UserDBHelper userdbHelper;

    public UserDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
    }
    public UserDBHelper(Context context){
        this(context,DB_NAME,null, VERSION);
    }
    //创建数据库
    @Override
    public void  onCreate(SQLiteDatabase db){
        Log.v(TAG,"onCreate");
        db.execSQL("create table "+ USER_TABLE + "(username text primary key,password text)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.v(TAG,"onUpgrade");
    }

    //添加一个User对象
//    public long addUser(User user){
//        ContentValues values = new ContentValues();
//        values.put(TableContanst.UserColumns.USERNAME,user.getUsername());
//        values.put(TableContanst.UserColumns.PASSWORD,user.getPassword());
//        return userdbHelper.getWritableDatabase().insert(TableContanst.USER_TABLE,null,values);
//    }
    public void addUser(String username,String password){
        ContentValues values = new ContentValues();
        this.db = this.getWritableDatabase();
        values.put(TableContanst.UserColumns.USERNAME,username);
        values.put("password",password);
        this.db.insert(USER_TABLE,null,values);
    }
    //更改一个用户名对应数据表User的账户密码
    public int update(User user){
        ContentValues values = new ContentValues();
        values.put(TableContanst.UserColumns.USERNAME,user.getUsername());
        values.put(TableContanst.UserColumns.PASSWORD,user.getPassword());
        return userdbHelper.getWritableDatabase().update(TableContanst.USER_TABLE,values,TableContanst.UserColumns.USERNAME + "=?",new String[]{user.getUsername() + ""});
    }
    //删除某确定用户名账户密码
    public int deleteUserByName(String username){
        return userdbHelper.getWritableDatabase().delete(TableContanst.USER_TABLE,TableContanst.UserColumns.USERNAME + "=?", new String[]{username + ""});
    }

    //应该是查询很多个
    public ArrayList<User> getOneData(String username){
        ArrayList<User> list= new ArrayList<User>();
        HashMap<String,Object> map;
        String sql ="select * from "+ USER_TABLE;
        if (!username.equals("")){
            sql = sql + " where username like \"" + username +"%\"";
        }
        Log.i("sql",sql);
        //获取SQLiteDatabase对象实例
        this.db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            map = new HashMap<String, Object>();
            String qusername = cursor.getString(cursor.getColumnIndex("username"));
            map.put("username",qusername);
            String qpassword = cursor.getString(cursor.getColumnIndex("password"));
            map.put("password",qpassword);
            User user = new User(qusername,qpassword);
            list.add(user);
        }
        return list;
    }
//    public void closeDB(){userdbHelper.close();}
}
