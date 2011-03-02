package com.app.ucdapp;


import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Disp_Map extends Activity implements OnClickListener {
	WebView browser;
	Button alert;
	ImageView imageView;
	Button alert2;
	int checksite;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_disp);
		imageView = (ImageView) findViewById(R.id.imageView);
		Intent intent = this.getIntent();
		Bundle par_variable = intent.getExtras();
		checksite = par_variable.getInt("test");
		if (checksite == 1) {
		imageView.setImageResource(R.drawable.campus);
		imageView.setOnClickListener(this);
		}
		else if (checksite == 2) {
			
			startBrowser();
			browser.loadUrl("file:///android_asset/campuseateries.png");
		}
		alert2 = (Button) findViewById(R.id.back);
		alert2.setOnClickListener(this);

	}
	private void startBrowser()  {
	setContentView(R.layout.list_view);
	browser = (WebView) findViewById(R.id.webkit);
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
			Intent intent = new Intent(view.getContext(), ucdapp.class);
			startActivity(intent);

		}

	}
	
	public boolean onTouchEvent(MotionEvent event) 
    {   
       
        if (event.getAction() == 1) {                
         int p = (int) event.getX();
  	     int q = (int) event.getY();
  	    
                Toast.makeText(getBaseContext(), 
                  p + "," + 
                 q ,
                 Toast.LENGTH_SHORT).show();
                 }
                 return  false;
    }


}
