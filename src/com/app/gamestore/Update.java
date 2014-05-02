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

public class Update extends Activity {

	TextView txt;
	String name, genre,price,id;	
	EditText nameET, genreET, priceET,idEt;	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update);
		txt = (TextView) findViewById(R.id.updatedGameTF);	
		nameET =  (EditText) findViewById(R.id.nameTF);
		genreET = (EditText) findViewById(R.id.genreTF);
		priceET = (EditText) findViewById(R.id.priceTF);
		idEt = (EditText) findViewById(R.id.idTf);
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.update, menu);
		return true;
	}

	public void search(View v){
		id = idEt.getText().toString();				
		//http://nitro-riverrun-nodejs-15-107054.usw1-2.nitrousbox.com:9000/search?id=14	
		AsyncHttpClient client = new AsyncHttpClient();
		client.get("http://nitro-riverrun-nodejs-15-107054.usw1-2.nitrousbox.com:9000/search?id="+id, new AsyncHttpResponseHandler(){
		    
			@Override
		    public void onSuccess(String response) {
		    	Gson g = new Gson();
		    	Game game = g.fromJson(response,Game.class);
		    		nameET.setText(game.name);
		    		genreET.setText(game.genre);
		    		priceET.setText(""+game.price);
		    	}
		});	
}
	
	
	
	public void update(View v){
		id = idEt.getText().toString();	
		name  = nameET.getText().toString();
		genre = genreET.getText().toString();
		price = priceET.getText().toString();
		
		System.out.println(id);
		System.out.println(name);
		System.out.println(genre);
		System.out.println(price);		
		
		AsyncHttpClient client = new AsyncHttpClient();
		client.get("http://nitro-riverrun-nodejs-15-107054.usw1-2.nitrousbox.com:9000/update?id="+id+"&n="+name+"&g="+genre+"&p="+price, new AsyncHttpResponseHandler(){
		    @Override
		    public void onSuccess(String response) {		    	
		    	Gson g = new Gson();
		    	Game game = g.fromJson(response,Game.class);		    			    	
		        txt.setText("Agregado \n\n");		
		        System.out.println("Entra! ");
		        txt.append("Name: " + game.name + "\nGenre: " + game.genre + "  Price: $" + game.price + "\n\n");		       		        
		    }
		});	
}
}

