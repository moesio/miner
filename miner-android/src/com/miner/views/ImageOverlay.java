package com.miner.views;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

/**
 * 
 * @author Marcus Pimenta
 * @date Jun 2012
 */
public class ImageOverlay extends Overlay{
	
	private int idImage;
	private GeoPoint geoPoint;
	
	public ImageOverlay(GeoPoint geoPoint, int idImage){
		this.geoPoint = geoPoint;
		this.idImage = idImage;
	}
	
	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		super.draw(canvas, mapView, shadow);
		
		if(geoPoint != null){
			Point point = mapView.getProjection().toPixels(geoPoint, null);
			Bitmap bitmap = BitmapFactory.decodeResource(mapView.getResources(), this.idImage);
			
			canvas.drawBitmap(bitmap, 
							  point.x - bitmap.getWidth() / 2,
							  point.y - bitmap.getHeight() / 2, 
							  null);
		}
	}
	
	public void setGeoPoint(GeoPoint geoPoint){
		this.geoPoint = geoPoint;
	}

}
