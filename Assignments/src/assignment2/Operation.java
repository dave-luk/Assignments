package assignment2;

public class Operation
{
	private String			operator;
	private String			leftOperand;
	private String			rightOperand;
	private ExpressionStyle	style;
	private Type			currType;
	private int				index;

	enum Type
	{
		OPERATOR(), OPERAND(), EXPRESSION();
	}

	public Operation(String str, Type t, int index)
	{
		if (t == Type.OPERAND)
		{
			leftOperand = str;
		}
		else
		{
			operator = str;
		}
		this.setIndex(index);
		currType = t;
	}

	public Operation(ExpressionStyle e, Type t)
	{
		this.currType = t;
		this.style = e;
	}

	public void setOperator(Operation operation)
	{
		if (operation.currType == Type.OPERATOR) this.operator = operation.operator;
	}

	public void setLeftOperand(Operation operation)
	{
		if (operation.currType == Type.OPERAND) this.leftOperand = operation.leftOperand;
		else if (operation.currType == Type.EXPRESSION) this.leftOperand = operation.toType(style);
	}

	public void setRightOperand(Operation operation)
	{
		if (operation.currType == Type.OPERAND) this.rightOperand = operation.leftOperand;
		else if (operation.currType == Type.EXPRESSION) this.rightOperand = operation.toType(style);
	}

	public boolean hasOperator()
	{
		return !(operator == null);
	}

	public boolean hasleftOperand()
	{
		return !(leftOperand == null);
	}

	public boolean hasrightOperand()
	{
		return !(rightOperand == null);
	}

	public void clear()
	{
		operator = null;
		leftOperand = null;
		rightOperand = null;
	}

	public String toPrefix()
	{
		String rtn = "";
		if (hasOperator())
		{
			rtn += operator;
		}
		if (hasleftOperand())
		{
			rtn += leftOperand;
		}
		if (hasrightOperand())
		{
			rtn += rightOperand;
		}
		return rtn;
	}

	public String toPostfix()
	{
		String rtn = "";
		if (hasleftOperand())
		{
			rtn += leftOperand;
		}
		if (hasrightOperand())
		{
			rtn += rightOperand;
		}
		if (hasOperator())
		{
			rtn += operator;
		}
		return rtn;
	}

	public String toInfix()
	{
		return "(" + leftOperand + operator + rightOperand + ")";
	}

	public String toType(ExpressionStyle from)
	{
		switch (from)
		{
			case INFIX:
				return toInfix();
			case PREFIX:
				return toPrefix();
			case POSTFIX:
				return toPostfix();
			default:
				return null;
		}
	}

	/**
	 * @return the style
	 */
	public ExpressionStyle getStyle()
	{
		return style;
	}

	/**
	 * @param style
	 *            the style to set
	 */
	public void setStyle(ExpressionStyle style)
	{
		this.style = style;
	}

	/**
	 * @return the index
	 */
	public int getIndex()
	{
		return index;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(int index)
	{
		this.index = index;
	}

	@Override
	public String toString()
	{
		String rtn = "";
		if (hasleftOperand())
		{
			rtn += leftOperand;
		}
		if (hasOperator())
		{
			rtn += operator;
		}
		if (hasrightOperand())
		{
			rtn += rightOperand;
		}

		return rtn;
	}

	public int length()
	{
		int rtn = 0;
		if (hasleftOperand())
		{
			rtn += leftOperand.length();
		}
		if (hasOperator())
		{
			rtn += operator.length();
		}
		if (hasrightOperand())
		{
			rtn += rightOperand.length();
		}
		return rtn;
	}

}
