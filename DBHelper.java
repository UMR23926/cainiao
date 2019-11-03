package com.example.project;//创建数据库
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
public class DBHelper extends SQLiteOpenHelper{
	private static final String DATABASENAME = "game.db"; //数据库名称 
    private static final int VERSION = 1;//数据库版本,大于0 
    //创建数据库
    public DBHelper(Context context){
    	super(context,DATABASENAME,null,VERSION);
    }
        
	
    @Override
    public void onCreate(SQLiteDatabase db){
    	String sql="CREATE TABLE user(userId char(20) primary key,userName varchar(20),userPassword varchar(20),usrState int);";
    	db.execSQL(sql);//创建用户表
    	//db.execSQL("CREATE TABLE ");//创建表
   }

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
    
    
}

