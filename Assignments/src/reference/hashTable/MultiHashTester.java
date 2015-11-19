package reference.hashTable;

public class MultiHashTester
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MultiHash<String> test = new MultiHash<>(1);
		test.put("FB", new String("bs"));
		test.put("Ea", new String("wow"));
		test.put("b", new String("such"));

		System.out.println(test.toString());
	}

}
