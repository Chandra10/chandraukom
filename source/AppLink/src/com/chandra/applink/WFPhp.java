package com.chandra.applink;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class WFPhp extends Activity {

	private WebView webview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wfphp);
		
		webview = (WebView) findViewById(R.id.web_view);
		openBrowser();
	}

	private void openBrowser() {
		// TODO Auto-generated method stub
		String url = "http://www.carikode.com/tutorial-php-function-number_format-pada-php/";
		
		WebChromeClient wcc = new WebChromeClient();
		
		webview.setWebChromeClient(wcc);
		
		webview.getSettings().setJavaScriptEnabled(true);
		
		webview.getSettings().setBuiltInZoomControls(true);
		
		//webview.enablePlatformNotifications();
		
		webview.loadUrl(url);
	}

}
