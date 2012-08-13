package com.miner.activitys;

import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.crittercism.app.Crittercism;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.miner.constant.Constant;
import com.miner.domain.Miner;
import com.miner.location.Gps;
import com.miner.main.R;
import com.miner.manager.Manager;
import com.miner.map.Map;
import com.miner.sharedpreferences.SharedPreferencesUtil;
import com.miner.views.ImageOverlay;
import com.miner.views.MinersOverlay;
import com.miner.views.Radar;

/**
 * 
 * @author Marcus Pimenta
 * @date Jun 2012
 */
public class MapaActivity extends MapActivity{
		
	private final String TAG = "Miner";
	
	private int degressMap = 360;
	private int degressRadar = 200;
	
	private Map map;
	private Gps gps;
	private Radar radar;
	private Location myLocation;
	private ImageOverlay myLocationImage;
	private MinersOverlay minersOverlay;
	private Manager comServer;
	private Handler handlerInternal;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Crittercism.init(getApplicationContext(), "500f244fc8f974267a000001");
        
        comServer = new Manager();
        handlerInternal = new Handler();
        myLocation = new Location("myLocation");
        
        gps = new Gps(MapaActivity.this, handler);
        map = new Map(findViewById(R.id.mapa));
        myLocationImage = new ImageOverlay(null, R.drawable.android);
        radar = new Radar(null, Color.DKGRAY, Color.TRANSPARENT, Constant.RAIO, 0);
        minersOverlay = new MinersOverlay(getResources().getDrawable(R.drawable.robot), handler);
        
        map.configZoom(true);
        map.addOverlay(radar);
        map.addOverlay(myLocationImage);
        map.addOverlay(minersOverlay);
        
        minersOverlay.setItems(comServer.getMiners(MapaActivity.this, myLocation));
        gps.startCaptureLocation();
        
        //recoversLastLocation();
        handlerInternal.postDelayed(timer, Constant.DELAY_INCREASE);
    }
	
	private Runnable timer = new Runnable() {
		public void run() {
			if(degressMap == 0){
				degressMap = 360;
			} else{
				degressMap--;
			}
			
			if(degressRadar == 0){
				degressRadar = 360;
			}else{
				degressRadar--;
			}
			
			if(myLocation != null){
				captureRadar(degressRadar);
			}
			
			radar.setDegrees(degressMap);
			map.updateMap();
			
			handlerInternal.postDelayed(timer, Constant.DELAY_INCREASE);
		}
	};
	
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
            synchronized (msg) {
                switch (msg.what) {
                	case Constant.MY_LOCATION:
                		myLocation = (Location)msg.obj;
                		
                		GeoPoint geoPoint = new GeoPoint((int)(myLocation.getLatitude()*1e6), (int)(myLocation.getLongitude()*1e6));
                		
                		SharedPreferencesUtil.write(MapaActivity.this, Constant.MY_LOCATION_LATITUDE, (float)myLocation.getLatitude());
                		SharedPreferencesUtil.write(MapaActivity.this, Constant.MY_LOCATION_LONGITUTE, (float)myLocation.getLongitude());
                		
                		radar.setGeoPoint(geoPoint);
                		myLocationImage.setGeoPoint(geoPoint);
                		
                		map.updateMap();
                		break;
                	case Constant.MINER:
                		Miner miner = (Miner)msg.obj;
                		
                		Location minerClicked = new Location("miner");
                		minerClicked.setLatitude(miner.getGeoPoint().getLatitudeE6()/1e6);
                		minerClicked.setLongitude(miner.getGeoPoint().getLongitudeE6()/1e6);
                		
                		if(myLocation != null){
		            		if(myLocation.distanceTo(minerClicked) <= Constant.RAIO){
		            			Log.d(TAG, "dentro do raio");
		            			minersOverlay.removeItem(msg.arg1);
		            		}
                		}
	            		
	            		break;
                }
            }
        };
	};
	
	public void recoversLastLocation(){
		GeoPoint geoPoint = new GeoPoint( (int)(SharedPreferencesUtil.readFloat(MapaActivity.this, Constant.MY_LOCATION_LATITUDE, 0)*1e6), 
				 						  (int)(SharedPreferencesUtil.readFloat(MapaActivity.this, Constant.MY_LOCATION_LONGITUTE, 0)*1e6) );
		
		myLocation.setLatitude(geoPoint.getLatitudeE6()/1e6);
		myLocation.setLongitude(geoPoint.getLongitudeE6()/1e6);
		
		map.getMapa().getController().setZoom(SharedPreferencesUtil.readInt(MapaActivity.this, Constant.ZOOM_LEVEL, 5));
		map.centralizaMapa(geoPoint);
		
		radar.setGeoPoint(geoPoint);
		myLocationImage.setGeoPoint(geoPoint);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		SharedPreferencesUtil.write(MapaActivity.this, Constant.ZOOM_LEVEL, map.getMapa().getZoomLevel());
		handlerInternal.removeCallbacks(timer);
		gps.stopCaptureLocation();
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	
	public void captureRadar(int anguloRadar){
		int anguloPoint;
		Location temp = new Location("temp");
		for(int x = 0; x < comServer.getMiners(MapaActivity.this, myLocation).size(); x++){
			temp.setLatitude(comServer.getMiners(MapaActivity.this, myLocation).get(x).getGeoPoint().getLatitudeE6()/1e6);
			temp.setLongitude(comServer.getMiners(MapaActivity.this, myLocation).get(x).getGeoPoint().getLongitudeE6()/1e6);
			
			if(minersOverlay.getItems().get(x).getAlfa() > 0){
				minersOverlay.setAlfaItem(x, -1);
			}
			
			anguloPoint = (int)getQuadrant(comServer.getMiners(MapaActivity.this, myLocation).get(x).getGeoPoint());
			if(anguloPoint == anguloRadar && temp.distanceTo(myLocation) <= Constant.RAIO){
				minersOverlay.setAlfaItem(x, 255);
				Log.i("Miner", comServer.getMiners(MapaActivity.this, myLocation).get(x).getName());
			}
		}
	}
	
	public double getQuadrant(GeoPoint point){
		double cos, sen, tag, distance;
		double dX, dY, anguloRadianes, angulo;
		
		dX = (point.getLongitudeE6() - (myLocation.getLongitude()*1e6));
		dY = (point.getLatitudeE6() - (myLocation.getLatitude())*1e6);
		
		distance = Math.sqrt(dX*dX + dY*dY);
		
		cos = dX/distance;
		sen = dY/distance;
		
		tag = dY/dX;
		anguloRadianes = Math.atan(tag);
		angulo = Math.abs(Math.toDegrees(anguloRadianes));
		
		if(cos > 0 && sen > 0){
			return 360 - angulo;
		}else{
			if(cos < 0 && sen > 0){
				return 180 + angulo;
			}else{
				if(cos < 0 && sen < 0){
					return 180 - angulo;
				}else{
					if(cos > 0 && sen < 0){
						return angulo;
					}else{
						return 0;
					}
				}
			}
		}
	}
		
}