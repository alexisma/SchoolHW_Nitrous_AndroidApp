package com.app.gamestore;


import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class GameList extends Activity {
	
	TextView lista; 
	ArrayAdapter<String> adapter;		
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_list);
		lista = (TextView) findViewById(R.id.listaTextView);			
		AsyncHttpClient client = new AsyncHttpClient();
		client.get("http://nitro-riverrun-nodejs-15-107054.usw1-2.nitrousbox.com:9000/games", new AsyncHttpResponseHandler() {
		    @Override
		    public void onSuccess(String response) {
		    	Gson g = new Gson();
		    	Game [] games = g.fromJson(response, Game[].class);	
		    	lista.setText("");
		        for(Game gm : games){
		        	lista.append(gm.id +"- " + gm.name + "\n " + gm.genre + "  Precio: $" + gm.price +"\n\n");		        
		        }//end for		       
		    }		    
		});	
				
		
}    	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game_list, menu);
		return true;
	}

	public void load(View v){	}
		
    }