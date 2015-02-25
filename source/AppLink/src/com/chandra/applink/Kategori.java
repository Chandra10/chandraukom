package com.chandra.applink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Kategori extends Activity {
	
	Button tambah, semua, Dekstop, mobile, data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kategori);
		
		mobile = (Button) findViewById(R.id.mobile);
		mobile.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mobile = new Intent(getApplicationContext(), Tab2.class);
				startActivity(mobile);
			}
		});
		
		semua = (Button) findViewById(R.id.btnSemua);
		semua.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent semua = new Intent(getApplicationContext(), Tab.class);
				startActivity(semua);
			}
		});
		
		Dekstop = (Button) findViewById(R.id.Dekstop);
		Dekstop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent dek = new Intent(getApplicationContext(), Tab1.class);
				startActivity(dek);
			}
		});
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.kategori, menu);
		
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		switch(item.getItemId())
		{
			case R.id.plus:
				startActivity(new Intent(getApplicationContext(), Addlink.class));
		}
		
		
		return super.onOptionsItemSelected(item);
	}
}
