package assignment2;

import stack.Stack;

public class ExprConverter
{
	private String			expression;
	private Stack<String>	operator;
	private Stack<String>	operand;

	public ExprConverter()
	{
		operator = new Stack<String>();
		operand = new Stack<String>();
	}

	public void setExpression(String exp)
	{
		this.expression = exp;
	}

	public String convert(ExpressionStyle e)
	{
		for (int i = 0; i < expression.length(); i++)
		{
			switch (expression.charAt(i))
			{
				case '+':
				case '-':
					while (!operator.isEmpty() && !operator.peek().equals("("))
						exprBuilding(Character.toString(expression.charAt(i)), e);
					operator.push(Character.toString(expression.charAt(i)));
					break;
				case '*':
				case '/':
					while (!operator.isEmpty() && (operator.peek().equals("/") || operator.peek().equals("*")))
						exprBuilding(Character.toString(expression.charAt(i)), e);
					operator.push(Character.toString(expression.charAt(i)));
					break;
				case '(':
					operator.push(Character.toString(expression.charAt(i)));
					break;
				case ')':
					exprBuilding(Character.toString(expression.charAt(i)), e);
					break;
				case ' ':
					break;
				default:
					operand.push(Character.toString(expression.charAt(i)));
					break;
			}
		}

		exprBuilding(null, e);
		return operand.pop();
	}

	private void exprBuilding(String curr, ExpressionStyle e)
	{
		boolean popped = false;
		while (!operator.isEmpty())
		{
			if (operator.peek().equals("("))
			{
				if (curr != null)
				{
					if (curr.equals(")"))
					{
						operator.pop();
						popped = true;
					}
					break;
				}
				else throw new RuntimeException("<ERROR>: Missing Parentheses! \")\"");
			}

			Operation exp = new Operation();
			try
			{
				exp.setOperator(operator.pop());
				exp.setRightOperand(operand.pop());
				exp.setLeftOperand(operand.pop());

				switch (e)
				{
					case PREFIX:
						operand.push(exp.toPrefix());
						break;
					case POSTFIX:
						operand.push(exp.toPostfix());
						break;
					case INFIX:
						operand.push(exp.toString());
					default:
						break;
				}

			}
			catch (RuntimeException Re)
			{
				throw new RuntimeException("<ERROR>: Missing Operand(s)!");
			}
		}

		if (operator.isEmpty() && !popped && curr != null
		        && curr.equals(")")) { throw new RuntimeException("<ERROR>: Unmatched Parentheses! \"(\""); }
	}

	@Override
	public String toString()
	{
		return "Expr:\t" + expression + "\nOperator:\t" + operator + "\nOperand:\t" + operand;
	}
}
