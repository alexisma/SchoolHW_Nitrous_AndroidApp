package com.app.gamestore;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Delete extends Activity {

	TextView txt; 
	EditText idEt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delete);
		txt = (TextView) findViewById(R.id.res);
		idEt = (EditText) findViewById(R.id.delIdTF);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.delete, menu);
		return true;
	}

	
	public void delete(View v){
		String id;
		id = idEt.getText().toString();
		AsyncHttpClient client = new AsyncHttpClient();
		client.get("http://nitro-riverrun-nodejs-15-107054.usw1-2.nitrousbox.com:9000/delete?id="+id, new AsyncHttpResponseHandler(){
		    @Override
		    public void onSuccess(String response) {
		    	Gson g = new Gson();
		    	Game game = g.fromJson(response,Game.class);		    			    	
		        txt.setText("Eliminado \n\n");		        
		        txt.append("Name: " + game.name + "\nGenre: " + game.genre + "  Price: $" + game.price + "\n\n");
		        idEt.setText("");
		    }
		});	
}
	
}
