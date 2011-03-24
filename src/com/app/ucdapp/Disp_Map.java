/* This is called by Activity3 class when map option is chosen.
 * Displays a  simple graphic first and on click
 * uses map layout to display an enlarged map.
 */

package com.app.ucdapp;


import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

public class Disp_Map extends Activity implements OnClickListener, OnTouchListener {
	WebView browser;
	Button alert;
	ImageView imageView;
	Button alert2;
	int checksite=1;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.disp_map);
		imageView = (ImageView) findViewById(R.id.imageView);
		imageView.setImageResource(R.drawable.campus);
		imageView.setOnClickListener(this);
			
		alert2 = (Button) findViewById(R.id.back);
		alert2.setOnClickListener(this);

	}
	private void startBrowser()  {
	setContentView(R.layout.web_view);
	browser = (WebView) findViewById(R.id.webkit);
	//browser.setOnTouchListener(this);
	browser.getSettings().setJavaScriptEnabled(true);
	browser.getSettings().setDefaultFontSize(16);
	browser.getSettings().setBuiltInZoomControls(true);
}

	public void onClick(View view) {
		
		if (view == imageView) {
			startBrowser();
			alert = (Button) findViewById(R.id.back);
			alert.setOnClickListener(this);
			
			browser.loadUrl("file:///android_asset/campus.png");
			
		}
		if ((view == alert) ||  (view == alert2)){
			Intent intentb = new Intent(view.getContext(), ucdapp.class);
			startActivity(intentb);

		}

	}
	
	public boolean onTouchEvent(MotionEvent event) 
    {   
       
//        if (event.getAction() == 1) {                
//         int p = (int) event.getX();
//  	     int q = (int) event.getY();
//  	    
//                Toast.makeText(getBaseContext(), 
//                  p + "," + 
//                 q ,
//                 Toast.LENGTH_SHORT).show();
//                 }
                 return  false;
    }
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}


}
