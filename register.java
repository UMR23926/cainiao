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
	private Button button1;//ע��
	private Button button2;//ȡ��
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        userid=(EditText)findViewById(R.id.userid);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
      //����¼��ťע�������
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //��ȡ�û����������
                String UserId =userid.getText().toString();
                String UserName =username.getText().toString();
                String UserPassword =password.getText().toString();

                //�ж��û����������Ƿ���ȷ
                UserService User=new UserService();
                UserData data=new UserData(UserId, UserName, UserPassword, 0);
                if(UserId.equals("")||UserName.equals("")||UserPassword.equals("")){
             	   Toast.makeText(getApplicationContext(), "���벻��Ϊ�գ�",Toast.LENGTH_SHORT).show();
                }
                else{
             	    register(data);
             }
                
                /*if(User.register(data)){
                	Toast.makeText(register.this,"ע��ɹ���",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(register.this,"ע��ʧ�ܣ�",Toast.LENGTH_SHORT).show();
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
        Toast.makeText(getApplicationContext(), "ע��ɹ�", Toast.LENGTH_SHORT).show();
        }
        catch(SQLiteException e)
        {Toast.makeText(getApplicationContext(), "ע��ʧ��", Toast.LENGTH_SHORT).show();}
    }

 }
		

