package com.miner.domain;

import android.graphics.drawable.Drawable;

import com.google.android.maps.GeoPoint;

/**
 * 
 * @author Marcus Pimenta
 * @date Jun 2012
 */
public class Miner {
	
	private String name;
	private String categoria;
	private String message;
	private GeoPoint geoPoint;
	private Drawable image;
	private int alfa;
	
	public Miner(String name, String categoria, String message, GeoPoint geoPoint, Drawable image, int alfa) {
		this.name = name;
		this.categoria = categoria;
		this.message = message;
		this.geoPoint = geoPoint;
		this.image = image;
		this.alfa = alfa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getMessage(){
		return message;
	}
	
	public void setMessage(String message){
		this.message = message;
	}

	public GeoPoint getGeoPoint() {
		return geoPoint;
	}

	public void setGeoPoint(GeoPoint geoPoint) {
		this.geoPoint = geoPoint;
	}
	
	public Drawable getImage() {
		return image;
	}

	public void setImage(Drawable image) {
		this.image = image;
	}

	public int getAlfa() {
		return alfa;
	}

	public void setAlfa(int alfa) {
		this.alfa = alfa;
	}
}
