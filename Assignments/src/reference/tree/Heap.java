package reference.tree;

public class Heap<T extends Comparable<T>>
{
	public enum Mode
	{
		MAX_HEAP, MIN_HEAP;
	}

	private int			size;
	private BinaryTreeNode<T>	root;
	private Mode		mode;

	public Heap(Mode m)
	{
		size = 0;
		mode = m;
	}

	public Heap(Mode m, BinaryTreeNode<T> r)
	{
		root = r;
		size = 1;
		mode = m;
	}

	public int getSize()
	{
		return size;
	}

	public BinaryTreeNode<T> getRoot()
	{
		return root;
	}

	public void add(T value)
	{
		BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(value);
		if (root == null)
		{
			root = newNode;
			size++;
			return;
		}

		BinaryTreeNode<T> cursor = seek((size + 1) / 2); // the previous node of the
		                                           // desired location
		if ((size + 1) % 2 == 0) cursor.setLeftChild(newNode);
		else cursor.setRightChild(newNode);
		size++; // important

		siftUp(newNode);
	}

	public T[] toArray(T[] array)
	{
		for (int i = 1; i <= size; i++)
		{
			array[i - 1] = seek(i).getElement();
		}
		return array;
	}

	public T remove()
	{
		// Ambiguous... referring to removing the root? no specific
		// index/element is provided
		// Proceeding with removing the root.
		BinaryTreeNode<T> lastNode = seek(size);
		T temp = root.getElement();
		if (lastNode != root)
		{
			temp = swap(root, lastNode);
			// delete the last node;
			lastNode.getParent().removeChild(lastNode);
			siftDown(root);
		}
		else
		{
			root = null;
		}
		size--;

		return temp;
	}

	public void fromArray(T[] array)
	{
		for (T val : array)
		{
			add(val);
		}
	}

	public T[] getSortedContents(T[] array)
	{
		array = toArray(array);

		return array;
	}

	/**
	 * @param pos
	 *            position of node wanted.
	 * @return the node of that position
	 * 
	 *         Observe that the location of the node is the index in binary with
	 *         the MSD(first digit) discarded, a path is shown. (0 is left, 1 is
	 *         right) (Last digit is actual insert location)
	 */
	private BinaryTreeNode<T> seek(int pos)
	{
		BinaryTreeNode<T> cursor = root;
		String path = Integer.toBinaryString(pos).substring(1);

		for (int i = 0; i < path.length(); i++)
		{
			if (path.charAt(i) == '0') cursor = cursor.getLeftChild();
			else cursor = cursor.getRightChild();
		}
		return cursor;
	}

	/**
	 * 
	 * @param a
	 *            node to swap
	 * @param b
	 *            node to swap
	 * @return the value of a
	 */
	private T swap(BinaryTreeNode<T> a, BinaryTreeNode<T> b)
	{
		T temp = a.getElement();
		a.setElement(b.getElement());
		b.setElement(temp);
		return temp;
	}

	private void siftUp(BinaryTreeNode<T> n)
	{
		while (n.getParent() != null && compare(n,n.getParent()))
		{
			swap(n, n.getParent());
			n = n.getParent();
		}
	}

	private void siftDown(BinaryTreeNode<T> n)
	{
		while (n.hasChildren())
		{
			int swapPos = -1;
			int maxDiff = 0;
			for (int i = 0; i < n.getChildren().size(); i++)
			{
				int diff = Math.abs(n.getChildren().get(i).getElement().compareTo(n.getElement()));
				if (diff > 0 && diff > maxDiff)
				{
					swapPos = i;
					maxDiff = diff;
				}
			}

			switch (swapPos)
			{
				case 0:
					swap(n, n.getLeftChild());
					break;
				case 1:
					swap(n, n.getRightChild());
					break;
				default:
					return;
			}
		}
	}
	
	private boolean compare(BinaryTreeNode<T> a, BinaryTreeNode<T> b) {
		switch(mode)
		{
			case MAX_HEAP:
				return a.getElement().compareTo(b.getElement()) > 0;
			case MIN_HEAP:
				return a.getElement().compareTo(b.getElement()) < 0;
			default:
				//this should not be ever called.
				return false;
 		}
	}

	/**
	 * @return String representation of the heap
	 */
	@Override
	public String toString()
	{
		String str = "";
		for (int i = 0; i < size; i++)
		{
			BinaryTreeNode<T> curr = seek(i + 1);
			for (int t = 0; t < Math.floor((Math.log(i + 1) / Math.log(2))); t++)
				str += "\t";
			str += curr.toString();
			str += "\n";
		}
		return str;
	}
}
