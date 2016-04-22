/**
 * CS 241: Data Structures and Algorithms II
 * Professor: Edwin Rodriguez
 *
 * Programming Assignment #1
 *
 * Heaps.
 *
 * Dave Luk
 */

package cs241.A1;

public class Customer implements Comparable<Customer>
{
	public enum Priority{
		DEFAULT, FAMILY_W_CHILDREN, LARGE_GROUPS, VETERAN, SENIOR, ADVANCE_CALL, VIP
	}
	
	private String name;
	private Priority priority;
	
	public Customer(String name, Priority p)
	{
		this.setName(name);
		priority = p;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Priority getPriority()
	{
		return priority;
	}

	public void setPriority(Priority priority)
	{
		this.priority = priority;
	}

	@Override
	public int compareTo(Customer o)
	{
		return priority.compareTo(o.priority);
	}
	
	@Override
	public String toString()
	{
		return name + " || " + priority.name();
	}
}
