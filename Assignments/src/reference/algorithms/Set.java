package reference.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Set<T>
{
	List<T> set;

	public Set(@SuppressWarnings("unchecked") T... objects)
	{
		set = new ArrayList<>();
		for (T obj : objects)
		{
			set.add(obj);
		}
	}

	public List<T> getSet()
	{
		return set;
	}

	/**
	 * Computes all combination of sets
	 * 
	 * @return all combinations of the set
	 */
	public List<ArrayList<T>> powerSet()
	{
		// inSet describes whether element is in the set or not.
		boolean[] inSet = new boolean[set.size()];
		// List of lists to store subsets
		ArrayList<ArrayList<T>> powerSet = new ArrayList<>();
		// initialize recursive calls
		subSet(inSet, powerSet, set.size() - 1);
		return powerSet;
	}

	public List<ArrayList<T>> combination(int r)
	{
		List<ArrayList<T>> combSet = new ArrayList<>();
		for (ArrayList<T> subset : powerSet())
		{
			if (subset.size() == r)
			{
				combSet.add(subset);
			}
		}
		return combSet;
	}

	public List<ArrayList<T>> permutation()
	{
		boolean[] used = new boolean[set.size()];
		int[] order = new int[set.size()];
		ArrayList<ArrayList<T>> permutations = new ArrayList<>();
		permute(used, order, permutations, set.size() - 1);
		return permutations;
	}

	private void permute(boolean[] used, int[] order, ArrayList<ArrayList<T>> list, int tier)
	{
		if (tier < 0)
		{
			list.add(constructSet(order));
		}
		else
		{
			for (int i = 0; i < set.size(); i++)
			{
				if (!used[i])
				{
					used[i] = true;
					order[tier] = i;
					permute(used, order, list, tier - 1);
					used[i] = false;
				}

			}
		}
	}

	private ArrayList<T> constructSet(int[] order)
	{
		ArrayList<T> perm = new ArrayList<>();
		for (int i : order)
		{
			perm.add(set.get(i));
		}
		return perm;
	}

	private void subSet(boolean[] inSet, ArrayList<ArrayList<T>> powerset, int tier)
	{
		/*
		 * if we have computed all possible combination of this, add the set.
		 */
		if (tier < 0)
		{
			powerset.add(constructSet(inSet));
		}
		else
		{
			inSet[tier] = true;
			subSet(inSet, powerset, tier - 1);
			inSet[tier] = false;
			subSet(inSet, powerset, tier - 1);
		}
	}

	private ArrayList<T> constructSet(boolean[] inSet)
	{
		ArrayList<T> subset = new ArrayList<>();
		for (int i = 0; i < set.size(); i++)
		{
			if (inSet[i])
			{
				subset.add(set.get(i));
			}
		}
		return subset;
	}

	public static void main(String[] args)
	{
		Set<String> set = new Set<>("A", "B", "C");
		for (ArrayList<String> subset : set.powerSet())
		{
			System.out.println(subset.toString());
		}
		System.out.println("COMB: ");
		for (ArrayList<String> combination : set.combination(2))
		{
			System.out.println(combination);
		}
		System.out.println("PERM: ");
		for (ArrayList<String> perm : set.permutation())
		{
			System.out.println(perm);
		}

	}
}
