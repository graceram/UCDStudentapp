/* The SplashClass calls this ucdapp class.
 * This class uses the ImageAdapter class and main.xml 
 * to display icons of all the applications as a grid.
 * When any of the icon is clicked, Activity3 class is called.
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
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ucdapp extends Activity {
	/** Called when the activity is first created. */
	TextView selection;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		selection = (TextView) findViewById(R.id.welcometxt);
		selection.setText("Welcome to UCD APP");

		selection.setAnimation(AnimationUtils.loadAnimation(this,
				R.anim.push_up_out));
		selection.getAnimation().setStartTime(12000);

		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ImageAdapter(this));
		gridview.setOnItemClickListener(new OnItemClickListener()

		{
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				String[] applist = getResources().getStringArray(
						R.array.appnames);
				Toast.makeText(ucdapp.this, "" + applist[position],
						Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(parent.getContext(), Activity3.class);
				intent.putExtra("test", position);
				startActivity(intent);
			}

		});

	}
}