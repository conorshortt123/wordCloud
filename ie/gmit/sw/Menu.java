package ie.gmit.sw;

import java.util.*;
import java.io.*;
import java.net.*;

public class Menu {

	String imageName;
	static int maxWords;
	
	public void show() throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		final int SENTINEL = -1;
		int choice;
		File TEXT_FILE;
		URL URL_FILE;
		String file, url; 
		char fileOrURL;
		boolean allChoices;
		
		fileReader f = new fileReader();
		urlReader u = new urlReader();
		
		System.out.println("\nEnter your choice:(1/2/3/-1)"
				+ "\n 1 = Enter a file name or URL"
				+ "\n 2 = Enter the maximum number of words to display"
				+ "\n 3 = Enter the name of the word-cloud image: (Don't add .png, just the name)"
				+ "\n-1 = Exit\n");
		choice = input.nextInt();
		while(choice != SENTINEL)
		{
			if(choice == 1)
			{
				System.out.println("Press F for reading in a file or U for reading a URL:");
				fileOrURL = input.next().toUpperCase().charAt(0);
				if(fileOrURL == 'F') {
					System.out.println("Please enter the name of the file you wish you parse:");
					file = input.next();
					TEXT_FILE = new File(file);
					//Passes fileReader the file name.
					f.Parser(TEXT_FILE);
				}
				else if(fileOrURL == 'U') {
					System.out.println("Please enter the URL you wish to parse:");
					url = input.next();
					URL_FILE = new URL(url);
					//Passes urlReader the URL name.
					u.Parser(URL_FILE);
				}
				else {
					System.out.println("Invalid choice entered! Try again.");
				}
			}
			else if(choice == 2)
			{
				System.out.println("Enter the maximum number of words you would like to display:");
				maxWords = input.nextInt();
			}
			else if(choice == 3)
			{
				System.out.println("Please enter the name of the image (don't use spacing):");
				imageName = input.next();
				imageName += ".png";
			}
			else
			{
				System.out.println("\nInvalid choice entered! Try again.");
			}
			
			System.out.println("\nEnter your choice:(1/2/3/-1)"
					+ "\n1 = Enter a file name or URL"
					+ "\n2 = Enter the maximum number of words to display"
					+ "\n3 = Enter the name of the word-cloud image"
					+ "\n-1 = Exit\n");
			choice = input.nextInt();
			
		}
		input.close();
	}
}
