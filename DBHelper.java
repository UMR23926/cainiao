package com.example.project;//�������ݿ�
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
public class DBHelper extends SQLiteOpenHelper{
	private static final String DATABASENAME = "game.db"; //���ݿ����� 
    private static final int VERSION = 1;//���ݿ�汾,����0 
    //�������ݿ�
    public DBHelper(Context context){
    	super(context,DATABASENAME,null,VERSION);
    }
        
	
    @Override
    public void onCreate(SQLiteDatabase db){
    	String sql="CREATE TABLE user(userId char(20) primary key,userName varchar(20),userPassword varchar(20),usrState int);";
    	db.execSQL(sql);//�����û���
    	//db.execSQL("CREATE TABLE ");//������
   }

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
    
    
}

