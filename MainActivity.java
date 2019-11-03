package com.example.project;

import com.example.project.MainActivity;

import android.widget.Button;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends ActionBarActivity {
	
	private EditText userid;
	private EditText password;
	private Button button1;
	private Button button2;
    
	SQLiteOpenHelper helper;
	
	
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        //���ݿⴴ��������
        helper=new DBHelper(this);
        helper.getWritableDatabase();
        
      //���ò�����Դ�ļ������û�����
        userid=(EditText)findViewById(R.id.userid);
        password=(EditText)findViewById(R.id.password);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
      //����¼��ťע�������
       button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //��ȡ�û����������
                String UserId =userid.getText().toString();
                String UserPassword =password.getText().toString();

                //�ж��û����������Ƿ���ȷ
                //UserService User=new UserService();
                //User.login(UserId,UserPassword)
               if(UserId.equals("")||UserPassword.equals("")){
            	   Toast.makeText(getApplicationContext(), "�������˺��� �룡",Toast.LENGTH_SHORT).show();
               }
               else{
            	    login(UserId,UserPassword);
            }
          }
        });
        
       
       
       
       
       
      //��ע�ᰴťע�������
       button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent intent= new Intent(MainActivity.this,register.class); //����һ��Intent���󣬹��캯������Ϊ��һ��ҳ����ڶ���ҳ��
                startActivity(intent);//��תҳ��
              	}});


        
        }
    
    
    
    
    
    protected void login(String UserId,String UserPassword){ 
		SQLiteDatabase sdb=helper.getReadableDatabase(); 
		try{
		   String sql="select *from user where userId=? and userPassword=?";
		   Cursor cursor=sdb.rawQuery(sql,new String[]{UserId,UserPassword});
		       if(cursor.getCount()>0){
		    	   Intent intent = new Intent(MainActivity.this,register.class);
		    	  startActivity(intent);
		          }
		       else{
		    	   Toast.makeText(getApplicationContext(), "��¼ʧ��!",  Toast.LENGTH_SHORT).show();
		        }
		       
			cursor.close();
			sdb.close();
		    }catch(SQLiteException e){
			 Toast.makeText(getApplicationContext(), "�û������ڣ���ע�ᣡ",Toast.LENGTH_SHORT).show();
			}
	}
	

    }





