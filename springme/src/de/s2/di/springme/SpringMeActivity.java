package de.s2.di.springme;

import android.view.View;

import android.widget.Button;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


public class SpringMeActivity extends Activity
{
	private static final String TAG = "springme";

	private Counter fixed;

	private Counter changing;

	private ObjectWithACounter objectWithACounter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		logState("onCreate");
		
		Button quit = (Button) this.findViewById(R.id.button_quit);
		quit.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v)
			{
				Toast.makeText(SpringMeActivity.this, "Shutting down", 2000);
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
		fixed = SpringMeContext.getInstance().getCounter();
		objectWithACounter = SpringMeContext.getInstance().getObjectWithACounter();
		changing = SpringMeContext.getInstance().getNewCounter();

		String msg =
			String.format("activity state [%s] fixed %s\tchanging %s\tobject %s\n", event, fixed.getId(), changing.getId(),
				objectWithACounter.getCounter().getId());
		Log.i(TAG, msg);
		Toast.makeText(this, msg, 2000).show();
	}
}
