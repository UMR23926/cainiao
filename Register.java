package com.example.ruangong_login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity{
	private Button confirm,reset;
	private EditText account,pwd,pwd2,email;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		account = (EditText) findViewById(R.id.account);// 账号
		email = (EditText) findViewById(R.id.email);// 电子邮件
		pwd = (EditText) findViewById(R.id.password);// 密码
		pwd2 = (EditText) findViewById(R.id.password2);// 再次确认密码
		
		confirm = (Button) findViewById(R.id.confirm);// 查看结果按钮
		reset = (Button) findViewById(R.id.reset);// 查看结果按钮
		
		confirm.setOnClickListener(new OnClickListener() {// 确认事件按钮监听
			public void onClick(View v) {
				Connection connection = null;
		        java.sql.Statement stat = null;
		        ResultSet rs = null;
		        try {
		            Class.forName("com.mysql.jdbc.Driver");//连接驱动
		            String url = "jdbc:mysql://localhost:3306/game";
		            String username="root";
		            String password="root";
		            connection = DriverManager.getConnection(url,username,password);
		            stat = connection.createStatement();
		            
		            String sql="select uaccount from myInfo where uaccount='"+ account +"'";
	                rs = stat.executeQuery(sql);
	                if(rs.next()) {
	                	Toast.makeText(Register.this, "账号已存在！", Toast.LENGTH_LONG).show();
	                }
	                else{
	                		sql = "insert into myInfo(uaccount,password,email) values(account,pwd,email)";
	                		rs = stat.executeQuery(sql);
	                		Toast.makeText(Register.this, "注册成功！", Toast.LENGTH_LONG).show();
	                		Intent intent = new Intent(Register.this, MainInterface.class);
		    				startActivity(intent);
		    				finish();
	                	
	                }
		            
			  } catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } catch (java.sql.SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
		            try {
		                if (rs != null) {
		                    rs.close();
		                    rs = null;
		                }

		                if (stat != null) {
		                    stat.close();
		                    rs = null;
		                }

		                if (connection != null) {
		                    connection.close();
		                    connection = null;
		                }
		            } catch (SQLException e) {
		                e.printStackTrace();
		            } catch (java.sql.SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
			}
		});// 按钮点击监听
		
		reset.setOnClickListener(new OnClickListener() {// 重置事件按钮监听
			public void onClick(View v) {
				account.setText("");
				pwd.setText("");
				pwd2.setText("");
				email.setText("");
				//finish();
			}
		});// 按钮点击监听
		
	}
}
