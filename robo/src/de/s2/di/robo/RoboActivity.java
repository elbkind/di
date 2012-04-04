package de.s2.di.robo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.inject.Inject;
import roboguice.inject.ContextScoped;
import roboguice.inject.InjectView;


public class RoboActivity extends roboguice.activity.RoboActivity
{
	private static final String TAG = "robo";
	
	@Inject
	private Counter changing;
	
	@InjectView(R.id.button_quit)
	private Button quit;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		quit.setOnClickListener(new View.OnClickListener(){

			public void onClick(View v)
			{
				Toast.makeText(RoboActivity.this, "Shutting down", 2000);
				try
				{
					Thread.sleep(3000);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				
				finish();
			}
			
		});
		
		logState("onCreate");
	}
	
	@Override
	protected void onPause()
	{
		logState("onPause");
		super.onPause();
	}

	@Override
	protected void onResume()
	{
		logState("onResume");
		super.onResume();
	}

	@Override
	protected void onStart()
	{
		logState("onStart");
		super.onStart();
	}

	@Override
	protected void onStop()
	{
		logState("onStop");
		super.onStop();
	}
	
	public void logState(String event)
	{		
		String msg =
			String.format("activity state [%s] counter %s\n", event, changing.getId());
		Log.i(TAG, msg);
		Toast.makeText(this, msg, 2000).show();
	}
}