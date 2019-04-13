package testing;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class urlTesting {
    public static void main(String[] args) throws Exception {
    	
    	Scanner input;
    	URL u = new URL("https://www.oracle.com/index.html");
    	input = new Scanner(new InputStreamReader(u.openStream()));
		input.useDelimiter("[^A-Za-z…']+");
       
    	while(input.hasNext()) {
    		System.out.println(input.next());
    	}
    	input.close();
    }
}