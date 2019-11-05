package com.example.doudizhu;

import java.io.IOException;

import android.R.integer;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

public class playingMusicServices extends Service{
	
	private MediaPlayer mediaPlayer;
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void onStart(Intent intent, int startId){
		Toast.makeText(this, "ÉùÒô¿ªÆô", Toast.LENGTH_SHORT).show();
		if(mediaPlayer==null){
			mediaPlayer=MediaPlayer.create(this, R.raw.welcome);
			mediaPlayer.setLooping(true);
		}
	}
	
	public void onDestroy() {
		Toast.makeText(this, null, Toast.LENGTH_SHORT).show();
		if(mediaPlayer!=null){
			mediaPlayer.stop();
			mediaPlayer.release();
		}
    }
	
	public int onStartCommand(Intent intent,int flags,int startId) {
		if(intent!=null){
			Bundle bundle=intent.getExtras();
			if(bundle!=null){
				int op=bundle.getInt("op");
				if(op==1){
					play();
				}
				else
					stop();
			}
		}
		return super.onStartCommand(intent, flags, startId);		
	}
	
	public void play(){
		if(!mediaPlayer.isPlaying()){
			mediaPlayer.start();
		}
	}
	
	public void stop(){
		if(mediaPlayer!=null){
			mediaPlayer.stop();
			try{
				mediaPlayer.prepare();
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
	}
}
