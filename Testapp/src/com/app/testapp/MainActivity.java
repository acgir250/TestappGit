package com.app.testapp;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String TAG_ERROR = "<<Error Occur>>";
	Button mainactivity_Button = null;
	Button mainactivity_callingButton = null;
	Spinner mainactivity_Spinner = null;
	Button mainactivity_customButton = null;
	Button mainactivity_calldatabase = null;
	Button mainactivity_asyncButton = null;
	Button mainactivity_gcmButton = null;
	AutoCompleteTextView mainactivity_AutoCompleteTextView = null;
	OnClickListener onclick = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		intializingEvents();
		intializingComponents();

	}

	private void intializingComponents() {
		try {
			Log.i("<<testapp_info::>>", "Intializing the components..");
			mainactivity_Button = (Button) findViewById(R.id.testapp_normalbutton);
			mainactivity_Button.setOnClickListener(onclick);
			mainactivity_Spinner = (Spinner) findViewById(R.id.testapp_mobile_spinner);
			mainactivity_AutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.testapp_mobile_autocomplete);
			mainactivity_callingButton = (Button) findViewById(R.id.testapp_callingbutton);
			mainactivity_callingButton.setOnClickListener(onclick);
			mainactivity_customButton = (Button) findViewById(R.id.testapp_customlist);
			mainactivity_customButton.setOnClickListener(onclick);
			mainactivity_calldatabase = (Button) findViewById(R.id.testapp_databasecall);
			mainactivity_calldatabase.setOnClickListener(onclick);
			mainactivity_asyncButton = (Button) findViewById(R.id.testapp_asynctask);
			mainactivity_asyncButton.setOnClickListener(onclick);
			mainactivity_gcmButton = (Button) findViewById(R.id.testapp_gcm);
			mainactivity_gcmButton.setOnClickListener(onclick);

		} catch (Exception e) {
			Log.e(TAG_ERROR, e.toString());
		}

	}

	private void intializingEvents() {

		onclick = new OnClickListener() {
			Intent i = null;

			@Override
			public void onClick(View v) {
				try {
					switch (v.getId()) {
					case R.id.testapp_normalbutton:
						ArrayList<String> country = new ArrayList<String>();
						country.add("India");
						country.add("Japan");
						country.add("China");
						country.add("Australia");
						ArrayAdapter<String> spinneradapter = new ArrayAdapter<String>(
								getApplicationContext(),
								R.layout.customspinner, country);
						mainactivity_Spinner.setAdapter(spinneradapter);
						mainactivity_AutoCompleteTextView
								.setAdapter(spinneradapter);
						break;
					case R.id.testapp_callingbutton:
						i = new Intent(getApplicationContext(), FlipView.class);
						startActivity(i);
						i = null;
						break;
					case R.id.testapp_customlist:
						i = new Intent(getApplicationContext(),
								ListViewWithCustomAdapter.class);
						startActivity(i);
						i = null;
						break;
					case R.id.testapp_databasecall:
						i = new Intent(getApplicationContext(),
								SqlLiteDatabaseActivity.class);
						startActivity(i);
						i = null;
						break;
					case R.id.testapp_asynctask:
						i = new Intent(getApplicationContext(),
								AsyncActivity.class);
						startActivity(i);
						i = null;
						break;
					case R.id.testapp_gcm:
						i = new Intent(getApplicationContext(),
								GCM_Activity.class);
						startActivity(i);
						i = null;
						break;
					}
				} catch (Exception e) {
					Log.e(TAG_ERROR, e.toString());
				}
			}
		};

	}

}
