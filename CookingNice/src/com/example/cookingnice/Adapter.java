package com.example.cookingnice;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter extends BaseAdapter{
	private Context context;
    private List<Recipe> recipeList;
    
    public Adapter(Context context, List<Recipe> recipeList){
        this.context = context;
        this.recipeList = recipeList;
    }
    
    @Override
    public int getCount() {
        return recipeList.size();
    }
 
    @Override
    public Object getItem(int position) {
        return recipeList.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Recupera o estado da posição atual
        Recipe oneRecipe = recipeList.get(position);
        
        // Cria uma instância do layout XML para os objetos correspondentes
        // na View
        LayoutInflater inflater = (LayoutInflater)
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_lay, null);
        
        
        TextView textState = (TextView)view.findViewById(R.id.textName);
        textState.setText(oneRecipe.Name);
        
      
        TextView textCapital = (TextView)view.findViewById(R.id.textUser);
        textCapital.setText(oneRecipe.senderName);
        
        
        TextView textArea = (TextView)view.findViewById(R.id.textTime);
        textArea.setText(oneRecipe.timeToPrepare);
        
    
        ImageView img = (ImageView)view.findViewById(R.id.imageState);
        img.setImageResource(oneRecipe.Image);
 
        return view;
    }
}
