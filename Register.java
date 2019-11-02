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
		account = (EditText) findViewById(R.id.account);// �˺�
		email = (EditText) findViewById(R.id.email);// �����ʼ�
		pwd = (EditText) findViewById(R.id.password);// ����
		pwd2 = (EditText) findViewById(R.id.password2);// �ٴ�ȷ������
		
		confirm = (Button) findViewById(R.id.confirm);// �鿴�����ť
		reset = (Button) findViewById(R.id.reset);// �鿴�����ť
		
		confirm.setOnClickListener(new OnClickListener() {// ȷ���¼���ť����
			public void onClick(View v) {
				Connection connection = null;
		        java.sql.Statement stat = null;
		        ResultSet rs = null;
		        try {
		            Class.forName("com.mysql.jdbc.Driver");//��������
		            String url = "jdbc:mysql://localhost:3306/game";
		            String username="root";
		            String password="root";
		            connection = DriverManager.getConnection(url,username,password);
		            stat = connection.createStatement();
		            
		            String sql="select uaccount from myInfo where uaccount='"+ account +"'";
	                rs = stat.executeQuery(sql);
	                if(rs.next()) {
	                	Toast.makeText(Register.this, "�˺��Ѵ��ڣ�", Toast.LENGTH_LONG).show();
	                }
	                else{
	                		sql = "insert into myInfo(uaccount,password,email) values(account,pwd,email)";
	                		rs = stat.executeQuery(sql);
	                		Toast.makeText(Register.this, "ע��ɹ���", Toast.LENGTH_LONG).show();
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
		});// ��ť�������
		
		reset.setOnClickListener(new OnClickListener() {// �����¼���ť����
			public void onClick(View v) {
				account.setText("");
				pwd.setText("");
				pwd2.setText("");
				email.setText("");
				//finish();
			}
		});// ��ť�������
		
	}
}
