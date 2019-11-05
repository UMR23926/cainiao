package com.example.doudizhu;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;

public class welcomeActivity extends Activity implements
		OnCheckedChangeListener, OnClickListener {
	private ToggleButton musicButton;
	private Button piperButton;
	private Button friendButton;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		musicButton = (ToggleButton) findViewById(R.id.btn_music);
		piperButton = (Button) findViewById(R.id.btn_piper);
		friendButton = (Button) findViewById(R.id.btn_friend);

		musicButton.setOnCheckedChangeListener(this);
		piperButton.setOnClickListener(this);
		friendButton.setOnClickListener(this);
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean ischecked) {
		// TODO Auto-generated method stub
		int op = -1;
		Intent intent = new Intent("playingMusicServices");

		if (ischecked) {
			op = 1;
		} else {
			op = 2;
		}
		Bundle bundle = new Bundle();
		bundle.putInt("op", op);
		intent.putExtras(bundle);
		startService(intent);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.btn_friend) {

		}
		if (v.getId() == R.id.btn_piper) {

		}

	}
}
