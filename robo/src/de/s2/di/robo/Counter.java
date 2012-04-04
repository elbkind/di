package de.s2.di.robo;

public class Counter implements ICounter
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

	/* (non-Javadoc)
	 * @see de.s2.di.robo.ICounter#getId()
	 */
	public int getId()
	{
		return id;
	}

}
