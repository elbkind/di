package de.s2.di.springme;

import android.util.Log;


public class ObjectWithACounter
{
	private String text;

	private Counter counter;

	public ObjectWithACounter(String text, Counter counter)
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

	public Counter getCounter()
	{
		return counter;
	}

}
