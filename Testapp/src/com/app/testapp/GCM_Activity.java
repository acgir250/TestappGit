package com.app.testapp;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GCM_Activity extends Activity {
	String regid = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gcm_);

		Button bn = (Button) findViewById(R.id.testapp_gcm_register_button);
		bn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					GCM_Register gcmRegister = new GCM_Register(); 
					if (TextUtils.isEmpty(regid)) {

						gcmRegister.execute(GCM_Activity.this);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	public void showid(String result) {
		Toast.makeText(getBaseContext(), result, Toast.LENGTH_LONG).show();

	}
}
