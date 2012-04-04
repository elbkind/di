package de.s2.di.robo;

import com.google.inject.Module;
import java.util.List;

import roboguice.application.RoboApplication;


public class MyApplication extends RoboApplication
{

	@Override
	protected void addApplicationModules(List<Module> modules)
	{
		modules.add(new MyRoboModule());
	}

}
