package com.miner.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 
 * @author Marcus Pimenta
 * @date Jun 2012
 */
public class SharedPreferencesUtil {
	
	public static final String NAME = "serial";
	
	/**
	 * Write integer in shared preferences 
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void write(Context context, String key, int value) {
		SharedPreferences pref = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
		pref.edit().putInt(key, value).commit();
	}

	/**
	 * Write boolean in shared preferences
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void write(Context context, String key, boolean value) {
		SharedPreferences pref = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
		pref.edit().putBoolean(key, value).commit();
	}
	
	/**
	 * Write string in shared preferences
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void write(Context context, String key, String value) {
		SharedPreferences pref = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
		pref.edit().putString(key, value).commit();
	}
	
	/**
	 * Write long in shared preferences
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void write(Context context, String key, long value) {
		SharedPreferences pref = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
		pref.edit().putLong(key, value).commit();
	}
	
	/**
	 * Write float in shared preferences
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void write(Context context, String key, float value) {
		SharedPreferences pref = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
		pref.edit().putFloat(key, value).commit();
	}

	/**
	 * Read string of shared preferences
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static String readString(Context context, String key, String defValue) {
		SharedPreferences pref = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
		return pref.getString(key, defValue);
	}
	
	/**
	 * Read boolean of shared preferences
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static boolean readBoolean(Context context, String key, boolean defValue) {
		SharedPreferences pref = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
		return pref.getBoolean(key, defValue);
	}
	
	/**
	 * Read integer of shared preferences
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static int readInt(Context context, String key, int defValue) {
		SharedPreferences pref = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
		return pref.getInt(key, defValue);
	}
	
	/**
	 * Read long of shared preferences
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static long readLong(Context context, String key, long defValue) {
		SharedPreferences pref = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
		return pref.getLong(key, defValue);
	}
	
	/**
	 * Read float of shared preferences
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static float readFloat(Context context, String key, float defValue) {
		SharedPreferences pref = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
		return pref.getFloat(key, defValue);
	}
	
	/**
	 * Clear shared preferences
	 * @param context
	 * @param key
	 */
	public static void clear(Context context, String key) {
		SharedPreferences pref = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
		pref.edit().remove(key).commit();
	}
	
}
