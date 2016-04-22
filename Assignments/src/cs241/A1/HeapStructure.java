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

public interface HeapStructure<T extends Comparable<T>>
{
	public void add(T value);

	public T[] toArray(T[] array);

	public T remove();

	public void fromArray(T[] array);

	public T[] getSortedContents(T[] array);

}