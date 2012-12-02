package org.asptics.aboutproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity2 extends Activity {

	TextView textView = null;
	private final static String TAG="MainActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String version = null;
		try {
			 version = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
			
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textView = (TextView) findViewById(R.id.hello);
		textView.setText(version);
		Log.i(TAG, "onCreate");


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	protected void onStart(){
		super.onStart();
		Log.i(TAG, "onStart");
	}
	protected void onRestart(){
		super.onRestart();
		Log.i(TAG, "onRestart");
	}
	protected void onResume(){
		super.onResume();
		Log.i(TAG, "onResume");
	}
	protected void onPause()
	{
		super.onPause();
		Log.i(TAG, "onPause");
	}
	protected void onStop(){
		super.onPause();
		Log.i(TAG, "onStop");
	}
	protected void onDestroy(){
		super.onDestroy();
		Log.i(TAG, "onDestroy");
	}

}
