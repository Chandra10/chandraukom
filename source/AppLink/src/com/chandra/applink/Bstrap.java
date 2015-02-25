package com.chandra.applink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Bstrap extends Activity {

	TextView a, b, c, d, e;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bstrap);
		
		a = (TextView) findViewById(R.id.text1);
		a.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent wb1 = new Intent(getApplication(), WB1.class);
				startActivity(wb1);
			}
		});
		
		b = (TextView) findViewById(R.id.text2);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent wb2 = new Intent(getApplication(), WB2.class);
				startActivity(wb2);
			}
		});
		
		c = (TextView) findViewById(R.id.text3);
		c.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent wb3 = new Intent(getApplication(), WB3.class);
				startActivity(wb3);
			}
		});
		
		d = (TextView) findViewById(R.id.text4);
		d.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent wb4 = new Intent(getApplication(), WB4.class);
				startActivity(wb4);
			}
		});
		
		e = (TextView) findViewById(R.id.text5);
		e.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent wb5 = new Intent(getApplication(), WB5.class);
				startActivity(wb5);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bstrap, menu);
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
