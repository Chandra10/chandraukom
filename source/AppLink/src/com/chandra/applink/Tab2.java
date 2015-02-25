package com.chandra.applink;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Tab2 extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab2);
		
		TabHost tab = (TabHost) findViewById(android.R.id.tabhost);
		
		TabSpec Android = tab.newTabSpec("Android");
		TabSpec BlackBerry = tab.newTabSpec("BlackBerry");
		
		Android.setIndicator("Android");
		Android.setContent(new Intent(this,Android.class));
        
		BlackBerry.setIndicator("BlackBerry");
		BlackBerry.setContent(new Intent(this,BB.class));
        
        
        tab.addTab(Android);
        tab.addTab(BlackBerry);
	}
}
