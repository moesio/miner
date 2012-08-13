/***
 * Copyright (c) 2011 readyState Software Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.miner.balloon;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.miner.main.R;

public class CustomMap extends MapActivity {

	MapView mapView;
	Drawable drawable;
	CustomItemizedOverlay<CustomOverlayItem> itemizedOverlay;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mapView = (MapView) findViewById(R.id.mapa);
		mapView.setBuiltInZoomControls(true);
		
		drawable = getResources().getDrawable(R.drawable.marker);
		itemizedOverlay = new CustomItemizedOverlay<CustomOverlayItem>(drawable, mapView);
		
		CustomOverlayItem overlayItem = new CustomOverlayItem(new GeoPoint((int)(51.5174723*1E6),(int)(-0.0899537*1E6)), 
															  "Marcus Vinícius - Prata", 
															  "Estou muito confiante =)", 
															  getResources().getDrawable(R.drawable.android));
		itemizedOverlay.addOverlay(overlayItem);
		
		CustomOverlayItem overlayItem2 = new CustomOverlayItem(new GeoPoint((int)(51.515259*1E6),(int)(-0.086623*1E6)), 
															   "Moésio Medeiros - Prata", 
															   "Pegando todos...", 
															   getResources().getDrawable(R.drawable.android));		
		itemizedOverlay.addOverlay(overlayItem2);
		
		CustomOverlayItem overlayItem3 = new CustomOverlayItem(new GeoPoint((int)(51.513329*1E6),(int)(-0.08896*1E6)), 
															   "Cásio - Ouro", 
														       "Cheguei pra ficar =P", 
														       getResources().getDrawable(R.drawable.android));
		itemizedOverlay.addOverlay(overlayItem3);
		
		CustomOverlayItem overlayItem4 = new CustomOverlayItem(new GeoPoint((int)(51.51738*1E6),(int)(-0.08186*1E6)), 
															   "Leonardo Pinheiro - Bronze", 
															   "Sou o MELHOR", 
															   getResources().getDrawable(R.drawable.android));		
		itemizedOverlay.addOverlay(overlayItem4);
		
		mapView.getOverlays().add(itemizedOverlay);
		
		mapView.getController().animateTo(new GeoPoint((int)(51.51738*1E6),(int)(-0.08186*1E6)));
		mapView.getController().setZoom(16);
		
    }
	
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

}
