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
}

