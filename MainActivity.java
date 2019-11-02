package com.example.ruangong_login;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private Button login, register;
	private EditText account,pwd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		login = (Button) findViewById(R.id.login);// �鿴�����ť
		register = (Button) findViewById(R.id.register);// �鿴�����ť
		account = (EditText) findViewById(R.id.account);// �˺�
		pwd = (EditText) findViewById(R.id.password);// ����
		
		
		
		/*
		 * �����Ƿ����ӳɹ�
		 */
		Connection connection = null;
        java.sql.Statement stat = null;
        ResultSet rs = null;
        try {
        	Class.forName("com.mysql.jdbc.Driver");//��������
            String url = "jdbc:mysql://192.168.43.168:3306/game";
            String username="root";
            String password="root";
            connection = DriverManager.getConnection(url,username,password);
            stat = connection.createStatement();
            
            String sql="select uaccount from myInfo";
            rs = stat.executeQuery(sql);
            while(rs.next()) {
            			//System.out.println(rs.next());
                		//ʹ��Toast.makeText()����������Toast��Ϣ
                		Toast.makeText(MainActivity.this,"nihao", Toast.LENGTH_LONG).show();
            	
            	}
		} catch (Exception e) {
			//ʹ��Toast.makeText()����������Toast��Ϣ
    		Toast.makeText(MainActivity.this,"����ʧ��", Toast.LENGTH_LONG).show();
		}
            
		
		
		
		/*
		 * ��¼��ť����
		 */
		login.setOnClickListener(new OnClickListener() {
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
		            
		            String sql="select pwd from myInfo where uaccount='"+account +"'";
	                rs = stat.executeQuery(sql);
	                if(rs.next()) {
	                	if(rs.getString(1).equals(pwd)) {
	                		Toast.makeText(MainActivity.this, "������ת...", Toast.LENGTH_LONG).show();
	                		Intent intent = new Intent(MainActivity.this, MainInterface.class);// ��½�ɹ���������ת;
		    				startActivity(intent);
		    				finish();
	                    	}
	                    	else {
	                    		//ʹ��Toast.makeText()����������Toast��Ϣ
	                    		Toast.makeText(MainActivity.this, "�˺Ż��������", Toast.LENGTH_LONG).show();
	                    		pwd.setText("");
	                        }
	                	
	                	}
	                else {
	    				Toast.makeText(MainActivity.this, "�˺Ų����ڣ�", Toast.LENGTH_LONG).show();
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
		
		
		
		
		/*
		 * ע�ᰴť����
		 */
		register.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
		        
	            Intent intent = new Intent(MainActivity.this, Register.class);// ��ת��ע�����;
			    startActivity(intent);
			    finish();
	        }	
		});// ��ť�������		
	}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
