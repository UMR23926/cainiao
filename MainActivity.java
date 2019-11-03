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
    
        //数据库创建及调用
        helper=new DBHelper(this);
        helper.getWritableDatabase();
        
      //利用布局资源文件设置用户界面
        userid=(EditText)findViewById(R.id.userid);
        password=(EditText)findViewById(R.id.password);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
      //给登录按钮注册监听器
       button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取用户输入的数据
                String UserId =userid.getText().toString();
                String UserPassword =password.getText().toString();

                //判断用户名和密码是否正确
                //UserService User=new UserService();
                //User.login(UserId,UserPassword)
               if(UserId.equals("")||UserPassword.equals("")){
            	   Toast.makeText(getApplicationContext(), "请输入账号密 码！",Toast.LENGTH_SHORT).show();
               }
               else{
            	    login(UserId,UserPassword);
            }
          }
        });
        
       
       
       
       
       
      //给注册按钮注册监听器
       button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent intent= new Intent(MainActivity.this,register.class); //声明一个Intent对象，构造函数参数为第一个页面与第二个页面
                startActivity(intent);//跳转页面
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
		    	   Toast.makeText(getApplicationContext(), "登录失败!",  Toast.LENGTH_SHORT).show();
		        }
		       
			cursor.close();
			sdb.close();
		    }catch(SQLiteException e){
			 Toast.makeText(getApplicationContext(), "用户不存在，请注册！",Toast.LENGTH_SHORT).show();
			}
	}
	

    }





