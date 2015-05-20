package com.anudeep.bachpanbachao;




import android.support.v7.app.ActionBarActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

	  @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        
	        Button gotoapp = (Button) findViewById(R.id.gotoapp);
	        gotoapp.setOnClickListener(new OnClickListener(){
	                                      public void onClick(View v) {
	                                          Intent intent = new Intent(MainActivity.this,Secondactivity.class);
	                                          startActivity(intent);
	                                      }
	                                  }


	        );

	  }
    		  
  
 }

