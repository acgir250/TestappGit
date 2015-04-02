package com.app.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class ListViewWithCustomAdapter extends Activity {
	
	ListView ls = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.datalist);
		try{
		MyOwnCustomAdapter adapter = new MyOwnCustomAdapter(this);
		ls = (ListView) findViewById(R.id.listView1);
		ls.setAdapter(adapter);
		}
		catch(Exception e)
		{
			Log.i("<<Exception occur in the customlist>>", e.toString());
		}
	}

}
