package com.chandra.applink;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Addlink extends Activity {

	private ProgressDialog pDialog;
	JSONParser jParser = new JSONParser();
	EditText editJudul, editLink, editNama, editEmail, editTanggal;
	Button btnaddlink;
	TextView textKategori, textSub;
	private static String url_addlink = "http://192.168.43.162/LinkApp/link.php";
	private static final String TAG_SUCCESS = "success";
	
	Spinner sp1,sp2;
	ArrayAdapter<String> adp1,adp2;
	List<String> l1,l2;
	int pos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addlink);
		
		l1=new ArrayList<String>();
        
        l1.add("Program Web");
        l1.add("Program Dekstop");
        l1.add("Mobile");
		
        sp1 = (Spinner) findViewById(R.id.spinKategori);
        sp2 = (Spinner) findViewById(R.id.spinSub);
        
        textKategori = (TextView) findViewById(R.id.nampilinkategori);
        textSub = (TextView) findViewById(R.id.nampilinsub);
		
 		editJudul = (EditText) findViewById(R.id.editJudul);
 		editLink = (EditText) findViewById(R.id.editLink);
 		editNama = (EditText) findViewById(R.id.editNama);
 		editEmail = (EditText) findViewById(R.id.editEmail);
 		editTanggal = (EditText) findViewById(R.id.editTgl);
        
        adp1=new ArrayAdapter<String> (this,android.R.layout.simple_dropdown_item_1line,l1);
        adp1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp1.setAdapter(adp1);
        
        sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
			
			//	String ckategori = MyArrList.get(position).get("kategori").toString();
			//	textKategori.setText(ckategori);
				
				pos = arg2;
				
				add();
				
			}

			private void add() {
				// TODO Auto-generated method stub
				switch(pos)
		        {
		        case 0:
		        	l2= new ArrayList<String>();		        	
		        	l2.add("PHP");
		        	l2.add("Java Script");
		        	l2.add("Bootstrap");
		        	
		        	adp2=new ArrayAdapter<String>(Addlink.this,
		        			android.R.layout.simple_dropdown_item_1line,l2);
		        	sp2.setAdapter(adp2);
		        	
		        	select();
		        	
		        	break;
		        	
		        case 1:
		        	l2= new ArrayList<String>();		        	
		        	l2.add("Visual Basic");
		        	l2.add("Java Dekstop");
		        	l2.add("C + +");
		        	
		        	adp2=new ArrayAdapter<String>(Addlink.this,
		        			android.R.layout.simple_dropdown_item_1line,l2);
		        	sp2.setAdapter(adp2);
		        	
		        	select();
		        	
		        	break;
		        	
		        case 2:
		        	l2 = new ArrayList<String>();
		        	l2.add("Android");
		        	l2.add("BlackBarry");
		        	
		        	adp2=new ArrayAdapter<String>(Addlink.this,
		        			android.R.layout.simple_dropdown_item_1line,l2);
		        	sp2.setAdapter(adp2);
		        	
		        	select();
		        	
		        	break;
		        }
		        
				
			}

			private void select() {
				// TODO Auto-generated method stub
				
				sp2.setOnItemSelectedListener(new OnItemSelectedListener() {
					 
					public void onItemSelected(AdapterView<?> parent, View arg1,
							int position, long arg3) {
						// TODO Auto-generated method stub

					String a = parent.getItemAtPosition(position).toString();
					textSub.setText(a);
						
					//        Toast.makeText(getBaseContext(), l2.get(arg2),
					//		Toast.LENGTH_SHORT).show();
					}
	 
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
							
					}
				});
			}
	 
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
					
			}
		});        

	
      
        btnaddlink = (Button) findViewById(R.id.btnAddlink);
        btnaddlink.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					new CreateLink().execute();
					Intent pindah = new Intent(getApplicationContext(), Kategori.class);
					startActivity(pindah);
					
					Toast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_SHORT).show();
				}
			});
}

class CreateLink extends AsyncTask<String, String, String>
{

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		pDialog = new ProgressDialog(Addlink.this);
		pDialog.setMessage("Mohon Tunggu Sebentar..");
		pDialog.setIndeterminate(false);
		pDialog.setCancelable(true);
		pDialog.show();
	}
	
	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		
		String sub = textSub.getText().toString();
		String judul = editJudul.getText().toString();
		String link = editLink.getText().toString();
		String nama = editNama.getText().toString();
		String email = editEmail.getText().toString();
		String tgl_input = editTanggal.getText().toString();
		
		List<NameValuePair> param = new ArrayList<NameValuePair>();
		
		param.add(new BasicNameValuePair("sub", sub));
		param.add(new BasicNameValuePair("judul", judul));
		param.add(new BasicNameValuePair("link", link));
		param.add(new BasicNameValuePair("nama", nama));
		param.add(new BasicNameValuePair("email", email));
		param.add(new BasicNameValuePair("tgl_input", tgl_input));
		
		JSONObject json = jParser.makeHTTPRequest(url_addlink, "POST", param);
		Log.d("Create Response", json.toString());
		
		try{
			int success = json.getInt(TAG_SUCCESS);
			if(success == 1){
				Intent i = new Intent(getApplication(), Addlink.class);
				startActivity(i);
				pDialog.dismiss();
				
				finish();
			} else {
				
			}
		} catch (JSONException e){
			e.printStackTrace();
		}
		return null;
	}
	
}
}
