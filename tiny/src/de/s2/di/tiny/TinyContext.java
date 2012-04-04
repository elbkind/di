package de.s2.di.tiny;

import com.h2.org.springframework.beans.factory.IResourceManager;
import com.h2.util.resource.android.AndroidResourceManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import android.util.Log;

import android.app.Application;


public class TinyContext extends Application
{
	private static final String TAG = "springme";

	private static TinyContext instance;

	private static ClassPathXmlApplicationContext context;
	
	public TinyContext()
	{
		if(instance == null) // bug in tiny spring
		{
			instance = this;	
		}
		
	}

	@Override
	public void onCreate()
	{
		super.onCreate();
		Log.i(TAG, "app onCreate");
		 
      final AndroidResourceManager resManager = new AndroidResourceManager();
      resManager.setAssetManager(getAssets());

      context = new ClassPathXmlApplicationContext(
            "applicationContext.xml") {
         @Override
         public IResourceManager getResorceManager() {
            return resManager;
         }
      };
	}

	@Override
	public void onTerminate()
	{
		Log.i(TAG, "app onTerminate");
		super.onTerminate();
	}

	public static TinyContext getInstance()
	{
		return instance;
	}

	public Counter getCounter()
	{
		return (Counter) context.getBean("singletonCounter", Counter.class);
//		return context.getBean(Counter.class);
	}

	public Counter getNewCounter()
	{
		return context.getBean("tempCounter", Counter.class);
	}
	
	public ObjectWithACounter getObjectWithACounter()
	{
		return context.getBean(ObjectWithACounter.class);
	}	
}
