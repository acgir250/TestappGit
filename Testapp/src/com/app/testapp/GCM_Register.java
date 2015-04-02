package com.app.testapp;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class GCM_Register extends AsyncTask<Object, Void, String> {
	private GoogleCloudMessaging gcm = null;
	private String regID = null;
	private GCM_Activity gcm_Activity = null;

	@Override
	protected String doInBackground(Object... param) {
		try {
			gcm_Activity = (GCM_Activity) param[0];
			gcm = GoogleCloudMessaging.getInstance((Context) gcm_Activity);
			regID = gcm.register("673323078779");
			Log.i("<<Got GCM ID:::>>", regID);
		} catch (Exception e) {
			Log.e("<<Exception occur>>", e.toString());
		}
		return regID;
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		gcm_Activity.showid(result);
	}

}
