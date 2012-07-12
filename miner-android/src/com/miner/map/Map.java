package com.miner.map;

import android.view.View;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

/**
 * 
 * @author Marcus Pimenta
 * @date Jun 2012
 */
public class Map {
	
	private MapView mapa;
	private MapController controlador;
	
	public Map(View view){
		this.mapa = (MapView) view;
		this.controlador = mapa.getController();
	}
	
	public void configZoom(boolean flag){
    	this.mapa.setBuiltInZoomControls(flag);
    }
	
	public void centralizaMapa(GeoPoint geoPoint){
		 this.controlador.animateTo(geoPoint);
	}
	
	public void updateMap(){
		controlador.setZoom(mapa.getZoomLevel()-1);
		controlador.setZoom(mapa.getZoomLevel()+1);
	}

	public MapView getMapa() {
		return mapa;
	}

	public void setMapa(MapView mapa) {
		this.mapa = mapa;
	}
	
	public void modoRua(){
		mapa.setSatellite(false);
    	mapa.setStreetView(true);
    	mapa.setTraffic(false);
	}
	
	public void modoSatelete(){
		mapa.setSatellite(true);
    	mapa.setStreetView(false);
    	mapa.setTraffic(false);
	}
	
	public void modoTerreno(){
		mapa.setSatellite(true);
    	mapa.setStreetView(false);
    	mapa.setTraffic(true);
	}
	
	public void clearMapa(){
		mapa.getOverlays().clear();
    }
	
	public void addOverlay(Overlay overlay){
		mapa.getOverlays().add(overlay);
	}
	
}
