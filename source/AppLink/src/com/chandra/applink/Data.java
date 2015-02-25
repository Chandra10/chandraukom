package com.chandra.applink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Data extends ListActivity {

	private ProgressDialog pDialog;
	JSONParser jParser = new JSONParser();
	ArrayList<HashMap<String, String>> pencarian;
	private static String url_hasil_pencarian = "http://192.168.1.105/LinkApp/GetPencarian.php";
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_LINKAPP = "lingapp";
	private static final String TAG_JUDUL = "judul";
	private static final String TAG_LINK = "link";
	
	JSONArray makanan = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data);
		pencarian = new ArrayList<HashMap<String, String>>();
		
		new LoadSemuaDataMakanan().execute();
		ListView view = getListView();
		view.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				String judul = ((TextView) view.findViewById(R.id.textJudul)).getText().toString();
				
				Intent edit = new Intent(getApplicationContext(), Data.class);
				edit.putExtra(TAG_JUDUL, judul);
				startActivityForResult(edit, 100);
				
			}
			
		});
	}
	
	class LoadSemuaDataMakanan extends AsyncTask<String, String, String>
	{

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pDialog = new ProgressDialog(Data.this);
			pDialog.setMessage("Mohon tunggu, loading data...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}
		
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			
			List<NameValuePair> param  = new ArrayList<NameValuePair>();
		
			JSONObject json = jParser.makeHTTPRequest(url_hasil_pencarian, "GET", param);
			
			Log.d("Hasil Pencarian", json.toString());
			
			try{
				int success = json.getInt(TAG_SUCCESS);
				if(success == 1)
				{
					makanan = json.getJSONArray(TAG_LINKAPP);
					for(int i = 0; i < makanan.length(); i++)
					{
						JSONObject c = makanan.getJSONObject(i);
						String judul = c.getString(TAG_JUDUL);
						String link = c.getString(TAG_LINK);
						
						HashMap<String, String> map = new HashMap<String, String>(); 
						
						map.put(TAG_JUDUL, judul);
						map.put(TAG_LINK, link);
						pencarian.add(map);
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
				ListAdapter adapter = new SimpleAdapter(Data.this, pencarian, R.layout.komponen, 
						new String[] {TAG_JUDUL, TAG_LINK}, new int[] 
								{R.id.textJudul, R.id.textLink});
				setListAdapter(adapter);
				}
			});
		}
	}

}
