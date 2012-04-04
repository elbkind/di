package de.s2.di.tiny;

import android.view.View;

import android.widget.Button;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class TinyActivity extends Activity {

	private static final String TAG = "tiny spring";
	
	private Counter fixed;

	private Counter changing;

	private ObjectWithACounter objectWithACounter;

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
	logState("onCreate");
		
	Button quit = (Button) this.findViewById(R.id.button_quit);
	quit.setOnClickListener(new View.OnClickListener(){

		public void onClick(View v)
		{
			Toast.makeText(TinyActivity.this, "Shutting down", 2000);
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
		fixed = TinyContext.getInstance().getCounter();
		objectWithACounter = TinyContext.getInstance().getObjectWithACounter();
		changing = TinyContext.getInstance().getNewCounter();
		
		String obj = objectWithACounter.getCounter() != null? String.valueOf(objectWithACounter.getCounter().getId()) : "Kein Wert";
		String msg =
			String.format("activity state [%s] fixed %s\tchanging %s\tobject %s\n", event, fixed.getId(), changing.getId(),
				obj);
		Log.i(TAG, msg);
		Toast.makeText(this, msg, 2000).show();
	}
}
