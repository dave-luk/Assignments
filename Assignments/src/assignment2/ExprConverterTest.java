package assignment2;

import java.util.Scanner;

public class ExprConverterTest
{

	public static void main(String[] args)
	{
		ExprConverter ec = new ExprConverter();
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter infix expression: ");
		String input = sc.nextLine();
		sc.close();
		ec.setExpression(input);
		System.out.println("Prefix:\t\t" + ec.convert(ExpressionStyle.PREFIX));
		System.out.println("Postfix:\t" + ec.convert(ExpressionStyle.POSTFIX));
	}

}
