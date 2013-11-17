package com.example.cookingnice;

import java.util.ArrayList;
import java.util.Locale;

//import com.androidhive.texttospeech.R;



import android.os.Bundle;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener {

	protected static final int RESULT_SPEECH = 1;


	private TextToSpeech tts;
	private Button btnSpeak;
	private TextView myText;
	private Recipe oneRecipe;
	private boolean isFirstTime;
	private Button btnClose;
	private TextView speech;
	
	private int IngOrStep; // Ingrediente = 0  -----Step = 1;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		

		Intent intent = getIntent();
		oneRecipe = (Recipe) intent.getSerializableExtra("Recipe");	
		tts = new TextToSpeech(this, this);
		
		myText = (TextView) findViewById(R.id.textView1);
		speech = (TextView) findViewById(R.id.txt_speech);
		btnSpeak = (Button) findViewById(R.id.button2); 
		btnClose = (Button) findViewById(R.id.close_button); 
		
		//seta textos iniciais
		
	    myText.setText(oneRecipe.Name);
	    isFirstTime = true;	    
	    IngOrStep =0;
	}

	public void actionButtonSpeak(View view) {

		// Ação que pega voz do usuário
		Intent intent = new Intent(
				RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US");

		try {
			startActivityForResult(intent, RESULT_SPEECH);
			speech.setText("");
		} catch (ActivityNotFoundException a) {
			Toast t = Toast.makeText(getApplicationContext(),
					"Ops! Your device doesn't support Speech to Text",
					Toast.LENGTH_SHORT);
			t.show();
		}
	}
 
	public void actionButtonSpeakLabel(View view) {
		// Sua Ação
		if(IngOrStep ==0)
		{
			if(oneRecipe.hasNextIng() == true && isFirstTime == false)
			{
				oneRecipe.incPositionIng();
			    myText.setText(oneRecipe.getIngByActualPosition());
			}		
			speakOut(); 
			isFirstTime= false;
		
			
		}
		else
		{
			if(oneRecipe.hasNextStep() == true && isFirstTime == false)
			{
				oneRecipe.incPosition();
			    myText.setText(oneRecipe.getStepByActualPosition());
			}		
			speakOut(); 
			isFirstTime= false;
		}
	}

	public void actionFinish(View view)
	{
		finish(); 
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}
	
	@Override
	public void onDestroy() {
		// Don't forget to shutdown!
		if (tts != null) {
			tts.stop();
			tts.shutdown();
		}
		super.onDestroy();
	}

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		
		
		if (status == TextToSpeech.SUCCESS) {

			int result = tts.setLanguage(Locale.US);

			// tts.setPitch(5); // set pitch level

			 tts.setSpeechRate(1); // set speech speed rate

			if (result == TextToSpeech.LANG_MISSING_DATA
					|| result == TextToSpeech.LANG_NOT_SUPPORTED) {
				Log.e("TTS", "Language is not supported");
			} else {
				//btnSpeak.setEnabled(true);
				//speakOut();
			}

		} else {
			Log.e("TTS", "Initilization Failed");
		}

	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		switch (requestCode) {
		case RESULT_SPEECH: {
			if (resultCode == RESULT_OK && null != data) {

				ArrayList<String> text = data
						.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
				// Aqui tá o texto capturado pela fala
				
				ManipulateSpeech(text.get(0));
				speech.setText(text.get(0));
			}
			break;
		}

		}
	}
	
	private void ManipulateSpeech(String command)
	{
	switch(IngOrStep)
	{
	case 0:
	{	
		if(command.equals("done")||command.equals("next")||command.equals("dan")||command.equals("the") ||command.equals("then")||command.equals("does")||command.equals("does it"))
		{
			if(oneRecipe.hasNextIng() == true && isFirstTime == false)
			{
				oneRecipe.incPositionIng();
			    myText.setText(oneRecipe.getIngByActualPosition());
			}
			if(oneRecipe.hasNextIng() == false){
				IngOrStep = 1;
				myText.setText(oneRecipe.getStepByActualPosition());		
			}
			
			speakOut(); 
			isFirstTime = false;
		}
	
		if(command.equals("back")||command.equals("beck")||command.equals("before"))
		{   
			if(oneRecipe.hasPreviousIng() == false)
			{
				oneRecipe.decPositionIng();
			    myText.setText(oneRecipe.getIngByActualPosition());
			}		
			speakOut(); 			
		}
	
		if(command.equals("repeat")||command.equals("again"))
		{   
			speakOut(); 		
		}
		if(command.equals("finish"))
		{
			tts.speak("Are you Sure?", TextToSpeech.QUEUE_FLUSH, null);
			
		}
		if(command.equals("ingredients"))
		{
			IngOrStep = 0;
			oneRecipe.setIng();
			myText.setText(oneRecipe.getIngByActualPosition());
			speakOut();
		}
		if(command.equals("steps"))
		{
			IngOrStep = 1;
			isFirstTime = false;
			myText.setText(oneRecipe.getStepByActualPosition());
			speakOut();
			
		}
		if(command.equals("start")||command.equals("star")||command.equals("beginning"))
		{
			oneRecipe.setIng();
			myText.setText(oneRecipe.getIngByActualPosition());
			speakOut();
			
		}
		break;
	}	

	
	case 1:
		{
			if(command.equals("done")||command.equals("next")||command.equals("dan")||command.equals("the") ||command.equals("then")||command.equals("does")||command.equals("does it"))
			{
				if(oneRecipe.hasNextStep() == true && isFirstTime == false)
				{
					oneRecipe.incPosition();
				    myText.setText(oneRecipe.getStepByActualPosition());
				}		
				speakOut(); 
				isFirstTime= false;
			} 
		
			if(command.equals("back")||command.equals("beck")||command.equals("before"))
			{   
				if(oneRecipe.hasPreviousStep() == false)
				{
					oneRecipe.decPosition();
				    myText.setText(oneRecipe.getStepByActualPosition());
				}		
				speakOut(); 		
			}
		
			if(command.equals("repeat")||command.equals("again"))
			{   
				speakOut(); 		
			}
			if(command.equals("finish"))
			{
				tts.speak("Are you Sure?", TextToSpeech.QUEUE_FLUSH, null);
				
			}
			if(command.equals("ingredients"))
			{
				IngOrStep = 0;
				oneRecipe.setIng();
				myText.setText(oneRecipe.getIngByActualPosition());
				speakOut();
			}
			if(command.equals("start")||command.equals("star")||command.equals("beginning"))
			{
				oneRecipe.setPos();
				myText.setText(oneRecipe.getStepByActualPosition());
				speakOut();
				
			}
			break;
		}	
	}
		
	}

	private void speakOut() {

		String text = myText.getText().toString();

		tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
	
	}
		
}
