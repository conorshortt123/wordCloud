package ie.gmit.sw;

import java.util.*;
import java.io.*;

public class Parser {
	List<String> text = new ArrayList<String>();
	List<String> ignoreWords = new ArrayList<String>();
	File IGNORE_FILE = new File("ignorewords.txt");
	
	public void inputParser(File TEXT_FILE) throws FileNotFoundException {
		Scanner input = new Scanner(TEXT_FILE);
		Scanner ignore = new Scanner(IGNORE_FILE);
		input.useDelimiter("[^A-Za-z0-9É']+");
		boolean found;
		int i, j;	
		int removeCount = 0;
		
		while(ignore.hasNextLine()) {
			ignoreWords.add(ignore.next());
		}
		while(input.hasNextLine()) {
			text.add(input.next());
		}
		
		for(i=0;i<text.size();i++) { //REMOVING WITH FOR LOOP
			for(j=0;j<ignoreWords.size();j++) {
				if(text.get(i).equalsIgnoreCase(ignoreWords.get(j))) {
					System.out.println("Removing: " + text.get(i));
					text.remove(i);
					removeCount++;
				}
			}
		}
		System.out.println("Removed: " + removeCount);

		/*for(i=0;i<text.size();i++) { //REMOVING WITH ARRAYLIST METHODS
			if(ignoreWords.contains(text.get(i).toLowerCase())) {
				System.out.println("Removing: " + text.get(i));
				text.remove(i);
				removeCount++;
			}
		}
		System.out.println("Removed: " + removeCount);*/
		
		/*for(i=0;i<text.size();i++) {
			System.out.println(text.get(i));
		}*/
			
		input.close();
		ignore.close();
	}

}