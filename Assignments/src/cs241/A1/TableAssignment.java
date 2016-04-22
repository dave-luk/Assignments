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

public class TableAssignment
{
	private Heap<Customer> customerList;
	
	public TableAssignment()
	{
		customerList = new Heap<>(Heap.Mode.MAX_HEAP);
	}
	
	public TableAssignment(Customer... c)
	{
		customerList = new Heap<>(Heap.Mode.MAX_HEAP);
		customerList.fromArray(c);
	}
	
	public void addCustomer(Customer c)
	{
		customerList.add(c);
	}
	
	public Customer next()
	{
		return customerList.remove();
	}
	
	public boolean isEmpty()
	{
		return (size() == 0);
	}
	
	public int size()
	{
		return customerList.getSize();
	}
}
