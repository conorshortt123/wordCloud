package ie.gmit.sw;

import java.io.FileNotFoundException;

public class Runner {
	public static void main(String[] args){
		
		Menu menu = new Menu();
		
		try {
			menu.show();
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] File not found.");
		}
	}
}

