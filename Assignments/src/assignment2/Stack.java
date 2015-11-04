package assignment2;

public interface Stack<E>
{
	/** Get the top item of this stack without removing the item */
	public E peek();

	/** Get the top item, removing it from this stack */
	public E pop();

	/** Push a new item onto this stack. The new item may be the null reference. */
	public void push(E element);

	/** Determine whether this stack is empty. */
	public boolean isEmpty();

	/** Return the number of items in this stack. */
	public int size();
}
