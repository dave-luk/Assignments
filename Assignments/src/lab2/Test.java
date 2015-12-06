package lab2;

public class Test
{
	private String s;
	
	public Test(Test t)
	{
		this.s = t.getS();
	}
	
	public Test(String s)
	{
		this.setS(s);
	}
	/**
	 * @return the s
	 */
	public String getS()
	{
		return s;
	}
	/**
	 * @param s the s to set
	 */
	public void setS(String s)
	{
		this.s = s;
	}
	
	public static long fib(int n)
	{
		if(n < 3) return 1;
		else return fib(n-2) + fib(n-1);
	}
	
	public static void main(String[] args)
	{
		System.out.println(fib(50));
		int[][] test = new int[30][10];
		test[9][10] = 10;
	}
}

