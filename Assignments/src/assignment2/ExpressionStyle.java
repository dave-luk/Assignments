package assignment2;

public enum ExpressionStyle
{
	POSTFIX(),
	PREFIX(),
	INFIX();
	
	public String toString()
	{
		return this.name();
	}
}
