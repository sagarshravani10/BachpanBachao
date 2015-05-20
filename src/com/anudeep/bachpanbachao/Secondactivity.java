package com.anudeep.bachpanbachao;


import java.io.File;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Secondactivity extends ActionBarActivity {

	private static String logtag="Bachpanbachaoo";
	private static int TAKE_PICTURE=1;
	private Uri imageUri;
	
	
	
	@Override
	    protected void onCreate(Bundle savedInstanceState)
		{
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.secondpage);
	        
	        Button startBtn = (Button) findViewById(R.id.sendEmail);
	        startBtn.setOnClickListener(new View.OnClickListener() 
	        {
	        	public void onClick(View view) 
	        	{
	        		sendEmail();
	        	}
	        }
	        );
	       /* Button FixLocation = (Button) findViewById(R.id.location);
	        FixLocation.setOnClickListener (new View.OnClickListener()
	        {
	        	gps = new GPSTracker(Secondactivity.this);
	        	public void onClick(View view)
	        	{
	        	double lat = gps.getLatitude();
	        	double longi = gps.getLongitude();
	        	}
	        });
	        		*/
	        
	       
				      
	        Button cambutton=(Button)findViewById(R.id.takephoto);
		    cambutton.setOnClickListener(cameraListener);
		    }
	        private OnClickListener cameraListener=new OnClickListener()
	        {
	        public void onClick(View v)
	        {
			takePhoto(v);
	        }
	        private void takePhoto(View v)
	        {
			Intent intent= new Intent("android.media.action.IMAGE_CAPTURE");
			File photo=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"pictures.jpeg");
			imageUri= Uri.fromFile(photo);
			intent.putExtra(MediaStore.EXTRA_MEDIA_ALBUM, imageUri);
			startActivityForResult(intent,TAKE_PICTURE);
	        }
	        };
			
	       protected void sendEmail() {
	       Log.i("Send email", "");
	       final EditText eText;
	       final EditText eText2;
	       eText = (EditText) findViewById(R.id.text1);
	       eText2 = (EditText) findViewById(R.id.text2);

	       String[] TO = {"medishettianudeep@gmail.com,sankethsarkaar@gmail.com"};
	       String[] CC = {"tecstasy2k14@gmail.com"};
	       Intent emailIntent = new Intent(Intent.ACTION_SEND);
	       emailIntent.setData(Uri.parse("mailto:"));
	       emailIntent.setType("text/plain");
	       emailIntent.setType("image/png");

	       String subject = eText.getText().toString();
	       String body = eText2.getText().toString();
	       emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
	       emailIntent.putExtra(Intent.EXTRA_CC, CC);
	       emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
	       emailIntent.putExtra(Intent.EXTRA_TEXT, body);
	       emailIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
	       Intent sendIntent = new Intent(Intent.ACTION_SEND);
	           
	       try {
	         startActivity(Intent.createChooser(emailIntent, "Send mail..."));
	         finish();
	         Log.i("Finished sending email...", "");
	           }
	       catch (android.content.ActivityNotFoundException ex)
	       {
	         Toast.makeText(Secondactivity.this, 
	         "There is no email client installed.", Toast.LENGTH_SHORT).show();
	      }
	   }
  
 }

