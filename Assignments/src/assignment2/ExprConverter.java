package assignment2;

import assignment2.Operation.Type;
import reference.stack.Stack;

public class ExprConverter
{
	private String				expression;
	private Stack<Operation>	operator;
	private Stack<Operation>	operand;

	public ExprConverter()
	{
		operator = new Stack<Operation>();
		operand = new Stack<Operation>();
	}

	public void setExpression(String exp)
	{
		this.expression = exp;
	}

	public String convert(ExpressionStyle from, ExpressionStyle to)
	{
		if (from == ExpressionStyle.INFIX)
		{
			for (int i = 0; i < expression.length(); i++)
			{
				String str = Character.toString(expression.charAt(i));
				switch (expression.charAt(i))
				{
					case '+':
					case '-':
						while (!operator.isEmpty() && !operator.peek().equals("("))
							exprBuilding(str, from, to);
						operator.push(new Operation(str, Operation.Type.OPERATOR, i));
						break;
					case '*':
					case '/':
						while (!operator.isEmpty() && (operator.peek().equals("/") || operator.peek().equals("*")))
							exprBuilding(str, from, to);
						operator.push(new Operation(str, Operation.Type.OPERATOR, i));
						break;
					case '(':
						operator.push(new Operation(str, Operation.Type.OPERATOR, i));
						break;
					case ')':
						exprBuilding(str, from, to);
						break;
					case ' ':
						break;
					default:
						operand.push(new Operation(str, Operation.Type.OPERAND, i));
						break;
				}
			}

			exprBuilding(null, from, to);
			return operand.pop().toType(to);
		}
		else
		{
			if (from == ExpressionStyle.PREFIX)
			{
				for (int i = 0; i < expression.length(); i++)
				{
					String str = Character.toString(expression.charAt(i));
					switch (expression.charAt(i))
					{

						case '+':
						case '-':
						case '*':
						case '/':
							operator.push(new Operation(str, Operation.Type.OPERATOR, i));
							break;
						case ' ':
							break;
						default:
							if (!operand.isEmpty()
							        && isAdjacent(new Operation(str, Type.OPERAND, i), operand.peek(), from))
							{
								operand.push(new Operation(str, Operation.Type.OPERAND, i));
								exprBuilding(str, from, to);
							}
							else operand.push(new Operation(str, Operation.Type.OPERAND, i));
							break;
					}
				}
			}
			else
			{
				for (int i = 0; i < expression.length(); i++)
				{
					String str = Character.toString(expression.charAt(i));
					switch (expression.charAt(i))
					{
						case '+':
						case '-':
						case '*':
						case '/':
							if (!operand.isEmpty() && isAdjacent(getPrev(operand), operand.peek(), from))
							{
								operator.push(new Operation(str, Operation.Type.OPERATOR, i));
								exprBuilding(str, from, to);
							}
							else operator.push(new Operation(str, Operation.Type.OPERATOR, i));
							break;
						case ' ':
							break;
						default:
							operand.push(new Operation(str, Operation.Type.OPERAND, i));
							break;

					}
				}

			}
		}
		exprBuilding(null, from, to);
		return operand.pop().toType(to);
	}

	private void exprBuilding(String curr, ExpressionStyle from, ExpressionStyle to)
	{
		boolean popped = false;
		boolean cont = false;
		do
		{
			if (!operator.isEmpty())
			{
				cont = false;
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

				Operation exp = new Operation(to, Type.EXPRESSION);
				try
				{
					exp.setOperator(operator.peek());
					exp.setRightOperand(operand.pop());
					exp.setLeftOperand(operand.pop());
					exp.setStyle(to);
					exp.setIndex(operator.pop().getIndex());
					operand.push(exp);
				}
				catch (RuntimeException Re)
				{
					throw new RuntimeException("<ERROR>: Missing Operand(s)!");
				}

				// check if now has 2 operands and a operator again
				try
				{
					Operation top = operand.pop();
					if (!operand.isEmpty())
					{
						Operation next = operand.peek();
						if (!operator.isEmpty() && isAdjacent(top, next, from))
						{
							cont = true;
						}
					}
					operand.push(top);
				}
				catch (RuntimeException e)
				{

				}
			}
		}
		while (cont == true);

		if (operator.isEmpty() && !popped && curr != null
		        && curr.equals(")")) { throw new RuntimeException("<ERROR>: Unmatched Parentheses! \"(\""); }
	}

	private boolean isAdjacent(Operation top, Operation next, ExpressionStyle orig)
	{
		if (orig == ExpressionStyle.PREFIX) return (next.getIndex() + next.length() == top.getIndex());
		else return (next.getIndex() - next.length() == top.getIndex());
	}

	private Operation getPrev(Stack<Operation> target)
	{
		Operation top = target.pop();
		Operation next = target.peek();
		target.push(top);
		return next;
	}

	@Override
	public String toString()
	{
		return "Expr:\t" + expression + "\nOperator:\t" + operator + "\nOperand:\t" + operand;
	}
}
