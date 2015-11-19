package assignment3;

/*
 * This program provides the skeleton to process multiple files from a directory
 * The directory name is provided in args[0] as I call
 * "java Project3 hashingdata"
 */
import java.io.*;
import java.util.*;

class Project3
{

	public static void main(String[] args) throws IOException
	{
		TestHandler t = new TestHandler();
		if (args.length < 1)
		{
			System.out.println("Error: Directory name is missing");
			System.out.println("Usage: java scoreProcess directory_name");
			return;
		}
		File directory = new File(args[0]); // args[0] contains the directory
		                                    // name
		File[] files = directory.listFiles(); // get the list of files from that
		                                      // directory

		Scanner input;

		// process the arguments stores in args
		for (int i = 0; i < files.length; i++)
		{
			input = new Scanner(files[i]);

			System.out.println("\nCurrent file name: " + files[i].getName());

			// no error checking done here, add your own
			String name;
			Double score;
//			while (input.hasNext())
//			{
//				name = "";
//				while (!input.hasNextDouble())
//				{
//					name += input.next() + " ";
//				}
//				name = name.substring(0, name.length()-1);
//				score = new Double(input.next());
//				System.out.println("Name: " + name + " Score: " + score);
//				t.add(name, score);
//			}
			while(input.hasNextLine())
			{
				Scanner sc = new Scanner(input.nextLine());
				name = "";
				while (sc.hasNext() && !sc.hasNextDouble())
				{
					name += sc.next() + " ";
				}
				if(sc.hasNext())
				{
					name = name.substring(0, name.length()-1);
					score = new Double(sc.nextDouble());
					System.out.println("Name: " + name + " Score: " + score);
					t.add(name, score);
				}
				else
				{
					System.out.println("Invalid Entry!");
				}	
				sc.close();
			}
		}
		
		input = new Scanner(System.in);
		System.out.println("Enter name: ");
		String temp = input.nextLine();
		do
		{
			System.out.println(t.showStats(temp));
			temp = input.nextLine();
		} while(!temp.isEmpty());
		input.close();
	}
}
