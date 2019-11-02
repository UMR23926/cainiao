package com.example.ruangong_login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainInterface extends Activity{
	private Button matched, friend_battle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modeselect);
		matched = (Button) findViewById(R.id.matched);// �鿴�����ť
		friend_battle = (Button) findViewById(R.id.friend_battle);// �鿴�����ť
		matched.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
		        
	            Intent intent = new Intent(MainInterface.this, Grade.class);// ��ת���Ѷȵȼ�ѡ�����;
			    startActivity(intent);
			    finish();
	        }	
		});// ��ť�������	
		
		
		matched.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
		        
	            Intent intent = new Intent(MainInterface.this, Game.class);// ��ת�����Ѷ�ս��Ϸ����;
			    startActivity(intent);
			    finish();
	        }	
		});// ��ť�������	
	}

}
