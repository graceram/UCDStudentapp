/* this is the start off point for the application
 * This class creates an animated splash welcome screen that rotates.
 * When the user clicks the screen, the app starts. 
 * This uses splash xml and the welcome image.
 * This class calls ucdapp.class
 */
package com.app.ucdapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.ImageView;
import android.widget.TextView;

public class SplashClass extends Activity implements OnClickListener {
	TextView selection;
	ImageView imgsplash;
	Intent intent;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		imgsplash = (ImageView) findViewById(R.id.splash);
		imgsplash.setOnClickListener(this);

		selection = (TextView) findViewById(R.id.welcome);
		selection.setText("Welcome to UCD APP");
		applyRotation(0, 360);

	}

	private void applyRotation(float start, float end) {
		final float centerX = imgsplash.getHeight() / 2.0f;
		final float centerY = imgsplash.getWidth() / 2.0f;
		final Rotate3dAnimation rotation = new Rotate3dAnimation(start, end,
				centerX, centerY, 310.0f, true);
		rotation.setDuration(1000);
		rotation.setRepeatCount(1);
		rotation.setRepeatMode(2);
		imgsplash.startAnimation(rotation);

	}

	public void onClick(View view) {

		intent = new Intent(view.getContext(), ucdapp.class);
		startActivity(intent);

	}

}
