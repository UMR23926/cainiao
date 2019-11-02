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
		simple = (Button) findViewById(R.id.simple);// 简单
		medium = (Button) findViewById(R.id.medium);// 中等
		hard = (Button) findViewById(R.id.hard);// 困难
		
		/*
		 * 简单难度事件按钮监听
		 */
		simple.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
		        
	            Intent intent = new Intent(Grade.this, Game.class);// 跳转至游戏界面;
			    startActivity(intent);
			    finish();
	        }	
		});// 按钮点击监听	
		
		/*
		 * 中等难度事件按钮监听
		 */
		medium.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
		        
	            Intent intent = new Intent(Grade.this, Game.class);// 跳转至中等界面;
			    startActivity(intent);
			    finish();
	        }	
		});// 按钮点击监听	
		
		
		/*
		 * 困难难度事件按钮监听
		 */
		hard.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
		        
	            Intent intent = new Intent(Grade.this, Game.class);// 跳转至困难界面;
			    startActivity(intent);
			    finish();
	        }	
		});// 按钮点击监听	
	}
}
