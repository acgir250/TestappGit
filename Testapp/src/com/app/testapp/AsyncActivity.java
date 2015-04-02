package com.app.testapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class AsyncActivity extends Activity {
	ProgressDialog dialog;
	FetchingWebData fWebData = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_async);
		intializeDialog();
	}

	private void intializeDialog() {
		try {
			dialog = ProgressDialog.show(AsyncActivity.this,
					"Calling the Service", "Wait for the message", true);
			dialog.show();
			fWebData = new  FetchingWebData();
			fWebData.execute("this",this);
			
		} catch (Exception e) {
			Log.e("<<Error occured in the dialog progress bar>>", e.toString());
		}
	}
	public void backtoActivity(String result)
	{
		Log.i("<<Completion of the activity>>","Thread running completion");
		dialog.dismiss();
		Toast.makeText(getBaseContext(),result, Toast.LENGTH_SHORT).show();
	}
}
