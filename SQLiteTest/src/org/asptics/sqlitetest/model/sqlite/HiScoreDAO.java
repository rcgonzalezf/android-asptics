package org.asptics.sqlitetest.model.sqlite;

import static org.asptics.sqlitetest.model.sqlite.SQLiteDatabaseHelper.COL_EMAIL;
import static org.asptics.sqlitetest.model.sqlite.SQLiteDatabaseHelper.COL_HI_SCORE;
import static org.asptics.sqlitetest.model.sqlite.SQLiteDatabaseHelper.COL_USER;
import static org.asptics.sqlitetest.model.sqlite.SQLiteDatabaseHelper.TABLE_HI_SCORE;

import java.util.ArrayList;
import java.util.List;

import org.asptics.sqlitetest.model.HiScore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class HiScoreDAO {
	private SQLiteDatabaseHelper dbHelper;
	private SQLiteDatabase db;
	private String[] columns = { COL_EMAIL, COL_HI_SCORE, COL_USER };
	
	public HiScoreDAO(Context context)
	{
		dbHelper = new SQLiteDatabaseHelper(context);
	}
	
	public void openDB(boolean readOnly){
		if(readOnly)
		{
			db = dbHelper.getReadableDatabase();
		}
		else
		{
			db = dbHelper.getWritableDatabase();
		}
	}
	
	public void closeDB()
	{
		dbHelper.close();
	}
	
	public HiScore insertHiScore(HiScore score)
	{
		ContentValues cv = new ContentValues();
		cv.put(COL_EMAIL, score.getEmail());
		cv.put(COL_HI_SCORE, score.getHiScore());
		cv.put(COL_USER, score.getUserName());
		
		long result = db.insert(TABLE_HI_SCORE, null, cv);
		
		if(result == -1 )
		{
			return null;
		}
		else
		{
			return score;
		}
		
	}
	
	public void deleteHiScore(HiScore score)
	{
	  db.delete(TABLE_HI_SCORE, COL_USER + "=\""+ score.getUserName()+"\"", null);
	}
	
	public List<HiScore> getHiScores()
	{
		List<HiScore> hiScores = new ArrayList<HiScore>();
		
		Cursor cursor = db.query(TABLE_HI_SCORE,columns,null, null, null, null, COL_HI_SCORE);
		
		cursor.moveToFirst();
		
		while( !cursor.isAfterLast())
		{
			HiScore score = new HiScore();
			score.setEmail(cursor.getString(0));
			score.setHiScore((int)cursor.getLong(1));
			score.setUserName(cursor.getString(2));
			hiScores.add(score);
			cursor.moveToNext();
		}
		cursor.close();
		return hiScores;
	}
	
}
