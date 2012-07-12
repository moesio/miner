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

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.maps.OverlayItem;
import com.miner.main.R;

public class CustomBalloonOverlayView<Item extends OverlayItem> extends BalloonOverlayView<CustomOverlayItem> {

	private TextView title;
	private TextView snippet;
	private ImageView image;
	
	public CustomBalloonOverlayView(Context context, int balloonBottomOffset) {
		super(context, balloonBottomOffset);
	}
	
	@Override
	protected void setupView(Context context, final ViewGroup parent) {
		
		// inflate our custom layout into parent
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.balloon_overlay_example2, parent);
		
		// setup our fields
		title = (TextView) view.findViewById(R.id.balloon_item_title);
		snippet = (TextView) view.findViewById(R.id.balloon_item_snippet);
		image = (ImageView) view.findViewById(R.id.balloon_item_image);

	}

	@Override
	protected void setBalloonData(CustomOverlayItem item, ViewGroup parent) {
		
		title.setText(item.getTitle());
		snippet.setText(item.getSnippet());
		image.setImageDrawable(item.getImage());
		
	}
	
}
