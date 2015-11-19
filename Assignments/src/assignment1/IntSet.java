package assignment1;

import reference.node.Node;

public class IntSet
{

	private Node<Integer>	head;
	private Node<Integer>	tail;
	private int				size;

	public IntSet(int[] values)
	{
		size = 0;
		for (int v : values)
		{
			Node<Integer> newNode = new Node<Integer>(v);
			if (head == null)
			{
				head = newNode;
			}
			else
			{
				tail.setNextNode(newNode);
			}
			tail = newNode;
			size++;
		}
	}

	public IntSet(IntSet s)
	{
		IntSet set = deepCopy(s);
		head = set.head;
		tail = set.tail;
		size = set.size;
	}

	public IntSet()
	{
		head = null;
		tail = null;
		size = 0;
	}

	public boolean contain(int value)
	{
		if (size == 0) { return false; }
		Node<Integer> cursor = head;
		if (tail.getElement().intValue() == value) { return true; }
		do
		{
			if (cursor.getElement().intValue() == value) { return true; }
			if (cursor.hasNext())
			{
				cursor = cursor.getNextNode();
			}
		}
		while (cursor.hasNext());
		return false;
	}

	public void remove(int value)
	{
		if (size == 0 || ((head.getElement().intValue() != value) && size == 1)
		        || ((head.getElement().intValue() != value) && (tail.getElement().intValue() != value)
		                && size == 2)) { return; }
		Node<Integer> cursor = head;
		Node<Integer> prev;

		// If the head has the value
		if (head.getElement().intValue() == value)
		{
			if (!head.hasNext())
			{
				head = null;
				tail = null;
				size--;
				return;
			}
			head = head.getNextNode();
			size--;
		}
		else
		{
			do
			{
				prev = cursor;
				cursor = cursor.getNextNode();
				if (cursor.getElement().intValue() == value)
				{
					// middle nodes
					if (cursor.hasNext())
					{
						prev.setNextNode(cursor.getNextNode());
					}
					// tail nodes
					else
					{
						prev.setNextNode(null);
						tail = prev;
					}
					size--;
					return;
				}
			}
			while (cursor.hasNext());
		}
	}

	public void removeAll(IntSet givenSet)
	{
		if (givenSet.size() == 0) { return; }
		for (Node<Integer> n = givenSet.head; n.hasNext(); n = n.getNextNode())
		{
			remove(n.getElement());
		}
		remove(givenSet.tail.getElement());
	}

	public void addElement(int value)
	{
		if (!contain(value))
		{
			Node<Integer> newNode = new Node<Integer>(value);
			if (size == 0)
			{
				head = newNode;

			}
			else
			{
				tail.setNextNode(newNode);
			}
			tail = newNode;
			size++;
		}
	}

	public void addAll(IntSet givenSet)
	{
		if (givenSet.size() == 0) { return; }
		for (Node<Integer> n = givenSet.head; n.hasNext(); n = n.getNextNode())
		{
			addElement(n.getElement());
		}
		addElement(givenSet.tail.getElement());
	}

	public int size()
	{
		return size;
	}

	public boolean subsetOf(IntSet givenSet)
	{
		if (givenSet.size() == 0) { return true; }
		for (Node<Integer> n = givenSet.head; n.hasNext(); n = n.getNextNode())
		{
			if (!contain(n.getElement().intValue())) { return false; }
		}
		return true;
	}

	public boolean isEqual(IntSet givenSet)
	{
		IntSet copy = new IntSet(this);
		if (givenSet.size() != size()) { return false; }
		if (subsetOf(givenSet) && givenSet.subsetOf(copy)) { return true; }
		return false;
	}

	public IntSet union(IntSet givenSet)
	{
		IntSet union = new IntSet(this);
		union.addAll(givenSet);
		return union;
	}

	public IntSet intersection(IntSet givenSet)
	{
		IntSet intersect = union(givenSet);
		intersect.removeAll(this.complement(givenSet));
		intersect.removeAll(givenSet.complement(this));
		return intersect;
	}

	public IntSet complement(IntSet givenSet)
	{
		IntSet comp = new IntSet(this);
		comp.removeAll(givenSet);
		return comp;
	}

	public IntSet deepCopy(IntSet givenSet)
	{
		IntSet set = new IntSet();
		set.addAll(givenSet);
		return set;
	}

	@Override
	public String toString()
	{
		String str = "[";
		if (head != null)
		{
			for (Node<Integer> n = head; n.hasNext(); n = n.getNextNode())
			{
				str += n.getElement().intValue();
				if (n.hasNext())
				{
					str += ",";
				}
			}
			str += tail;
		}
		str += "]";
		return str;
	}
}
