package com.chandra.applink;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 
 * @author @The_Heran
 * www.theheran.com
 */

public class CustomListView extends  ArrayAdapter<String> {
	//Declarasi
	private final Activity context;
	private final String[] web;
	private final Integer[] imageId;
	
	public CustomListView(Activity context,String[] web, Integer[] imageId) {
		super(context, R.layout.list_single_data, web);
		this.context = context;
		this.web = web;
		this.imageId = imageId;

	}
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
			LayoutInflater inflater = context.getLayoutInflater();
			//Load Custom Layout untuk list 
			View rowView= inflater.inflate(R.layout.list_single_data, null, true);
			//Declarasi komponen
			TextView txtTitle = (TextView) rowView.findViewById(R.id.txtList);
			ImageView imageView = (ImageView) rowView.findViewById(R.id.imgIcon);
			
			//Set Parameter Value
			txtTitle.setText(web[position]);
			imageView.setImageResource(imageId[position]);
			
			return rowView;
		}
}
