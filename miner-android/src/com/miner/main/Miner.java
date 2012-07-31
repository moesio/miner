package com.miner.main;

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
	private boolean visible;
	
	public Miner(String name, String categoria, String message, GeoPoint geoPoint, boolean visible) {
		this.name = name;
		this.categoria = categoria;
		this.message = message;
		this.geoPoint = geoPoint;
		this.visible = visible;
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

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
}
