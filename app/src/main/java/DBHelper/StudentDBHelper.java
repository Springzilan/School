package DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import School.User;
import TableContanst.TableContanst;

import static TableContanst.TableContanst.USER_TABLE;

public class StudentDBHelper extends SQLiteOpenHelper {
    private Cursor cursor;
    private SQLiteDatabase db;
    private static final String TAG ="StudentDBHelper";
    public static final String DB_NAME = "student_manager.db";
    public static final int VERSION =1;
    private StudentDBHelper studentDBHelper;

    public StudentDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
    }
    public StudentDBHelper(Context context){
        this(context,DB_NAME,null, VERSION);
    }
    //创建数据库
    @Override
    public void  onCreate(SQLiteDatabase db){
        Log.v(TAG,"onCreate");
    }
    @Override
    public void onOpen(SQLiteDatabase db){
        db.execSQL("create table "+ TableContanst.Student_TABLE + "(stu_id text primary key,name text,batch text,age integer,DOB text,bloodgroup text,address text,phone text,email text)");
        Log.v(TAG,"onOpen");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.v(TAG,"onUpgrade");
    }

    public void addStudent(String stu_id,String name,String batch,int age,String DOB,String bloodgroup,String address,String phone,String email){
        ContentValues values = new ContentValues();
        this.db = this.getWritableDatabase();
        values.put(TableContanst.StudentColumns.STUID,stu_id);
        values.put(TableContanst.StudentColumns.NAME,name);
        values.put(TableContanst.StudentColumns.BATCH,batch);
        values.put(TableContanst.StudentColumns.AGE,age );
        values.put(TableContanst.StudentColumns.DOB,DOB);
        values.put(TableContanst.StudentColumns.BLOODGROUP,bloodgroup);
        values.put(TableContanst.StudentColumns.ADDRESS,address);
        values.put(TableContanst.StudentColumns.PHONE,phone);
        values.put(TableContanst.StudentColumns.EMAIL,email);
        this.db.insert(TableContanst.Student_TABLE,null,values);
    }
    public void updateStudent(String stu_id,String name,String batch,int age,String DOB,String bloodgroup,String address,String phone,String email){
        ContentValues values = new ContentValues();
        this.db = this.getWritableDatabase();
        values.put(TableContanst.StudentColumns.STUID,stu_id);
        values.put(TableContanst.StudentColumns.NAME,name);
        values.put(TableContanst.StudentColumns.BATCH,batch);
        values.put(TableContanst.StudentColumns.AGE,age );
        values.put(TableContanst.StudentColumns.DOB,DOB);
        values.put(TableContanst.StudentColumns.BLOODGROUP,bloodgroup);
        values.put(TableContanst.StudentColumns.ADDRESS,address);
        values.put(TableContanst.StudentColumns.PHONE,phone);
        values.put(TableContanst.StudentColumns.EMAIL,email);
        this.db.insert(TableContanst.Student_TABLE,null,values);
    }
}
