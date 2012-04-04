package de.s2.di.robo;

import android.util.Log;


public class ObjectWithACounter
{
	private String text;

	private ICounter counter;

	public ObjectWithACounter(String text, ICounter counter)
	{
		super();
		this.text = text;
		this.counter = counter;
	}

	public void postCreate()
	{
		Log.i("springme", "objectWithCounter post create");
	}

	public void preDestroy()
	{
		Log.i("springme", "objectWithCounter pre destroy");
	}

	public String getText()
	{
		return text;
	}

	public ICounter getCounter()
	{
		return counter;
	}

}
