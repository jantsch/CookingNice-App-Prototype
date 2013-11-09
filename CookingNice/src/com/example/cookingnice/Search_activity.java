package com.example.cookingnice;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Search_activity extends Activity {

	TextView firstRecipe;
	TextView secondRecipe;
	TextView thirdRecipe;
	EditText desiredRecipe;
	
	Recipe oneRecipe;
	Recipe twoRecipe;
	Recipe threeRecipe;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_activity);
		
		oneRecipe = new Recipe("Massa Quatro Queijos","Adriano"," 10 minutes");
		twoRecipe = new Recipe("Massa Carbonara","Luiza","30 minutes");
		threeRecipe = new Recipe("Massa Ao Pesto","Jéssica","1h");
		
		firstRecipe = (TextView) findViewById(R.id.textView2);
		secondRecipe = (TextView) findViewById(R.id.textView3);
		thirdRecipe = (TextView) findViewById(R.id.textView4);
		desiredRecipe = (EditText) findViewById(R.id.editText1);
		
	}

	public void search(View view)
	{
		if(desiredRecipe.getText().toString()=="")
		{//voz
		}
		else
		{	String word = desiredRecipe.getText().toString().toLowerCase();
			if(word.equals("massa")== true)
			{
				firstRecipe.setText(oneRecipe.Name);	
				secondRecipe.setText(twoRecipe.Name);	
				thirdRecipe.setText(threeRecipe.Name);			
			}
			
		}
	}
	public void openSpeakActivityOne(View view)
	{
		Intent nova = new Intent(this, MainActivity.class);
		nova.putExtra("Recipe", oneRecipe);
		this.startActivity(nova);
		this.finish();
	}
	public void openSpeakActivityTwo(View view)
	{
		Intent nova = new Intent(this, MainActivity.class);
		nova.putExtra("Recipe", twoRecipe);
		this.startActivity(nova);
		this.finish();
	
	}
	public void openSpeakActivityThree(View view)
	{
		Intent nova = new Intent(this, MainActivity.class);
		nova.putExtra("Recipe", threeRecipe);
		this.startActivity(nova);
		this.finish();
	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_activity, menu);
		return true;
	}

}
