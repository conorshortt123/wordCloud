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
		input.useDelimiter("[^A-Za-z0-9�'.]+");
		int i = 0;
		String word;
		String[] split = null;
		
		/*
		 *  Parsing file contents and adding to each ArrayList
		 *  Running Time: O(2n)
		 */

		while(ignore.hasNextLine()) {
			ignoreWords.add(ignore.next());
		}
		while(input.hasNextLine()) {
			word = input.next();
			word = word.replace(".", "");
			text.add(word);
		}
		
		/*
		 *  Finding words in text list that need to be removed according to the ignoreWords list.
		 *  Running Time: O(n^2)
		 */
		 
		while(i < text.size()) {
			word = text.get(i).toLowerCase();
			if(ignoreWords.contains(word)) {
				text.remove(i);
			}
			else if(text.get(i).length() < 2) {
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