package DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Dao.LeaveDao;
import TableContanst.TableContanst;

import static DBHelper.UserDBHelper.DB_NAME;
import static TableContanst.TableContanst.APPLY_LEAVE_TABLE;
public class LeaveDBHelper extends SQLiteOpenHelper {
    private Cursor cursor;
    public static final String DB_NAME = "student_manager.db";
    private static final String TAG = "ApplyLeaveHelper";
    private static final int VERSION = 1;
    private SQLiteDatabase db;
    private LeaveDBHelper leaveDBHelper;

    public LeaveDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
    }
    public LeaveDBHelper(Context context){
        this(context,DB_NAME,null, VERSION);
    }
    //创建表
    @Override
    public void  onCreate(SQLiteDatabase db){
        Log.v(TAG,"onCreate");
    }
    @Override
    public void onOpen(SQLiteDatabase db){
        db.execSQL("create table if not exists "+ APPLY_LEAVE_TABLE + "(stu_id text primary key,leavedate text,leavereason text)");
Log.v(TAG,"onOpen");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.v(TAG,"onUpgrade");
    }
    //学生请假
    public void applyleave(String stu_id,String leavedate,String leavereason){
        //db.execSQL("INSERT INTO "+ TableContanst.USER_TABLE + " (" + TableContanst.UserColumns.USERNAME+"," + TableContanst.UserColumns.PASSWORD +") VALUES(?,?)",new Object[]{username,password});
        ContentValues values = new ContentValues();
        this.db = this.getWritableDatabase();
        values.put(TableContanst.ApplyleaveColumns.STUID,stu_id);
        values.put(TableContanst.ApplyleaveColumns.LEAVEDATE,leavedate);
        values.put(TableContanst.ApplyleaveColumns.LEAVEREASON,leavereason);
        this.db.insert(APPLY_LEAVE_TABLE,null,values);
        Log.i("sdd",stu_id);
    }
    public List<HashMap<String,Object>>AllQuery(){
        ArrayList<HashMap<String,Object>> list = new ArrayList<>();
        HashMap<String,Object> map;
        String sql = "select * from "+ APPLY_LEAVE_TABLE;
        Log.i("sql",sql);
        this.db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            map= new HashMap<String, Object>();
            String lstu_id = cursor.getString(cursor.getColumnIndex(TableContanst.ApplyleaveColumns.STUID));
            map.put(TableContanst.ApplyleaveColumns.STUID,lstu_id);
            String ldate = cursor.getString(cursor.getColumnIndex(TableContanst.ApplyleaveColumns.STUID));
            map.put(TableContanst.ApplyleaveColumns.LEAVEDATE,ldate);
            String lreason = cursor.getString(cursor.getColumnIndex(TableContanst.ApplyleaveColumns.STUID));
            map.put(TableContanst.ApplyleaveColumns.LEAVEREASON,lreason);
            LeaveDao leaveDao = new LeaveDao(lstu_id,ldate,lreason);
            list.add(map);
        }
        return list;
    }


}
