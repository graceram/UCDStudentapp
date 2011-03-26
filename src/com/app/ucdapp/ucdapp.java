/* The SplashClass calls this ucdapp class.
 * This class uses the ImageAdapter class and grid_ucdapp.xml 
 * to display icons of all the applications as a grid.
 * When any of the icon is clicked, Web_View class is called.
 */


package com.app.ucdapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ucdapp extends Activity {
	/** Called when the activity is first created. */
	TextView selection;
	GridView gridview;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid_ucdapp);
		selection = (TextView) findViewById(R.id.welcometxt);
		selection.setText("Welcome to UCD APP");

		selection.setAnimation(AnimationUtils.loadAnimation(this,
			R.anim.push_up_out));
		//selection.getAnimation().setStartTime(3000);

		gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ImageAdapter(this));
		gridview.setOnItemClickListener(new OnItemClickListener()

		{
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				Intent intent = new Intent(parent.getContext(), Web_View.class);
				intent.putExtra("test", position);
				startActivity(intent);
			}


		});
	}
}
