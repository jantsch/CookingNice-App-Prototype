package com.example.cookingnice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Search_activity extends Activity implements OnItemClickListener {

	
	EditText desiredRecipe;	
	ListView lv;
	
	
	ArrayList<Recipe> recipes;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_activity);
		
		
		Recipe oneRecipe = new Recipe("Pasta Four Cheese","Adriano"," 10 minutes",R.drawable.maca);
		Recipe twoRecipe = new Recipe("Bavette","Luiza","30 minutes",R.drawable.maca2);
		Recipe threeRecipe = new Recipe("Ditalini","J�ssica","1 hora",R.drawable.maca3);
		Recipe fourthrecipe = new Recipe("Funghi","Jos�"," 10 minutes",R.drawable.maca4);
		Recipe fifthRecipe = new Recipe("Nhoque","Pedro","30 minutes",R.drawable.maca5);
		Recipe sixthRecipe = new Recipe("Macarr�o","Maria","2 horas",R.drawable.maca6);
		recipes = new ArrayList<Recipe>();
		recipes.add(oneRecipe);
		recipes.add(twoRecipe);
		recipes.add(threeRecipe);
		recipes.add(fourthrecipe);
		recipes.add(fifthRecipe);
		recipes.add(sixthRecipe);
		
		
		
		desiredRecipe = (EditText) findViewById(R.id.editText1);
		lv = (ListView) findViewById(R.id.listView1);
        
		lv.setOnItemClickListener(this);
			
	}
	
	@Override
	     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	        
          // Obt�m os detalhes do Estado selecionado
        	Recipe oneRecipe = recipes.get(position);
	        
	         // Exibe a Activity com os detalhes dos Estados
	        Intent intent = new Intent(this, MainActivity.class);
	          Bundle params = new Bundle();
	          params.putSerializable("Recipe",oneRecipe);
	          intent.putExtras(params);
	         
	        startActivity(intent);
      }
	  
  

    


  
 
	public void search(View view)
	{
		
			String word = desiredRecipe.getText().toString().toLowerCase();
			if(word.equals("pasta")== true)
			{	
				
		        Adapter oneA = new Adapter(this,recipes);
		        lv.setAdapter(oneA);			
				
			
			}
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_activity, menu);
		return true;
	}

}
