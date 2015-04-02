package com.app.testapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;
import android.util.Log;

public class FetchingWebData extends AsyncTask<Object, Void, String> {
	AsyncActivity asyncActivity = null;

	@Override
	protected void onPreExecute() {
		super.onPreExecute();

	}

	@Override
	protected String doInBackground(Object... url) {
		String result = null;
		try {

			asyncActivity = (AsyncActivity) url[1];
			HttpConnection httpConnection = new HttpConnection();
			result = httpConnection.doHttpUrlConnection();
			Log.i("<<Checking the flag of the data>>", String.valueOf(result));
			Log.i("<<Reading all files data form internet>>", result.toString());

		} catch (Exception ie) {
			ie.printStackTrace();
		}

		return result;
	}

	@Override
	protected void onProgressUpdate(Void... values) {
		super.onProgressUpdate(values);
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		try {
			if (result != null) {
				asyncActivity.backtoActivity(result);
			}
		} catch (Exception e) {
			Log.i("<<Error in the thread post excecute>>", e.toString());
		}
	}

}
