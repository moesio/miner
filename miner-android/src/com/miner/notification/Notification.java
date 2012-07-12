package com.miner.notification;

import android.content.Context;
import android.widget.Toast;

/**
 * 
 * @author Marcus Pimenta
 * @date Jun 2012
 */
public class Notification{
	
	private Context context;
	private Toast toast;
	
	/**
	 * Builder, receives context from application
	 * @param context
	 */
	public Notification(Context context){
		this.context = context;
		this.toast = null;
	}
	
	/**
	 * Show toast
	 * @param mensagem
	 */
	public void show(String mensagem){
		if(toast != null){
			toast.setText(mensagem);
		}else
			toast = Toast.makeText(context, mensagem, Toast.LENGTH_LONG);
		toast.show();
	}
	
	/**
	 * Close toast
	 */
	public void close(){
		if(toast != null)
			toast.cancel();
	}

}
