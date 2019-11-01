package com.example.ruangong_login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

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
				Intent intent = new Intent(Register.this, MainActivity.class);// 界面跳转;
				startActivity(intent);
				//finish();
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
