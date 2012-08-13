package com.miner.location;

import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;

/**
 * 
 * @author Marcus Pimenta
 * @date Jun 2012
 */
public class Gps {
	
	private LocationManager mlocManager;
	private MyLocation mlocListener;
		
	public Gps(Context context, Handler handler){
		mlocManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		mlocListener = new MyLocation(context, handler);
	}
	
	public void startCaptureLocation(){
		mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, mlocListener);
	}
	
	public void stopCaptureLocation(){
		mlocManager.removeUpdates(mlocListener);
	}
}
