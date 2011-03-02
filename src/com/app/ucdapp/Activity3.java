/* This class is called by ucdapp class.
 * Uses list_view layout to display the applications as web view.
 * Interactive map is displayed using GeoPosition class.
 * Back to Main Menu button allows users to go back to Main menu. 
 */
package com.app.ucdapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;


public class Activity3 extends Activity implements View.OnClickListener {
	/** Called when the activity is first created. */
	WebView browser;
	Button alert;
	float scaler;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.list_view);
		browser = (WebView) findViewById(R.id.webkit);
		browser.getSettings().setJavaScriptEnabled(true);
		browser.getSettings().setDefaultFontSize(16);
		alert = (Button) findViewById(R.id.back);
		alert.setOnClickListener(this);
		Intent intent = this.getIntent();
		Bundle par_variable = intent.getExtras();
		int checksite = par_variable.getInt("test");
		switch (checksite) {
		case 0:
			browser
			.loadUrl("http://www.ucd.ie/itservices/webservices/ucdconnect/");
			break;
		case 1:
			browser.loadUrl("https://sisweb.ucd.ie/usis/bwskfshd.P_CrseSchd");
			break;
		case 2:
			browser
			.loadUrl("https://sisweb.ucd.ie/usis/W_SM_WEB_ENR_FEES.SHOW?P_CHECK=SIS");
			break;
		case 3:
			browser
			.loadUrl("https://www.google.com/accounts/ServiceLoginAuth?continue=http%3A%2F%2Fwww.google.com%2Fcalendar%2Frender&followup=http%3A%2F%2Fwww.google.com%2Fcalendar%2Frender&service=cl");
			break;
		case 4:
			browser.loadUrl("https://csimoodle.ucd.ie/moodle/login/index.php");
			break;
		case 5:
			browser
			.loadUrl("https://elearning.ucd.ie/webapps/portal/frameset.jsp");
			break;
		case 6:
			browser
			.loadUrl("http://www.ucd.ie/itservices/");
			break;
		case 7:
			browser
			.loadUrl("https://sisweb.ucd.ie/usis/twbkwbis.P_GenMenu?name=homepage");
			break;
		case 8:
			browser.loadUrl("http://www.google.com");
			break;
		case 9:
			browser
			.loadUrl("http://www.ucd.ie/events/calendar?sc=University+Events%3AAlumni&sc=University+Events%3ACareers&sc=University+Events%3AConferences&sc=University+Events%3AConferring&sc=University+Events%3AInnovation&sc=University+Events%3ALectures+%26+Seminars&sc=University+Events%3AOpen+Days&sc=University+Events%3AResearch&sc=University+Events%3ASocial+%26+Cultural&sc=University+Events%3ASport&mc=Student+Events&sc=Student+Events%3ASport&sc=Student+Events%3AStudent+Activities&sc=Student+Events%3AStudents%27+Union");
			break;
		case 10:
			browser.loadUrl("http://www.ucd.ie/library/");
			break;
		case 11:
			browser.loadUrl("http://www.ucd.ie/hr/");
			break;
		case 12:
			//browser.loadUrl("http://mappery.com/UCD-Belfield-Campus-Map");
			//browser.loadUrl("http://maps.google.com/?ie=UTF8&ll=53.307086,-6.224573&spn=0.000636,0.002583&t=h&z=19");
			//browser.loadUrl("http://www.ucd.ie/itservices/mediaservices/interactivemapminisite/interactivemap/");
			Intent intent3 = new Intent(this.getBaseContext(), Disp_Map.class);
			//intent.putExtra("test2", 1);
			startActivity(intent3);
			//browser.getSettings().setBuiltInZoomControls(true);
			//browser.loadUrl("http://www.openstreetmap.org/export/embed.html?bbox=-6.23952,53.3021,-6.20536,53.31357&amp;layer=mapnik&amp;marker=53.30971,-6.22270");
			break;
		case 13:
			Intent intent2 = new Intent(this.getBaseContext(), GeoPosition.class);
			//intent.putExtra("test2", 3);
			startActivity(intent2);
			break;
		case 14:
			Intent intent4 = new Intent(this.getBaseContext(), Disp_Food.class);
			//intent.putExtra("test2", 2);
			startActivity(intent4);
			break;
		default:
			browser.loadUrl("http://www.ucdconnect.ie");
			break;
		}
	}

	public void onClick(View view) {
		Intent intent = new Intent(view.getContext(), ucdapp.class);
		startActivity(intent);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && browser.canGoBack()) {
			browser.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
