package com.example.speech;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;



public class MainActivity extends Activity {


	Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	}

		public void funcao(View view)
		{
			Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
			 intent = new Intent(this, voice.class);
			startService(intent);
		}
		public void funcao2(View view)
		{
		stopService(intent);
		}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
