package org.asptics.sqlitetest.model.sqlite;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDatabaseHelper extends SQLiteOpenHelper {
	
	private static final CursorFactory cursorFactory=null;
	private static final String DATABASE_NAME="GameTest";

	private static final int version = 1;

	public static final String TABLE_HI_SCORE="HiScore";
	
	public static final String COL_EMAIL="Email";
	public static final String COL_HI_SCORE="HiScore";
	public static final String COL_USER="UserName";
	

private static final String DATABASE_CREATE_SCRIPT = "CREATE TABLE "
+ TABLE_HI_SCORE + " (" + COL_EMAIL
+ " TEXT not null, "
+ COL_HI_SCORE + " REAL not null, "
+ COL_USER + " TEXT not null);";
	

	public SQLiteDatabaseHelper(Context context)
	{
		super(context,DATABASE_NAME,cursorFactory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE_SCRIPT);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_HI_SCORE);

		onCreate(db);
	}

}
