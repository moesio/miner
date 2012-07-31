package com.miner.location;

import java.util.ArrayList;
import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;
import com.miner.constant.Constant;
import com.miner.main.Miner;

/**
 * 
 * @author Marcus Pimenta
 * @date Jun 2012
 */
public class LocationOverlay extends ItemizedOverlay<OverlayItem> {
	
	private Drawable marker;
	private List<Miner> mItems;
	private Message message;
	private Handler handler;
	
	public LocationOverlay(Drawable marker, Handler handler) {
		super(boundCenterBottom(marker));
		this.marker = marker;
		this.handler = handler;
		
		message = new Message();
		message.what = Constant.MINER;
	}
 
	public void setItems(ArrayList<Miner>items){
		mItems = items;
		setLastFocusedIndex(-1);
		populate();
	}
	
	public List<Miner> getItems(){
		return mItems;
	}
	
	public void removeItem(int position){
		mItems.remove(position);
		setLastFocusedIndex(-1);
		populate();
	}
	
	public void clearItens(){
		mItems.clear();
		setLastFocusedIndex(-1);
	}
 
	@Override
	protected OverlayItem createItem(int i) {
		OverlayItem item = new OverlayItem(mItems.get(i).getGeoPoint(),null,null);
		item.setMarker(marker);
		return item;
	}
 
	@Override
	public int size() {
		return mItems.size();
	}
 
	@Override
	public boolean onTap(int i) {
		Log.i("Miner", "Namr " + mItems.get(i).getName() + " position " + i);
		message.obj = mItems.get(i);
		message.arg1 = i;
		handler.dispatchMessage(message);
		return true;
	}
	 
}