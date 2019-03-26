package testing;

import java.util.*;
import java.io.*;

public class parserTesting {

	public static void main(String[] args) throws FileNotFoundException {
		
		File inputFile = new File("testingTextFile.txt");
		Scanner input = new Scanner(inputFile);
		
		//To get rid of unwanted characters use a delimiter.
		input.useDelimiter("[^A-Za-z0-9]+");
		
		while(input.hasNextLine()) {
			System.out.println(input.next());
		}
	}

}
