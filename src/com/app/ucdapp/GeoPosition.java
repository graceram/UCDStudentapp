/* This is called by Activity3 class when interactive map option is chosen.
 * Uses map layout to display an interactive map based on current location.
 */
package com.app.ucdapp;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class GeoPosition extends MapActivity implements OnClickListener {

	private MapController mapController;
	private MapView mapView;
	private LocationManager locationManager;
	GeoPoint p;
	Button alert;
	class MapOverlay extends com.google.android.maps.Overlay
    {
        public boolean draw(Canvas canvas, MapView mapView, 
        boolean shadow, long when) 
        {
            super.draw(canvas, mapView, shadow);                   
 
            //---translate the GeoPoint to screen pixels---
            Point screenPts = new Point();
            mapView.getProjection().toPixels(p, screenPts);
 
            //---add the marker---
            Bitmap bmp = BitmapFactory.decodeResource(
                getResources(), R.drawable.pin);            
            canvas.drawBitmap(bmp, screenPts.x, screenPts.y-50, null);         
            return true;
        }
    }
	
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.map);
		alert = (Button) findViewById(R.id.back);
		alert.setOnClickListener(this);
		// create a map view
		@SuppressWarnings("unused")
		RelativeLayout linearLayout = (RelativeLayout) findViewById(R.id.mainlayout);
		mapView = (MapView) findViewById(R.id.mapview);
		mapView.setBuiltInZoomControls(true);
		mapView.setStreetView(true);
		mapController = mapView.getController();
		mapController.setZoom(16); // Zoom 1 is world view
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
				0, new GeoUpdateHandler());
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	public class GeoUpdateHandler implements LocationListener {

		@Override
		public void onLocationChanged(Location location) {
			int lat = (int) (location.getLatitude() * 1E6);
			int lng = (int) (location.getLongitude() * 1E6);
			
			p = new GeoPoint(lat,lng);
			//p = new GeoPoint(53306518, -6223497);
			//GeoPoint point = new GeoPoint(lat, lng);
			mapController.animateTo(p);
			MapOverlay mapOverlay = new MapOverlay();
	        List<Overlay> listOfOverlays = mapView.getOverlays();
	       listOfOverlays.clear();
	       listOfOverlays.add(mapOverlay);
		}

		@Override
		public void onProviderDisabled(String provider) {
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
		}

		@Override
		public void onProviderEnabled(String arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	public void onClick(View view) {
		Intent intentb = new Intent(view.getContext(), ucdapp.class);
		startActivity(intentb);
	}
}
