package com.app.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SqlLiteDatabaseActivity extends Activity {
	private OnClickListener onclick;
	private DatabaseHandler db = null;
	private TextView sqlitedatabaseactivity_erno = null;
	private TextView sqlitedatabaseactivity_firstname = null;
	private TextView sqlitedatabaseactivity_middlename = null;
	private TextView sqlitedatabaseactivity_lastname = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_sql_lite_database);
			intializeListener();
			intializeComponents();

		} catch (Exception e) {
			Log.e("<<Error ocurred in the datagbase handling>>", e.toString());
		}

	}

	private void intializeComponents() {
		try {

			Button sqlitedataseactivity_button = (Button) findViewById(R.id.testapp_insert);
			sqlitedataseactivity_button.setOnClickListener(onclick);
			Button sqlitedatabaseactivity_delbutton = (Button) findViewById(R.id.testapp_delete);
			sqlitedatabaseactivity_delbutton.setOnClickListener(onclick);
			sqlitedatabaseactivity_erno = (TextView) findViewById(R.id.testapp_erno);
			sqlitedatabaseactivity_firstname = (TextView) findViewById(R.id.testapp_firstname);
			sqlitedatabaseactivity_middlename = (TextView) findViewById(R.id.testapp_middlename);
			sqlitedatabaseactivity_lastname = (TextView) findViewById(R.id.testapp_lastname);

		} catch (Exception e) {
			Log.i("<<Error occured in intalizing components>>", e.toString());
		}
	}

	private void intializeListener() {

		onclick = new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.testapp_insert:
					db = new DatabaseHandler(SqlLiteDatabaseActivity.this);
					db.doinsert(new DAOLite(Long
							.parseLong(sqlitedatabaseactivity_erno.getText()
									.toString()),
							sqlitedatabaseactivity_firstname.getText()
									.toString(),
							sqlitedatabaseactivity_middlename.getText()
									.toString(),
							sqlitedatabaseactivity_lastname.getText()
									.toString()));
					Toast.makeText(getBaseContext(),
							"Data Successfully inserted", Toast.LENGTH_LONG)
							.show();

					break;
				case R.id.testapp_delete:
					break;
				case R.id.testapp_update:
					break;
				}

			}
		};
	}

}
