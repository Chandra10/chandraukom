package com.chandra.applink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ViewAllData extends ListActivity {

	private ProgressDialog pDialog;
	JSONParser jParser = new JSONParser();

	ArrayList<HashMap<String, String>> pencarian2;

	JSONArray pencarian = null;
	private static String url_addlink = "http://192.168.43.162/LinkApp/GetPencarian.php";
	
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_Tambah = "tambah";
	private static final String TAG_JUDUL = "judul";
	private static final String TAG_LINK = "link";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_all_data);
	
		pencarian2 = new ArrayList<HashMap<String,String>>();
		new LoadSemuaDataMakanan().execute();
		ListView lv = getListView();
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				String textJudul = ((TextView) view.findViewById(R.id.textJudul)).getText().toString();
				
				Intent edit = new Intent(getApplicationContext(), WCPhp.class);
				edit.putExtra(TAG_JUDUL, textJudul);
				startActivityForResult(edit, 100);
				
			}
			
		});
		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == 100)
		{
			Intent intent = getIntent();
			finish();
			startActivity(intent);
		}
	}
	
	class LoadSemuaDataMakanan extends AsyncTask<String, String, String>
	{

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pDialog = new ProgressDialog(ViewAllData.this);
			pDialog.setMessage("Mohon tunggu, loading data...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}
		
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			List<NameValuePair> param  = new ArrayList<NameValuePair>();
			JSONObject json = jParser.makeHTTPRequest(url_addlink, "GET", param);
			Log.d("Semua Daftar Makanan", json.toString());
			try{
				int success = json.getInt(TAG_SUCCESS);
				if(success == 1)
				{
					pencarian = json.getJSONArray(TAG_Tambah);
					for(int i = 0; i < pencarian.length(); i++)
					{
						JSONObject c = pencarian.getJSONObject(i);
						String judul = c.getString(TAG_JUDUL);
						String link = c.getString(TAG_LINK);
						
						HashMap<String, String> map = new HashMap<String, String>(); 
						
						map.put(TAG_JUDUL, judul);
						map.put(TAG_LINK, link);
						pencarian2.add(map);
					}
				}
				else
				{
					
				}
			}
			catch (JSONException e)
			{
				e.printStackTrace();
			}
			return null;
		}
		@Override
		protected void onPostExecute(String file_url) {
			// TODO Auto-generated method stub
			pDialog.dismiss();
			runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
				ListAdapter adapter = new SimpleAdapter(ViewAllData.this, pencarian2, R.layout.tampil_data, 
						new String[] {TAG_JUDUL, TAG_LINK}, new int[] 
								{R.id.textJudul, R.id.textLink});
				setListAdapter(adapter);
				}

			});
		}
	}
}
