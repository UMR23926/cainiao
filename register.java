package com.example.project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends MainActivity{
	private EditText userid;
	private EditText username;
	private EditText password;
	private Button button1;//注册
	private Button button2;//取消
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        userid=(EditText)findViewById(R.id.userid);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
      //给登录按钮注册监听器
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取用户输入的数据
                String UserId =userid.getText().toString();
                String UserName =username.getText().toString();
                String UserPassword =password.getText().toString();

                //判断用户名和密码是否正确
                UserService User=new UserService();
                UserData data=new UserData(UserId, UserName, UserPassword, 0);
                if(UserId.equals("")||UserName.equals("")||UserPassword.equals("")){
             	   Toast.makeText(getApplicationContext(), "输入不能为空！",Toast.LENGTH_SHORT).show();
                }
                else{
             	    register(data);
             }
                
                /*if(User.register(data)){
                	Toast.makeText(register.this,"注册成功！",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(register.this,"注册失败！",Toast.LENGTH_SHORT).show();
                }*/

            }
        });
        
       button2.setOnClickListener(new OnClickListener() { 
 		   public void onClick(View v) { 
 		        finish();

 		      } 

 		});
        
}
	
	
	protected void register(UserData user){  
		try{
        SQLiteDatabase sdb=helper.getReadableDatabase();  
        String sql="insert into user(userId,userName,userPassword,0)values(?,?,?,?)";  
        Object obj[]={user.getUserId(),user.getUserName(),user.getUserPassword(),user.getUserState()};  
        sdb.execSQL(sql, obj);  
        Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
        }
        catch(SQLiteException e)
        {Toast.makeText(getApplicationContext(), "注册失败", Toast.LENGTH_SHORT).show();}
    }

 }
		

