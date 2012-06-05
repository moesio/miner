package com.seimos.miner.android;

import android.app.Application;
import android.content.Context;
import android.location.LocationManager;

public class Main extends Application {

	private LocationManager locationManager;
	private GpsListener gpsListener;

	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		gpsListener = new GpsListener(this);
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, gpsListener);

	}
}
