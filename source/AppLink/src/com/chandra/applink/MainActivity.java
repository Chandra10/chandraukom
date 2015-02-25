package com.chandra.applink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

	private static int splash = 3000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		new android.os.Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent show = new Intent(MainActivity.this,Kategori.class);
                startActivity(show);
                finish();
       
            }
        },splash);

	}
	
	
}
