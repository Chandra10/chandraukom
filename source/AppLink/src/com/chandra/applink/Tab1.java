package com.chandra.applink;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Tab1 extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab1);

		TabHost tab = (TabHost) findViewById(android.R.id.tabhost);
		
		TabSpec VB = tab.newTabSpec("Visual Basic");
		TabSpec Jadek = tab.newTabSpec("Java Dekstop");
		TabSpec C = tab.newTabSpec("C + +");
		
		VB.setIndicator("Visual Basic");
        VB.setContent(new Intent(this,VB.class));
        
        Jadek.setIndicator("Java Dekstop");
        Jadek.setContent(new Intent(this,Jadek.class));
        
        C.setIndicator("C + +");
        C.setContent(new Intent(this,Cpp.class));
        
        tab.addTab(VB);
        tab.addTab(Jadek);
        tab.addTab(C);

	}

}
