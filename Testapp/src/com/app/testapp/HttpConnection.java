package com.app.testapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class HttpConnection {
	Context mcontext = null;
	private HttpClient httpClient = null;
	private static final String WEB_URL = "http://androidexample.com/media/webservice/JsonReturn.php";

	public HttpConnection() {
		// TODO Auto-generated constructor stub
	}

	public HttpConnection(Context mcontext) {
		this.mcontext = mcontext;
	}

	public String doHttpCheck() {
		String content = null;
		try {
			httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(WEB_URL);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			content = httpClient.execute(httpGet, responseHandler);
		} catch (ClientProtocolException ce) {
			ce.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return content;
	}

	public String doHttpUrlConnection() {
		StringBuilder sbBuilder = null;
		String jsonData = null;
		try {
			URL url = new URL(WEB_URL);
			URLConnection conn = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			sbBuilder = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null)
				sbBuilder.append(line);

			JSONObject mainJsonObject = new JSONObject(sbBuilder.toString());
			JSONArray jsonArray = new JSONArray(
					mainJsonObject.getString("Android"));

			JSONObject jsonObject = (JSONObject) jsonArray.get(0);
			jsonData = jsonObject.getString("name");

		} catch (Exception e) {
			Log.i("<Error occured>", e.toString());
		}

		return jsonData;
	}

	public boolean isNetworkAvailable() {
		ConnectivityManager cm = (ConnectivityManager) mcontext
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = cm.getActiveNetworkInfo();
		// if no network is available networkInfo will be null
		// otherwise check if we are connected
		if (networkInfo != null && networkInfo.isConnected()) {
			return true;
		}
		return false;
	}
}
