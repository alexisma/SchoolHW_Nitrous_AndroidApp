package com.app.gamestore;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.*;

public class MainActivity extends Activity {
	
	public static final String INTENTO = "com.app.gamestore.GAMELIST";

	TextView  txt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
	}

	public void goList(View v){
    	Intent i = new Intent(this,GameList.class);
    	startActivity(i);
    }
	
	public void goAdd(View v){
    	Intent i = new Intent(this,AddGame.class);
    	startActivity(i);
    }
	
	public void goDel(View v){
    	Intent i = new Intent(this,Delete.class);
    	startActivity(i);
    }
	
	public void goUpdate(View v){
    	Intent i = new Intent(this,Update.class);
    	startActivity(i);
    }
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
