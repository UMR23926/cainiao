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
		matched = (Button) findViewById(R.id.matched);// 查看结果按钮
		friend_battle = (Button) findViewById(R.id.friend_battle);// 查看结果按钮
		matched.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
		        
	            Intent intent = new Intent(MainInterface.this, Grade.class);// 跳转至难度等级选择界面;
			    startActivity(intent);
			    finish();
	        }	
		});// 按钮点击监听	
		
		
		matched.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
		        
	            Intent intent = new Intent(MainInterface.this, Game.class);// 跳转至好友对战游戏界面;
			    startActivity(intent);
			    finish();
	        }	
		});// 按钮点击监听	
	}

}
