package reference.hashTable;

public class MultiHash<K> extends HashTable<K, Object>
{
	private int tier;

	public MultiHash(int tier)
	{
		super();
		this.tier = tier;
	}

	@Override
	protected int hash(K key)
	{

		return  (Math.abs(key.hashCode())+ tier) % dataArray.length;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void put(K key, Object o)
	{
		HashEntry<K, Object> entry = new HashEntry<K, Object>(key, o);
		int indexToPut = hash(key);

		HashEntry<K, Object> cursor = dataArray[indexToPut];
		if (cursor != null)        // if its not empty
		{
			if (!cursor.getKey().equals(key))        // if its not the same key
			{
				HashEntry<K, Object> childTbl = dataArray[indexToPut];
				if (cursor.getKey() != null)        // if its not a table
				{
					HashEntry<K, Object> temp = cursor;
					childTbl = dataArray[indexToPut] = new HashEntry<K, Object>(null, new MultiHash<K>(tier + 1));
					size--;
					((MultiHash<K>) childTbl.getElement()).put(temp.getKey(), temp.getElement());
				}
				((MultiHash<K>) childTbl.getElement()).put(key, o);
				size += ((MultiHash<K>) childTbl.getElement()).size();
			}
			else // if its same key
			{
				while (cursor.getNext() != null)
				{
					cursor = cursor.getNext();
				}
				cursor.setNext(entry);
			}
		}
		else // if its empty
		{
			dataArray[indexToPut] = entry;
			size++;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object get(K key)
	{
		int indexToGet = hash(key);
		HashEntry<K, Object> cursor = dataArray[indexToGet];
		if (cursor == null)     // if empty
		{
			return null;
		}
		else // if not empty
		{
			if (cursor.getKey() == null)     // if a table
			{
				return ((MultiHash<K>) cursor.getElement()).get(key);
			}
			else
			{
				return cursor;
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void remove(K key)
	{
		int indexToRemove = hash(key);
		HashEntry<K, Object> cursor = dataArray[indexToRemove];
		if (cursor != null)    // if not empty
		{
			if (cursor.getKey() != null)    // if not a table
			{
				cursor = null;
			}
			else // if its a table
			{
				((MultiHash<K>) cursor.getElement()).remove(key);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public String toString()
	{
		String res = "";
		for (HashEntry<K, Object> entry : dataArray)
		{
			if (entry != null)   // if it exists
			{
				HashEntry<K, Object> cursor = entry;
				if (cursor.getKey() != null)    // if not a table
				{
					while (cursor != null) // when there are more element
					{
						res += cursor.getKey() + " = " + cursor.getElement() + "\n";
						cursor = cursor.getNext();
					}
				}
				else // if its a table
				{
					System.out.println(tier);
					res += indent(tier) + ((MultiHash<K>) cursor.getElement()).toString();
				}
			}
		}
		return res;
	}

	private String indent(int times)
	{
		String str = "";
		for (int i = 0; i < times; i++)
		{
			str += "\t";
		}
		return str;
	}
}
