package ie.gmit.sw;

import java.util.*;
import java.io.*;

public class fileReader {
	List<String> text = new ArrayList<String>();
	List<String> ignoreWords = new ArrayList<String>();
	File IGNORE_FILE = new File("ignorewords.txt");
	
	public void Parser(File TEXT_FILE) throws Exception {
		Scanner input = new Scanner(TEXT_FILE);
		Scanner ignore = new Scanner(IGNORE_FILE);
		input.useDelimiter("[^A-Za-z0-9É']+");
		int i = 0;
		String word;
		
		// * Parsing file contents and adding to each ArrayList

		while(ignore.hasNextLine()) {
			ignoreWords.add(ignore.next());
		}
		while(input.hasNextLine()) {
			text.add(input.next());
		}
		
		// * Finding words in text list that need to be removed according to the ignoreWords list.
		 
		while(i < text.size()) {	
			word = text.get(i).toLowerCase();
			if(ignoreWords.contains(word)) {
				text.remove(i);
			}
			else {
				i++;
			}
		}
		
		frequencyTable t = new frequencyTable();
		t.table(text);
		
		input.close();
		ignore.close();
	}

}