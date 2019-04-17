package ie.gmit.sw;

import java.io.*;
import java.net.*;
import java.util.*;

public class urlReader {
	List<String> text = new ArrayList<String>();
	List<String> ignoreWords = new ArrayList<String>();
	File IGNORE_FILE = new File("ignorewords.txt");
	
	public void Parser(URL URL_FILE) throws Exception {
		
		Scanner input = new Scanner(new InputStreamReader(URL_FILE.openStream()));
		Scanner ignore = new Scanner(IGNORE_FILE);
		input.useDelimiter("[^A-Za-z…']+");
		int i = 0;
		String word;
		
		/*
		 *  Parsing URL contents and adding to each ArrayList
		 *  Running Time: O(2n)
		 */

		while(ignore.hasNextLine()) {
			ignoreWords.add(ignore.next());
		}
		while(input.hasNext()) {
			text.add(input.next());
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
			else if(text.get(i).length() < 3) {
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
