package com.example.ocrdemo;

import com.polus.util.ReuseableClass;

import edu.sfsu.cs.orange.ocr.CaptureActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {


	TextView textViewResult;
	String preffix = "";
	String OCRresult = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actvity_main);

		textViewResult = (TextView) findViewById(R.id.textViewResult);
		textViewResult.setText("");

		preffix = ReuseableClass.getFromPreference("prefixValue", MainActivity.this);
		OCRresult  = ReuseableClass.getFromPreference("OCRresult", MainActivity.this);

		Log.e("Tag ", "preffix "+ preffix);
		Log.e("tag ", "suffix "+ OCRresult);


		if(!OCRresult.equalsIgnoreCase("") && !preffix.equalsIgnoreCase("") )
		{
			textViewResult.setText(preffix + OCRresult + ReuseableClass.storedSuffix);
			ReuseableClass.saveInPreference("OCRresult", "", this);
			ReuseableClass.saveInPreference("prefixValue","", this);
		}
	}

	public void openActivityA(View v)
	{
		Intent i = new Intent(MainActivity.this,AcctivtyA.class);
		finish();
		startActivity(i);

	}

	public void openScanner(View v)
	{
		
		if(!ReuseableClass.getFromPreference("prefixValue", MainActivity.this).equalsIgnoreCase(""))
		{
		Intent i = new Intent(MainActivity.this,CaptureActivity.class);
		finish();
		startActivity(i);
		}
		else
		{
			Toast.makeText(this, "Please enter your PREFIX first..!", Toast.LENGTH_LONG).show();
		}
	}
	
}
