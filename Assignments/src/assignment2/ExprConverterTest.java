package assignment2;

import java.util.Scanner;

public class ExprConverterTest
{

	public static void main(String[] args)
	{
		ExprConverter ec = new ExprConverter();
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter expression type: ");
		String type = sc.nextLine();
		System.out.println("Please enter expression: ");
		String input = sc.nextLine();
		sc.close();
		ec.setExpression(input);
		ExpressionStyle to1 = ExpressionStyle.PREFIX;
		ExpressionStyle to2 = ExpressionStyle.INFIX;
		ExpressionStyle from = ExpressionStyle.isType(type);
		
		System.out.println(from + " to " + to1 + " : " + ec.convert(from, to1));
		System.out.println(from + " to " + to2 + " : " + ec.convert(from, to2));
	}

}
