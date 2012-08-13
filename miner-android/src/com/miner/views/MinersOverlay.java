package com.miner.views;

import java.util.ArrayList;
import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;
import com.miner.constant.Constant;
import com.miner.domain.Miner;

/**
 * 
 * @author Marcus Pimenta
 * @date Jun 2012
 */
public class MinersOverlay extends ItemizedOverlay<OverlayItem> {
	
	private List<Miner> mItems;
	private Message message;
	//private Handler handler;
	
	public MinersOverlay(Drawable marker, Handler handler) {
		super(boundCenterBottom(marker));
		//this.handler = handler;
		
		message = new Message();
		message.what = Constant.MINER;
	}
	
	public void setAlfaItem(int position, int alfa){

		if(alfa < 0){
			int alfaCurrent = mItems.get(position).getAlfa();
			if(alfaCurrent-2 >= 0){
				alfaCurrent = alfaCurrent - 2;
				mItems.get(position).setAlfa(alfaCurrent);
			}
		}else{
			mItems.get(position).setAlfa(alfa);
		}

		setLastFocusedIndex(-1);
		populate();
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
		Drawable image = mItems.get(i).getImage();
		image.setAlpha(mItems.get(i).getAlfa());
		OverlayItem item = new OverlayItem(mItems.get(i).getGeoPoint(),null,null);
		item.setMarker(boundCenterBottom(image));
		return item;
	}
 
	@Override
	public int size() {
		return mItems.size();
	}
 
	@Override
	public boolean onTap(int i) {
		Log.i("Miner", mItems.get(i).getName());
		message.obj = mItems.get(i);
		message.arg1 = i;
		//handler.dispatchMessage(message);
		return true;
	}
	 
}