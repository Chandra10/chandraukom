package com.chandra.applink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Jscript extends Activity {

	TextView a, b, c, d, e, f;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jscript);
		
		a = (TextView) findViewById(R.id.text1);
		a.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent js1 = new Intent(getApplicationContext(), WJS1.class);
				startActivity(js1);
			}
		});
		
		b = (TextView) findViewById(R.id.text2);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent js2 = new Intent(getApplicationContext(), WJS2.class);
				startActivity(js2);
			}
		});
		
		c = (TextView) findViewById(R.id.text3);
		c.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent js3 = new Intent(getApplicationContext(), WJS3.class);
				startActivity(js3);
			}
		});
		
		d = (TextView) findViewById(R.id.text4);
		d.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent js4 = new Intent(getApplicationContext(), WJS4.class);
				startActivity(js4);
			}
		});
		
		e = (TextView) findViewById(R.id.text5);
		e.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent js5 = new Intent(getApplicationContext(), WJS5.class);
				startActivity(js5);
			}
		});
		
		f = (TextView) findViewById(R.id.text6);
		f.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent js6 = new Intent(getApplicationContext(), WJS6.class);
				startActivity(js6);
			}
		});
		
		
		
	}

	
}
