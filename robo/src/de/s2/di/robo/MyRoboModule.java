package de.s2.di.robo;

import com.google.inject.AbstractModule;

public class MyRoboModule extends AbstractModule
{

	@Override
	protected void configure()
	{
		bind(ICounter.class).to(Counter.class);
		
	}
}
