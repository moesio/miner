package com.seimos.miner.android;

import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class HelloMapActivity extends MapActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		MapView map = (MapView) findViewById(R.id.map);
		Draw draw = new Draw(new GeoPoint(-25442550, -49279840));
		map.getOverlays().add(draw);

		map.setClickable(true);
		map.setBuiltInZoomControls(true);
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}