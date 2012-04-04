package de.s2.di.tiny;

import android.util.Log;


public class ObjectWithACounter
{
	private String text;

	private Counter counter;

	public void postCreate()
	{
		Log.i("springme", "objectWithCounter post create");
	}

	public void preDestroy()
	{
		Log.i("springme", "objectWithCounter pre destroy");
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public void setCounter(Counter counter)
	{
		this.counter = counter;
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
