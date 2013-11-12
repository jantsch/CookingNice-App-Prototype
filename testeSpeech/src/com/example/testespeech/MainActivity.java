package com.example.testespeech;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import android.util.Log;



public class MainActivity extends Activity  
{

   private TextView mText;
   private SpeechRecognizer sr;
   private static final String TAG = "MyStt3Activity";
   @Override
   public void onCreate(Bundle savedInstanceState) 
   {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //Button speakButton = (Button) findViewById(R.id.btn_speak);     
            mText = (TextView) findViewById(R.id.textView1);     
            //speakButton.setOnClickListener(this);
            sr = SpeechRecognizer.createSpeechRecognizer(this);       
            sr.setRecognitionListener(new listener());        

            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);        
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"en-US");
            //intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,"voice.recognition.test");
            //intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,5); 
                 sr.startListening(intent);
                 

   }

   class listener implements RecognitionListener          
   {
            public void onReadyForSpeech(Bundle params)
            {
                     Log.d(TAG, "onReadyForSpeech");
            }
            public void onBeginningOfSpeech()
            {
                     Log.d(TAG, "onBeginningOfSpeech");
            }
            public void onRmsChanged(float rmsdB)
            {
                     Log.d(TAG, "onRmsChanged");
            }
            public void onBufferReceived(byte[] buffer)
            {
                     Log.d(TAG, "onBufferReceived");
            }
            public void onEndOfSpeech()
            {
                     Log.d(TAG, "onEndofSpeech");
            }
            public void onError(int error)
            {	/*	erros e códigos
            		ERROR_NETWORK_TIMEOUT
					ERROR_NETWORK
					ERROR_AUDIO
					ERROR_SERVER
					ERROR_CLIENT
					ERROR_SPEECH_TIMEOUT
					ERROR_NO_MATCH
					ERROR_RECOGNIZER_BUSY
					ERROR_INSUFFICIENT_PERMISSIONS
				*/
                     
            	Log.d(TAG,  "error " +  error);
                     Toast t = Toast.makeText(getApplicationContext(),
         					"Please, turn on your Wi-fi or 3G",
         					Toast.LENGTH_SHORT);
         		t.show();
         		mText.setText("error: "+ error); 
                    
            }
            public void onResults(Bundle results)                   
            {
                     String str = new String();
                     Log.d(TAG, "onResults " + results);
                     ArrayList data = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                     for (int i = 0; i < data.size(); i++)
                     {
                               Log.d(TAG, "result " + data.get(i));
                               str += data.get(i);
                     }
                     mText.setText("results: "+String.valueOf(data)); 
                     
            }
            public void onPartialResults(Bundle partialResults)
            {
                     Log.d(TAG, "onPartialResults");
            }
            public void onEvent(int eventType, Bundle params)
            {
                     Log.d(TAG, "onEvent " + eventType);
            }
   }
   
}