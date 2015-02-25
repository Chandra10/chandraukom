package com.chandra.applink;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class WJS1 extends Activity {

	private WebView webview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wjs1);
		
		webview = (WebView) findViewById(R.id.web_view);
		openBrowser();
	}

	private void openBrowser() {
		// TODO Auto-generated method stub
		String url = "http://www.carikode.com/tutorial-cara-membuat-background-web-bergerak/";
		
		WebChromeClient wcc = new WebChromeClient();
		
		webview.setWebChromeClient(wcc);
		
		webview.getSettings().setJavaScriptEnabled(true);
		
		webview.getSettings().setBuiltInZoomControls(true);
		
		//webview.enablePlatformNotifications();
		
		webview.loadUrl(url);
	}

}
