package com.app.testapp;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "studdata";
	private static final int DATABASE_VERSION = 1;
	private static final String STUDENT_CREATE = "create table studdata"
			+ "(erno integer  primary key,fname text,mname text,lname text)";
	private static final String DATABASE_TABLE_NAME = "studdata";
	private SQLiteDatabase db = null;

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		Log.i("<<Database credentials intialization>>>",
				"Databse Credentials created");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// Database Creation by default or new
		try {
			Log.i("<<Error ocurred in the database>>", "Database table created");
			db.execSQL(STUDENT_CREATE);
		} catch (Exception e) {
			Log.i("<<Error occured>>", e.toString());
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("Drop table if exists" + DATABASE_TABLE_NAME);
		onCreate(db);
	}

	public void doinsert(DAOLite daoLite) {

		db = this.getWritableDatabase();
		db.beginTransactionNonExclusive();
		SQLiteStatement stmt = db
				.compileStatement("insert or replace into studdata (erno,fname,mname,lname)values(?,?,?,?)");
		stmt.bindLong(1, daoLite.getErno());
		stmt.bindString(2, daoLite.getName());
		stmt.bindString(3, daoLite.getMiddlename());
		stmt.bindString(4, daoLite.getLastname());
		stmt.execute();
		stmt.clearBindings();
		stmt.close();

		db.setTransactionSuccessful();
		db.endTransaction();
		db.close();

	}

	// deleting
	public int doDelete(long id) {
		db = this.getWritableDatabase();
		int i = db.delete(DATABASE_TABLE_NAME, "erno=?",
				new String[] { String.valueOf(id) });
		return i;
	}

	// updating a record
	public int doUpdate(DAOLite daoLite) {
		db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("fname", daoLite.getName());
		contentValues.put("mname", daoLite.getMiddlename());
		contentValues.put("lname", daoLite.getLastname());
		int i = db.update(DATABASE_TABLE_NAME, contentValues, "erno=?",
				new String[] { String.valueOf(daoLite.getErno()) });
		return i;
	}

	// Select all records from the database..
	public List<DAOLite> getall() {
		List<DAOLite> dlist = new ArrayList<DAOLite>();
		try {

			db = this.getReadableDatabase();
			Cursor cursor = db.rawQuery("select * from studdata", null);
			while (cursor.moveToNext()) {
				DAOLite daotemp = new DAOLite();
				daotemp.setErno(cursor.getLong(0));
				daotemp.setName(cursor.getString(1));
				daotemp.setMiddlename(cursor.getString(2));
				daotemp.setLastname(cursor.getString(3));
				dlist.add(daotemp);
			}
		} catch (Exception e) {
			Log.i("<<Error ocurred in the getall()>>", e.toString());
		}
		return dlist;
	}

	// get a single record
	public DAOLite getSingle(long erno) {
		DAOLite daolite = null;
		try {
			SQLiteDatabase db = this.getReadableDatabase();

			Cursor cursor = db.query(DATABASE_TABLE_NAME, new String[] {
					"erno", "fname", "mname", "lname" }, "erno=?",
					new String[] { String.valueOf(erno) }, null, null, null,
					null);
			if (cursor != null)
				cursor.moveToFirst();

			daolite = new DAOLite((cursor.getLong(0)), cursor.getString(1),
					cursor.getString(2), cursor.getString(3));
		} catch (Exception e) {
			Log.i("<<Error occured>>", e.toString());
		}
		return daolite;
	}

}
