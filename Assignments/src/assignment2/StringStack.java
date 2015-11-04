package assignment2;

public class StringStack implements Stack<String>
{
	private Node<String>	top;
	private int				size;

	public StringStack()
	{
		top = null;
		size = 0;
	}

	@Override
	public String peek()
	{
		if (top == null) throw new RuntimeException("ERROR: Empty Stack!");
		else return top.getElement();
	}

	@Override
	public String pop()
	{
		if (top == null) throw new RuntimeException("ERROR: Empty Stack!");
		else
		{
			String str = top.getElement();
			top = top.getNextNode();
			size--;
			return str;
		}
	}

	@Override
	public void push(String str)
	{
		Node<String> newNode = new Node<String>(str, top);
		top = newNode;
		size++;
	}

	@Override
	public boolean isEmpty()
	{
		return (size == 0);
	}

	@Override
	public int size()
	{
		return size;
	}

	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("[<TOP>: ");
		Node<String> cursor = top;
		while (cursor != null)
		{
			sb.append(cursor.getElement());
			if (cursor.getNextNode() != null)
			{
				sb.append(" -> ");
			}
			cursor = cursor.getNextNode();
		}
		sb.append(" :<BTM>]");
		return sb.toString();
	}
}
