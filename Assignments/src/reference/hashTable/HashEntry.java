package reference.hashTable;

public class HashEntry<K, E>
{

	private K	key;
	private E	element;

	private HashEntry<K, E> next;

	public HashEntry(K key, E element)
	{
		this.key = key;
		this.element = element;
	}

	public K getKey()
	{
		return key;
	}

	public void setKey(K key)
	{
		this.key = key;
	}

	public E getElement()
	{
		return element;
	}

	public void setElement(E element)
	{
		this.element = element;
	}

	public HashEntry<K, E> getNext()
	{
		return next;
	}

	public void setNext(HashEntry<K, E> next)
	{
		this.next = next;
	}
}
