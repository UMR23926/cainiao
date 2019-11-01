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
		account = (EditText) findViewById(R.id.account);// �˺�
		email = (EditText) findViewById(R.id.email);// �����ʼ�
		pwd = (EditText) findViewById(R.id.password);// ����
		pwd2 = (EditText) findViewById(R.id.password2);// �ٴ�ȷ������
		
		confirm = (Button) findViewById(R.id.confirm);// �鿴�����ť
		reset = (Button) findViewById(R.id.reset);// �鿴�����ť
		
		confirm.setOnClickListener(new OnClickListener() {// ȷ���¼���ť����
			public void onClick(View v) {
				Intent intent = new Intent(Register.this, MainActivity.class);// ������ת;
				startActivity(intent);
				//finish();
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
