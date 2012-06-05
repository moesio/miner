package com.seimos.miner.android;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class Draw extends Overlay {

	private GeoPoint geoPoint;

	public Draw(GeoPoint geoPoint) {
		super();
		this.geoPoint = geoPoint;
	}

	@Override
	public boolean draw(Canvas canvas, MapView mapView, boolean arg2, long arg3) {

		Point point = mapView.getProjection().toPixels(geoPoint, null);
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		canvas.drawCircle(point.x, point.y, 3, paint);

		return super.draw(canvas, mapView, arg2, arg3);
	}

	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		super.draw(canvas, mapView, shadow);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event, MapView mapView) {
		return super.onKeyDown(keyCode, event, mapView);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event, MapView mapView) {
		return super.onKeyUp(keyCode, event, mapView);
	}

	@Override
	public boolean onTap(GeoPoint p, MapView mapView) {
		return super.onTap(p, mapView);
	}

	@Override
	public boolean onTouchEvent(MotionEvent e, MapView mapView) {
		return super.onTouchEvent(e, mapView);
	}

	@Override
	public boolean onTrackballEvent(MotionEvent event, MapView mapView) {
		return super.onTrackballEvent(event, mapView);
	}

}
