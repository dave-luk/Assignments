package reference.tree;

import cs241.A1.BinaryTreeNode;

public class BinaryTree<E>
{
	private int					size;
	private BinaryTreeNode<E>	root;

	public BinaryTree(BinaryTreeNode<E> root)
	{
		this.root = root;
		size = 1;
	}

	public int getSize()
	{
		return size;
	}

	public BinaryTreeNode<E> getRoot()
	{
		return root;
	}

	public boolean add(E element, int pos)
	{
		try
		{
			BinaryTreeNode<E> b = seek(pos / 2);
			if (pos % 2 == 0) b.setLeftChild(new BinaryTreeNode<E>(element));
			else b.setRightChild(new BinaryTreeNode<E>(element));
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}

	public void remove(int pos)
	{
		try
		{
			BinaryTreeNode<E> b = seek(pos / 2);
			if (pos % 2 == 0) b.setLeftChild(null);
			else b.setRightChild(null);
		}
		catch (Exception e)
		{

		}
	}

	private BinaryTreeNode<E> seek(int pos)
	{
		BinaryTreeNode<E> cursor = root;
		String path = Integer.toBinaryString(pos).substring(1);

		for (int i = 0; i < path.length(); i++)
		{
			if (path.charAt(i) == '0') cursor = cursor.getLeftChild();
			else cursor = cursor.getRightChild();
		}
		return cursor;
	}
}
