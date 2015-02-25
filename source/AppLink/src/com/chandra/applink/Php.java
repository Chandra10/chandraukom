package com.chandra.applink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Php extends Activity {

	TextView crud, login, kalender, function, fungsi;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_php);
		
		crud = (TextView) findViewById(R.id.crud);
		crud.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent crud = new Intent(getApplication(), WCPhp.class);
				startActivity(crud);
			}
		});
		
		login = (TextView) findViewById(R.id.login);
		login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent login = new Intent(getApplicationContext(), WLPhp.class);
				startActivity(login);
			}
		});
		
		kalender = (TextView) findViewById(R.id.kalender);
		kalender.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent kalender = new Intent(getApplicationContext(), WKPhp.class);
				startActivity(kalender);
			}
		});
		
		function = (TextView) findViewById(R.id.function);
		function.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent func = new Intent(getApplicationContext(), WFPhp.class);
				startActivity(func);
			}
		});
		
		fungsi = (TextView) findViewById(R.id.fungsi);
		fungsi.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent fungsi = new Intent(getApplicationContext(), WSPhp.class);
				startActivity(fungsi); 
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.php, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
