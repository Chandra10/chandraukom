package com.chandra.applink;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Tab extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab);
	
		TabHost tab = (TabHost) findViewById(android.R.id.tabhost);
		
		TabSpec PHP = tab.newTabSpec("PHP");
		TabSpec Dekstop = tab.newTabSpec("Java Script");
		TabSpec Botstrap = tab.newTabSpec("Botstrap");
		
		PHP.setIndicator("PHP");
        PHP.setContent(new Intent(this,ViewAllData.class));
        
        Dekstop.setIndicator("Java Script");
        Dekstop.setContent(new Intent(this,Jscript.class));
        
        Botstrap.setIndicator("Boostrap");
        Botstrap.setContent(new Intent(this,Bstrap.class));
        
        tab.addTab(PHP);
        tab.addTab(Dekstop);
        tab.addTab(Botstrap);

	
	}
}
