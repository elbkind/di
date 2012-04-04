package de.s2.di.tiny;

public class Counter
{
	private static int count = 0;

	private int id;

	private synchronized static int nextId()
	{
		return count++;
	}

	public Counter()
	{
		id = nextId();
	}

	public int getId()
	{
		return id;
	}

}
