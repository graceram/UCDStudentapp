package com.app.ucdapp;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	
	private Context mContext;

	public ImageAdapter(Context c) {
		mContext = c;
	}

	public int getCount() {
		return mThumbIds.length;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if (convertView == null) {

			imageView = new ImageView(mContext);
			//imageView.setLayoutParams(new GridView.LayoutParams(120, 120));
			imageView.setLayoutParams(new GridView.LayoutParams(100, 100));
			imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
			imageView.setPadding(4, 4, 4, 4);
		} else {
			imageView = (ImageView) convertView;
		}
		imageView.setImageResource(mThumbIds[position]);
		return imageView;
	}

	private Integer[] mThumbIds = { R.drawable.mail, R.drawable.schedule,
			R.drawable.accounts, R.drawable.deadline, R.drawable.moodle,
			R.drawable.blackboard, R.drawable.ucdconnect, R.drawable.sisweb,
			R.drawable.google, R.drawable.events , R.drawable.library,
			R.drawable.hr, R.drawable.map, R.drawable.inmap, R.drawable.restaurants};
}
