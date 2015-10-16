package assignment1;

public class IntSetTest
{
	public static void main(String[] args) 
	{
		int[][] sets = new int[10][];
		// Case 1:
		sets[1] = new int[] { 1, 2, 3, 4, 5 };
		sets[2] = new int[] { 2, 1, 5, 3, 4 };
		// Case 2:
		sets[3] = new int[] { 1, 2, 3 };
		sets[4] = new int[] { 1, 2, 3, 4, 5 };
		// Case 3:
		sets[5] = new int[] { 1, 2, 3 };
		sets[6] = new int[] { 1, 3, 5, 7, 9 };
		// Case 4:
		sets[7] = new int[] { 1, 3, 5, 7, 9 };
		sets[8] = new int[] { 0, 2, 4, 6, 8 };
		// Case 5:
		sets[9] = new int[] { 1, 4, 7, 2, 3 };
		sets[0] = new int[] {};

		for (int cases = 1; cases <= 9; cases += 2)
		{
			IntSet set1 = new IntSet(sets[(cases) % 10]);
			IntSet set2 = new IntSet(sets[(cases + 1) % 10]);
			
			System.out.println("is Subset:\t" + set1.subsetOf(set2));
			System.out.println("is Equal:\t" + set1.isEqual(set2));
			System.out.println("Union:\t" + set1.union(set2));
			System.out.println("Intersect:\t" + set1.intersection(set2));
			System.out.println("Complement (Set1):\t" + set1.complement(set2));
			System.out.println("Complement (Set2):\t" + set2.complement(set1));
			
			/*
			 * Note: 	Union = Complement1 + Complement2 + Intersect
			 * 			Union = 1 + 2 - 1 intersect 2
			 */
			
		}
	}
}
