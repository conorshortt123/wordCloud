package ie.gmit.sw;

import java.util.*;
import java.io.*;

public class Menu {

	public void show() throws FileNotFoundException {
		
		Scanner input = new Scanner(System.in);
		
		final int SENTINEL = -1;
		int choice;
		File TEXT_FILE;
		String file;
		
		System.out.println("\nEnter your choice:(1/2/3/-1)"
				+ "\n 1 = Enter a file name or URL"
				+ "\n 2 = Enter the maximum number of words to display"
				+ "\n 3 = Enter the name of the word-cloud image"
				+ "\n-1 = Exit\n");
		choice = input.nextInt();		
		while(choice != SENTINEL)
		{
			if(choice == 1)
			{
				System.out.println("Please enter the name of the file you wish you parse:");
				file = input.next();
				TEXT_FILE = new File(file);
				Parser p = new Parser();
				p.inputParser(TEXT_FILE);
			}
			else if(choice == 2)
			{
				
			}
			else if(choice == 3)
			{
				
			}
			else
			{
				System.out.println("\nInvalid choice entered! Try again.");
			}
			
			System.out.println("Enter your choice:(1/2/3/-1)"
					+ "\n1 = Enter a file name or URL"
					+ "\n2 = Enter the maximum number of words to display"
					+ "\n3 = Enter the name of the word-cloud image"
					+ "\n-1 = Exit\n");
			choice = input.nextInt();
		}
		input.close();
	}

}
