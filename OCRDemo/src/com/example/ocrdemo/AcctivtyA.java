package com.example.ocrdemo;

import com.polus.util.ReuseableClass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AcctivtyA extends Activity{

	EditText editTextPrefix;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_a);
		editTextPrefix = (EditText) findViewById(R.id.editTextPrefix);
	}

	public void savePrefix(View v)
	{
		if(!editTextPrefix.getText().toString().trim().equalsIgnoreCase(""))
		{
			ReuseableClass.saveInPreference("prefixValue",editTextPrefix.getText().toString(), AcctivtyA.this);
			Toast.makeText(this, "Thanks for saving your PREFIX...! ", Toast.LENGTH_LONG).show();
		}
		
		else
		{
			Toast.makeText(this, "Please enter PREFIX", Toast.LENGTH_LONG).show();
		}

	}

	public void backPress(View v)
	{
		Intent i = new Intent(AcctivtyA.this, MainActivity.class);
		finish();
		startActivity(i);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		Intent i = new Intent(AcctivtyA.this, MainActivity.class);
		finish();
		startActivity(i);
	}
}
