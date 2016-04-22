package cs241.A1;

import java.util.Arrays;

public class HeapTester
{

	public static void main(String[] args)
	{
		Heap<Integer> heap1 = new Heap<>(Heap.Mode.MAX_HEAP);
		heap1.fromArray(new Integer[] {1,15,23,16,57,27,46,33,25,79,21,11,10,9,8});
		Heap<Integer> heap3 = heap1.deepCopy(Heap.Mode.MIN_HEAP);
		Heap<Integer> heap4 = heap3.deepCopy();
		heap4.setMode(Heap.Mode.MAX_HEAP);
		System.out.println(heap4);
		Integer[] test = heap1.getSortedContents(new Integer[1]);
		System.out.println(Arrays.toString(test));
		Heap<String> heap2 = new Heap<>(Heap.Mode.MIN_HEAP);
		heap2.fromArray(new String[] {"a","ab","ac","abb"});
		System.out.println(heap1);
		System.out.println(heap3);

	}

}
