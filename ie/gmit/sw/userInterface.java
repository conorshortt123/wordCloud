package ie.gmit.sw;

import java.util.*;
import java.io.*;

public class userInterface {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		final int SENTINEL = -1;
		int choice;
		
		System.out.println("Enter your choice:(1/2/3)"
				+ "\n1=Enter a file name or URL"
				+ "\nEnter the maximum number of words to display"
				+ "\nEnter the name of the word-cloud image");
		choice = input.nextInt();		
		while(choice != SENTINEL)
		{
			if(choice == 1)
			{
				
			}
			else if(choice == 2)
			{
				
			}
			else if(choice == 3)
			{
				
			}
			else
			{
				System.out.println("Invalid choice entered! Try again.");
			}
			
			System.out.println("Enter your choice:(1/2/3)"
					+ "\n1=Enter a file name or URL"
					+ "\nEnter the maximum number of words to display"
					+ "\nEnter the name of the word-cloud image");
			choice = input.nextInt();
		}
		input.close();
	}

}
