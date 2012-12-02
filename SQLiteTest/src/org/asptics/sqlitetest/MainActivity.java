package org.asptics.sqlitetest;

import java.util.List;

import org.asptics.sqlitetest.model.HiScore;
import org.asptics.sqlitetest.model.sqlite.HiScoreDAO;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	private static final String TAG="SQLTest.MainActivity";
	private HiScoreDAO hiScoreDAO = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		hiScoreDAO = new HiScoreDAO(this);
		hiScoreDAO.openDB(false);
		
		HiScore score1 = new HiScore("asptics@email.com",100,"NewBie");
		HiScore score2 = new HiScore("troll@soy132.com",10008000,"trololo");
		
		hiScoreDAO.insertHiScore(score1);
		hiScoreDAO.insertHiScore(score2);
		
		List<HiScore> hiScores =		hiScoreDAO.getHiScores();
		
		for(HiScore s : hiScores)
		{
			Log.i(TAG, s.toString());
		}
		
		hiScoreDAO.deleteHiScore(score1);
		
		hiScores =		hiScoreDAO.getHiScores();
		Log.i(TAG, "Despues de borrar el primer row.");
		
		for(HiScore s : hiScores)
		{
			Log.i(TAG, s.toString());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
