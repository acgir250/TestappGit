package com.app.testapp;

import java.util.ArrayList;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyOwnCustomAdapter extends BaseAdapter {
	private ArrayList<DAOLite> listmodel = getlist();
	private Context context;

	public MyOwnCustomAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listmodel.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.listitems, parent, false);
		}
		TextView middlename = (TextView) convertView
				.findViewById(R.id.textView1);
		TextView lastname = (TextView) convertView.findViewById(R.id.textView2);

		DAOLite studentdata = listmodel.get(position);
		middlename.setText(studentdata.getMiddlename());
		lastname.setText(studentdata.getLastname());

		return convertView;
	}

	// poplulating the data in the model.
	private ArrayList<DAOLite> getlist() {
		DAOLite dlitetemp = null;
		ArrayList<DAOLite> listmodel = new ArrayList<DAOLite>();
		try {
			for (int i = 0; i < 10; i++) {
				dlitetemp = new DAOLite();
				dlitetemp.setName("name " + i);
				dlitetemp.setMiddlename("all specificatoins" + i);
				dlitetemp.setLastname("another" + i);
				listmodel.add(dlitetemp);
			}
		} catch (Exception e) {
			Log.i("<<Error occured>>", e.toString());
		}
		return listmodel;
	}

}
