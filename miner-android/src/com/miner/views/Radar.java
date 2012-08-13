package com.miner.views;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

/**
 * 
 * @author Marcus Pimenta
 * @date Jun 2012
 */
public class Radar extends Overlay{
	
	private int raio;
	private int colorStart;
	private int colorEnd;
	private float degrees;
	private Paint paint;
	private GeoPoint geoPoint;
	
	public Radar(GeoPoint geoPoint, int colorStart, int colorEnd, int raio, float degrees){
		this.geoPoint = geoPoint;
		this.colorEnd = colorEnd;
		this.colorStart = colorStart;
		this.raio = raio;
		this.degrees = degrees;
		paint = new Paint();
	}
	
	public void setGeoPoint(GeoPoint geoPoint){
		this.geoPoint = geoPoint;
	}
	
	public void setRaio(int raio){
		this.raio = raio;
	}
	
	public void setDegrees(float degrees){
		this.degrees = degrees;
	}
	
	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		
		if(geoPoint != null){
			canvas.save();
			
			float radius = mapView.getProjection().metersToEquatorPixels(raio);
			
			float center_x, center_y;
			center_x = mapView.getProjection().toPixels(geoPoint, null).x;
			center_y = mapView.getProjection().toPixels(geoPoint, null).y;

			final RectF oval = new RectF();
			oval.set(center_x - radius, 
					 center_y - radius, 
					 center_x + radius, 
					 center_y + radius);

			canvas.rotate(degrees, center_x, center_y);
			
			paint.setAntiAlias(true);
			paint.setStyle(Paint.Style.FILL);
			paint.setStrokeCap(Paint.Cap.SQUARE);
			
			Shader gradient = new SweepGradient(center_x, center_y, colorStart, colorEnd);
			paint.setShader(gradient);
			
			canvas.drawArc(oval, 200, 159, true, paint);
			
			super.draw(canvas, mapView, shadow);
			canvas.restore();
		}
	}
	
}

