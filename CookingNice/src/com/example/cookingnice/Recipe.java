package com.example.cookingnice;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
	
	private String userName;
	private String timeToPrepare;
	
	ArrayList<String> ingredients;
	ArrayList<String> steps;
	
	private int position;
	
	public Recipe ()
	{
		userName = "Camila Araujo";
		timeToPrepare = "10h";
		ingredients = new ArrayList<String>();
		steps = new ArrayList<String>();
		
		ingredients.add("um ou mais pacotes de massa");
		ingredients.add("300 gramas de queijo mussarela");
		ingredients.add("300 gramas de presunto magro");
		ingredients.add("Parmesão ralado a gosto");
		ingredients.add("quatro dentes de alho picadinhos");
		
		steps.add("One.Mix mayonnaise, cheese and seasonings.");
		steps.add("Two.Spread mixture over chicken breast and place in baking dish.");
		steps.add("Three.Bake at 375°F for 45 minutes.");
		steps.add("This Recipe is Over.Thank you!");
	
		position = 0;
	}
	
	
	public boolean hasNextStep()
	{
		if(steps.size()-1 < position + 1)
		{
			return false;
		}
		else		
		return true;
	}
	
	public boolean hasPreviousStep()
	{
		if(steps.size()-1 < position - 1)
		{
			return false;
		}
		else		
		return true;
	}
	
	public int GetPosition()
	{
		return this.position;
	}
	
	public void incPosition()
	{
		position++;
	}
	
	public void decPosition()
	{
		position--;
	}
	
	public String getStepByActualPosition()
	{
		return steps.get(position);
	}
	public String getPreviousStep()
	{
		return steps.get(position-1);	
	}
	public String getNextStep()
	{
		return steps.get(position+1);
	}
	
	
}
