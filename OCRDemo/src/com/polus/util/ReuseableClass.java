package com.polus.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;

public class ReuseableClass {
	

  public static String storedSuffix="@#$%&*";
	//===================================================================================================================================
	//Preference variable
	//===================================================================================================================================

	//--------------------------------------------
	// method to save variable in preference
	//--------------------------------------------
	public static void saveInPreference(String name, String content, Activity myActivity) {
		SharedPreferences preferences = PreferenceManager
				.getDefaultSharedPreferences(myActivity);
		SharedPreferences.Editor editor = preferences.edit();
		editor.putString(name, content);
		editor.commit();
	}

	//--------------------------------------------
	// getting content from preferences
	//--------------------------------------------
	public static String getFromPreference(String variable_name, Activity myActivity) {
		String preference_return;
		SharedPreferences preferences = PreferenceManager
				.getDefaultSharedPreferences(myActivity);
		preference_return = preferences.getString(variable_name, "");

		return preference_return;
	}



	//===================================================================================================================================
	//Preference variable
	//===================================================================================================================================

}
