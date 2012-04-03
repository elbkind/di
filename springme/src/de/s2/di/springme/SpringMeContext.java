package de.s2.di.springme;

import android.app.Application;


public class SpringMeContext extends Application
{
	private BeanFactory context;

	private static SpringMeContext instance;

	public SpringMeContext()
	{
		instance = this;
	}

	@Override
	public void onCreate()
	{
		super.onCreate();
		context = new BeanFactory();
	}

	public static SpringMeContext getInstance()
	{
		return instance;
	}
}
