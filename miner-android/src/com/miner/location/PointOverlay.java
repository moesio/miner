package com.miner.location;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

/**
 * 
 * @author Marcus Pimenta
 * @date Jun 2012
 */
public class PointOverlay extends Overlay{
	
	private int raio;
	private int color;
	private Style style;
	private Paint paint;
	private GeoPoint geoPoint;
	
	public PointOverlay(GeoPoint geoPoint, int color, int raio, Style style){
		this.geoPoint = geoPoint;
		this.color = color;
		this.raio = raio;
		this.style = style;
		
		paint = new Paint();
	}
	
	public void setGeoPoint(GeoPoint geoPoint){
		this.geoPoint = geoPoint;
	}
	
	public void setRaio(int raio){
		this.raio = raio;
	}
	
	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		super.draw(canvas, mapView, shadow);
		
		float radius = mapView.getProjection().metersToEquatorPixels(raio);
		
		if(geoPoint != null){
			paint.setColor(color);
			paint.setStyle(style);
			
			canvas.drawCircle(mapView.getProjection().toPixels(geoPoint, null).x, 
							  mapView.getProjection().toPixels(geoPoint, null).y, 
							  radius, 
							  paint);
		}
	}
	
}
