package com.seimos.miner.android;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;

public class GpsListener implements LocationListener {

	private double latitude;
	private double longitude;
	private Location location;
	private Location lastLocation;
	private Context applicationContext;

	public GpsListener(Context applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Override
	public void onLocationChanged(Location location) {
		this.location = location;
		latitude = location.getLatitude();
		longitude = location.getLongitude();

		if (location != null) {
			lastLocation = location;
		}
	}

	@Override
	public void onProviderDisabled(String provider) {
		Toast.makeText(applicationContext, "Gps Disabled", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onProviderEnabled(String arg0) {
		Toast.makeText(applicationContext, "Gps Enabled", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Location getLocation() {
		return location;
	}

	public Location getLastLocation() {
		return lastLocation;
	}
}
