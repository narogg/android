package com.example.generatorlutrije;

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends Activity {

	  private RadioGroup radioGroupId;
	  private Button button;
	  
	  public final static String EXTRA_MESSAGE = "com.example.generatorlutrije.MESSAGE";//com.example.generatorlutrije.MESSAGE
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		addButtonListener();
	}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

	public void addButtonListener() {
		
		radioGroupId = (RadioGroup) findViewById(R.id.radioLotoGrupa);

		button = (Button) findViewById(R.id.button);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
								
				final TextView text = (TextView) findViewById(R.id.textView1);
				text.setTextSize(36);

			    //Radnja ovisna o tome koji je radio button ozna�en
				switch (radioGroupId.getCheckedRadioButtonId()) {
			    
			    case R.id.radio_6od45:
			    	
			    	//Isprazni textview1
			    	text.setText(null);
			    	//Definiranje liste koja �e sadr�avati listu brojeva
			        ArrayList<Integer> sestOd45 = new ArrayList<Integer>();
			        for(int i = 1; i < 45; i++)
			        {
			        	sestOd45.add(i+1);
			        }
			    
			        //�elimo da brojevi budu nasumi�no pomije�ani
			        Collections.shuffle(sestOd45);
			        
			      //Izvrtit �e �est brojeva iz kolekcije i prikva�iti ih na textView1
			        for(int j =0; j < 6; j++)
			        {
			        	text.append(String.valueOf(sestOd45.get(j) + " "));
			        }
		 				    	
			    	break;
			    	
			    case R.id.radio_radio7do39:
			    	
			    	//Isprazni textview1
			    	text.setText(null);
			    	//Definiranje liste koja �e sadr�avati listu brojeva
			        ArrayList<Integer> sedamOd39 = new ArrayList<Integer>();
			        for(int i = 1; i < 39; i++)
			        {
			        	sedamOd39.add(i+1);
			        }
			    
			      //�elimo da brojevi budu nasumi�no pomije�ani
			        Collections.shuffle(sedamOd39);
			        
			        //Izvrtit �e �est brojeva iz kolekcije i prikva�iti ih na textView1
			        for(int j =0; j < 7; j++)
			        {
			        	text.append(String.valueOf(sedamOd39.get(j) + " "));
			        }
			    	
			    	break;
			    }
			}
		});
	  }
	
	//Metode koje se odnose na tutorial s developer.android.com/trainig/basics
	
	/** Called when the user clicks the Send button */
	public void sendMessage(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		
		startActivity(intent);
	}
	
	
	
	
	}//kraj klase
