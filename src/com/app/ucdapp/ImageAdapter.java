/* Image Adapter class called from ucdapp class to display icon and text grid
 * Version changes in this from icon and text as .png to layout inflater as text in a grid.
 */
package com.app.ucdapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
	
	Context mContext;
    public static final int ACTIVITY_CREATE = 10; 
	 private String[] mThumbTexts = {"Mail", "Schedule", "Accounts", "Deadlines", "CSIMoodle", "Blackboard", "UCDconnect", "SISWeb",
				"Google", "Events" , "Library","Admin", "Campus Map", "Services Map", "Restaurants Map"};
	 private Integer[] mThumbIds = { R.drawable.mail, R.drawable.schedule,
				R.drawable.accounts, R.drawable.deadline, R.drawable.moodle,
				R.drawable.blackboard, R.drawable.ucdconnect, R.drawable.sisweb,
				R.drawable.google, R.drawable.events , R.drawable.library,
				R.drawable.hr, R.drawable.map, R.drawable.inmap, R.drawable.restaurants};
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
//		ImageView iv = new ImageView(mContext);
		View v;
//		int pxWidth =0;
	   
		if (convertView == null) {
			
		    LayoutInflater li = LayoutInflater.from(mContext);
			//LayoutInflater li = getLayoutInflater();
		   	v = li.inflate(R.layout.icon_view, null); 
            TextView tv = (TextView)v.findViewById(R.id.icon_txt); 
            tv.setText(mThumbTexts[position]); 
            ImageView iv = (ImageView)v.findViewById(R.id.icon_image); 
             
//           iv.setLayoutParams(new GridView.LayoutParams(120, 120));
//			pxWidth = (int)(50 * parent.getContext().getResources().getDisplayMetrics().density);
//			iv.setLayoutParams(new GridView.LayoutParams(pxWidth, pxWidth));
//			iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            iv.setPadding(4, 4, 4, 4);
			iv.setImageResource(mThumbIds[position]);
	
				
		} else {
			v =  convertView;
			
		}
	//	iv.setImageResource(mThumbIds[position]);
	//	return iv;
	return v;
		
		
	}

}