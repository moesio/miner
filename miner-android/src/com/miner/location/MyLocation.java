package com.miner.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.miner.constant.Constant;

/**
 * 
 * @author Marcus Pimenta
 * @date Jun 2012
 */
public class MyLocation implements LocationListener{
	
	private final String TAG = "Miner GPS";
	
	private Handler handler;
	private Message msg;
		
	public MyLocation(Context context, Handler handler){
		this.handler = handler;
		msg = new Message();
		msg.what = Constant.MY_LOCATION;
	}
	
	public void onLocationChanged(Location location){
		Log.i(TAG, "get location");
		msg.obj = location;
		handler.dispatchMessage(msg);
    }
	
	public void setHandler(Handler handler){
		this.handler = handler;
	}

	public void onProviderDisabled(String provider){
		Log.i(TAG, "disable gps");
	}

	public void onProviderEnabled(String provider){
		Log.i(TAG, "enable gps");
	}

	public void onStatusChanged(String provider, int status, Bundle extras){}


}
