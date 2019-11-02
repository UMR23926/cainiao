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
		out_card = (Button) findViewById(R.id.simple);// 出牌
		prompt = (Button) findViewById(R.id.medium);// 提示
		off_card = (Button) findViewById(R.id.hard);// 不出
		
		/*
		 * 出牌事件按钮监听
		 */
		out_card.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(Game.this,"我是 出牌 按钮", Toast.LENGTH_LONG).show();
				
	        }	
		});// 按钮点击监听	
		
		/*
		 * 提示事件按钮监听
		 */
		prompt.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(Game.this,"我是 提示 按钮", Toast.LENGTH_LONG).show();
	        }	
		});// 按钮点击监听	
		
		
		/*
		 * 不出事件按钮监听
		 */
		off_card.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(Game.this,"我是 不出 按钮", Toast.LENGTH_LONG).show();
	        }	
		});// 按钮点击监听	
	}
}
