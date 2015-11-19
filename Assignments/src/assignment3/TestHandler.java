package assignment3;

public class TestHandler
{
	private HashTable<String, TestScore> data;

	public TestHandler()
	{
		data = new HashTable<>();
	}

	public void add(String name, double score)
	{
		if (data.get(name) != null)
		{
			data.get(name).addScore(score);
		}
		else
		{
			data.put(name, new TestScore(score));
		}
	}

	public String showStats(String key)
	{
		if (data.get(key) != null) return key + ": " + data.get(key).toString();
		else return key + " not found!";
	}
	
}
