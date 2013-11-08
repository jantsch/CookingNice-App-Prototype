package com.example.cookingnice;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.TextView;

public class WelcomePageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_page);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome_page, menu);
		return true;
	}
	@Override

	public boolean onTouchEvent(MotionEvent event){ 
	        
	    int action = MotionEventCompat.getActionMasked(event);
	        
	    switch(action) {
	        case (MotionEvent.ACTION_DOWN) :
	    {		
	        	Intent trocatela = new
	        			Intent(WelcomePageActivity.this,MainActivity.class);
	        			WelcomePageActivity.this.startActivity(trocatela);
	        			WelcomePageActivity.this.finish();
	      	        	return true;
	    }
	        default : 
	            return super.onTouchEvent(event);
	    }      
	}

}
