package com.example.ruangong_login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Game extends Activity{
	private Button out_card, prompt, off_card;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grade);
		out_card = (Button) findViewById(R.id.simple);// ����
		prompt = (Button) findViewById(R.id.medium);// ��ʾ
		off_card = (Button) findViewById(R.id.hard);// ����
		
		/*
		 * �����¼���ť����
		 */
		out_card.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(Game.this,"���� ���� ��ť", Toast.LENGTH_LONG).show();
				
	        }	
		});// ��ť�������	
		
		/*
		 * ��ʾ�¼���ť����
		 */
		prompt.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(Game.this,"���� ��ʾ ��ť", Toast.LENGTH_LONG).show();
	        }	
		});// ��ť�������	
		
		
		/*
		 * �����¼���ť����
		 */
		off_card.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(Game.this,"���� ���� ��ť", Toast.LENGTH_LONG).show();
	        }	
		});// ��ť�������	
	}
}
