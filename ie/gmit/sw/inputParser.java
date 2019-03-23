package ie.gmit.sw;

import java.util.*;
import java.io.*;

public class inputParser {
	public static void main(String[] args) throws Exception{
		File TEXT_FILE = new File("PoblachtNaHEireann.txt");
		List<String> text = new ArrayList<String>();
		//Regex to delimit everything except letters: "^A-Za-z+"
		try {	
			Scanner input = new Scanner(TEXT_FILE);
			//input.useDelimiter("");
			String next;
			
			while (input.hasNext()){
				next = input.next();
				text.add(next);
			}
			input.close();
		} catch (Exception e) {
			throw new Exception("[ERROR] Encountered a problem reading the file. " + e.getMessage());
		}
		
		for(int i=0;i<text.size();i++)
		{
			System.out.println(text.get(i));
		}
	}
}