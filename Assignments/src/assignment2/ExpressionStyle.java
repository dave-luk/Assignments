package assignment2;

public enum ExpressionStyle
{
	POSTFIX(), PREFIX(), INFIX();

	public static ExpressionStyle isType(String str)
	{
		switch (str.toLowerCase())
		{
			case "postfix":
				return POSTFIX;
			case "prefix":
				return PREFIX;
			case "infix":
				return INFIX;
			default:
				return null;
		}
	}

	public String toString()
	{
		return this.name();
	}
}
