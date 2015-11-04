package assignment2;

public class Operation
{
	private String	operator;
	private String	leftOperand;
	private String	rightOperand;

	public void setOperator(String operator)
	{
		this.operator = operator;
	}

	public void setLeftOperand(String leftOperand)
	{
		this.leftOperand = leftOperand;
	}

	public void setRightOperand(String rightOperand)
	{
		this.rightOperand = rightOperand;
	}

	public String toPrefix()
	{
		return operator + leftOperand + rightOperand;
	}
	
	public String toPostfix()
	{
		return leftOperand + rightOperand + operator;
	}
	
	@Override
	public String toString()
	{
		return leftOperand + operator + rightOperand;
	}
}
