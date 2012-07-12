package com.miner.main;

import android.graphics.Color;
import android.graphics.Paint.Style;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.miner.constant.Constant;
import com.miner.location.Gps;
import com.miner.location.ImageOverlay;
import com.miner.location.LocationOverlay;
import com.miner.location.PointOverlay;
import com.miner.location.Radar;
import com.miner.manager.Manager;
import com.miner.map.Map;
import com.miner.sharedpreferences.SharedPreferencesUtil;

/**
 * 
 * @author Marcus Pimenta
 * @date Jun 2012
 */
public class Main extends MapActivity{
		
	private final String TAG = "Miner";
	
	private Map map;
	private Gps gps;
	private Radar radar;
	private Location myLocation;
	private PointOverlay fence;
	private ImageOverlay myLocationImage;
	private LocationOverlay locationOverlay;
	private Manager comServer;
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        comServer = new Manager();
        gps = new Gps(Main.this, handler);
        map = new Map(findViewById(R.id.mapa));
        myLocationImage = new ImageOverlay(null, R.drawable.location);
        radar = new Radar(null, Color.BLACK, Color.TRANSPARENT, Constant.RAIO);
        fence = new PointOverlay(null, Color.BLACK, Constant.RAIO, Style.STROKE);
        locationOverlay = new LocationOverlay(getResources().getDrawable(R.drawable.marker2), handler);
       
        map.configZoom(true);
        map.addOverlay(radar);
        map.addOverlay(fence);
        map.addOverlay(myLocationImage);
        map.addOverlay(locationOverlay);
        locationOverlay.setItems(comServer.getMiners(myLocation));
        gps.startCaptureLocation();
        
        recoversLastLocation();
    }
	
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
            synchronized (msg) {
                switch (msg.what) {
                	case Constant.MY_LOCATION:
                		myLocation = (Location)msg.obj;
                		
                		GeoPoint geoPoint = new GeoPoint((int)(myLocation.getLatitude()*1e6), (int)(myLocation.getLongitude()*1e6));
                		
                		SharedPreferencesUtil.write(Main.this, Constant.MY_LOCATION_LATITUDE, (float)myLocation.getLatitude());
                		SharedPreferencesUtil.write(Main.this, Constant.MY_LOCATION_LONGITUTE, (float)myLocation.getLongitude());
                		
                		radar.setGeoPoint(geoPoint);
                		fence.setGeoPoint(geoPoint);
                		myLocationImage.setGeoPoint(geoPoint);
                		
                		map.updateMap();
                		break;
                	case Constant.MINER:
                		Log.i(TAG, "miner clicked");
                		Miner miner = (Miner)msg.obj;
                		
                		Location minerClicked = new Location("miner");
                		minerClicked.setLatitude(miner.getGeoPoint().getLatitudeE6()/1e6);
                		minerClicked.setLongitude(miner.getGeoPoint().getLongitudeE6()/1e6);
                		
                		if(myLocation != null){
		            		if(myLocation.distanceTo(minerClicked) <= Constant.RAIO){
		            			Log.d(TAG, "dentro do raio");
		            			locationOverlay.removeItem(msg.arg1);
		            		}
                		}
	            		
	            		break;
                }
            }
        };
	};
	
	public void recoversLastLocation(){
		GeoPoint geoPoint = new GeoPoint( (int)(SharedPreferencesUtil.readFloat(Main.this, Constant.MY_LOCATION_LATITUDE, 0)*1e6), 
				 						  (int)(SharedPreferencesUtil.readFloat(Main.this, Constant.MY_LOCATION_LONGITUTE, 0)*1e6) );
		
		map.getMapa().getController().setZoom(SharedPreferencesUtil.readInt(Main.this, Constant.ZOOM_LEVEL, 5));
		map.centralizaMapa(geoPoint);
		
		myLocationImage.setGeoPoint(geoPoint);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		SharedPreferencesUtil.write(Main.this, Constant.ZOOM_LEVEL, map.getMapa().getZoomLevel());
		gps.stopCaptureLocation();
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	
}