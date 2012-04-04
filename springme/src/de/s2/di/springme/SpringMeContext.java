package de.s2.di.springme;

import android.util.Log;

import android.app.Application;


public class SpringMeContext extends Application
{
	private static final String TAG = "springme";

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
		Log.i(TAG, "app onCreate");
		context = new BeanFactory();
	}

	@Override
	public void onTerminate()
	{
		Log.i(TAG, "app onTerminate");
		context.stop();
		super.onTerminate();
	}

	public static SpringMeContext getInstance()
	{
		return instance;
	}

	public Counter getCounter()
	{
		return (Counter) context.getBean("singletonCounter");
	}

	public Counter getNewCounter()
	{
		return (Counter) context.getBean("tempCounter");
	}
	
	public ObjectWithACounter getObjectWithACounter()
	{
		return (ObjectWithACounter) context.getBean("complexType");
	}	
}
