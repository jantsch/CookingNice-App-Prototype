package com.example.cookingnice;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
	
	public String userName;
	public String timeToPrepare;
	
	ArrayList<String> ingredients;
	ArrayList<String> steps;
	
	private int position;
	private int positionIng;
	public Recipe ()
	{
		userName = "Camila Araujo";
		timeToPrepare = "10h";
		ingredients = new ArrayList<String>();
		steps = new ArrayList<String>();
		
		ingredients.add("Ingredients: cup sour cream"); // fazer função que converte fração em String.
		ingredients.add("cup finely chopped cilantro");
		ingredients.add("1 green onion, chopped");
		ingredients.add("2 teaspoons lime juice");
		ingredients.add("salt");
		ingredients.add("pepper");
		
		
		steps.add("Steps: One.Mix mayonnaise, cheese and seasonings.");
		steps.add("Two.Spread mixture over chicken breast and place in baking dish.");
		steps.add("Three.Bake at 375°F for 45 minutes.");
		steps.add("This Recipe is Over.Thank you!");
	
		position = 0;
		positionIng = 0;
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
	public boolean hasNextIng()
	{
		if(ingredients.size()-1 < positionIng + 1)
		{
			return false;
		}
		else		
		return true;
	}
	
	public boolean hasPreviousStep()
	{
		if(steps.size()-1 > position - 1 && 0 <= position - 1)
		{
			return false;
		}
		else		
		return true;
	}
	public boolean hasPreviousIng()
	{
		if(ingredients.size()-1 > positionIng - 1 && 0 <= positionIng - 1)
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
	public int GetPositionIng()
	{
		return this.positionIng;
	}
	
	public void incPosition()
	{
		position++;
	}
	public void incPositionIng()
	{
		positionIng++;
	}
	
	public void decPosition()
	{
		position--;
	}
	public void decPositionIng()
	{
		positionIng--;
	}
	
	public String getStepByActualPosition()
	{
		return steps.get(position);
	}
	public String getPreviousStep()
	{
		return steps.get(position-1);	
	}
	
	public String getPreviousIng()
	{	
		return ingredients.get(positionIng-1);	
	}
	
	public String getNextStep()
	{
		return steps.get(position+1);
	}
	
	public String getNextIng()
	{
		return ingredients.get(positionIng+1);
	}
	
	public String getIngByActualPosition()
	{
		return ingredients.get(positionIng);
	}
	public void setIng()
	{
		this.positionIng = 0;
	}
	public void setPos()
	{
		this.position = 0;
	}
}
