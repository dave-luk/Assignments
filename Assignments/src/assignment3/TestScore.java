package assignment3;

public class TestScore
{
	private int		testCount;
	private double	totalScore;
	
	

	public TestScore()
	{
		testCount = 0;
		totalScore = 0;
	}
	
	public TestScore(double score)
	{
		totalScore =  score;
		testCount = 1;
	}

	public int getTestCount()
	{
		return testCount;
	}

	public void setTestCount(int testCount)
	{
		this.testCount = testCount;
	}

	public double getTotalScore()
	{
		return totalScore;
	}

	public void setTotalScore(double totalScore)
	{
		this.totalScore = totalScore;
	}

	public void addScore(double score)
	{
		totalScore += score;
		testCount++;
	}
	
	@Override
	public String toString()
	{
		return "Avg: " + totalScore / testCount + "\t# Scores: " + testCount;
	}
	
}
