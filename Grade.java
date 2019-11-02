package com.example.ruangong_login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Grade extends Activity{
	private Button simple, medium, hard;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grade);
		simple = (Button) findViewById(R.id.simple);// ��
		medium = (Button) findViewById(R.id.medium);// �е�
		hard = (Button) findViewById(R.id.hard);// ����
		
		/*
		 * ���Ѷ��¼���ť����
		 */
		simple.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
		        
	            Intent intent = new Intent(Grade.this, Game.class);// ��ת����Ϸ����;
			    startActivity(intent);
			    finish();
	        }	
		});// ��ť�������	
		
		/*
		 * �е��Ѷ��¼���ť����
		 */
		medium.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
		        
	            Intent intent = new Intent(Grade.this, Game.class);// ��ת���еȽ���;
			    startActivity(intent);
			    finish();
	        }	
		});// ��ť�������	
		
		
		/*
		 * �����Ѷ��¼���ť����
		 */
		hard.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
		        
	            Intent intent = new Intent(Grade.this, Game.class);// ��ת�����ѽ���;
			    startActivity(intent);
			    finish();
	        }	
		});// ��ť�������	
	}
}
