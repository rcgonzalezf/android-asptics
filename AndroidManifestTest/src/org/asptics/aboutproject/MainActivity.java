package org.asptics.aboutproject;

import android.app.Activity;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView textView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String version = null;
		try {
			 version = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
			
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		textView = (TextView) findViewById(R.id.hello);
		textView.setText(version);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	

}
