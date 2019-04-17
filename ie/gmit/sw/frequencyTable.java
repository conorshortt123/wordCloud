package ie.gmit.sw;

import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class frequencyTable {
	
	public void table(List<String> text) throws Exception {
		
		HashMap<String, Integer> frequency = new HashMap<>();
		Scanner input = new Scanner(System.in);
				
		int i = 0;
		String key = null;
		
		/*
		 * Adding ArrayList words to the HashMap, increments value if word is already contained in the map. Else adds the key and sets value to 1.
		 * Running Time: O(n)
		 */
		for(i=0;i<text.size();i++) {
			
			key = text.get(i).toUpperCase();
			
			if(frequency.containsKey(key)) {
				frequency.put(key, frequency.get(key) + 1);
			} else {
				frequency.put(key, 1);
			}
			
		}
		
		/*
		 * Put values from the hashmap into a LinkedList to be sorted
		 * Running Time O(n)
		 */
		List<Integer> values = new LinkedList<Integer>(frequency.values());
		
		/*
		 * Sorts the list of values by order of value, lowest element at index 0 and so on.
		 * I used this method as I wanted the words on the cloud image to increase in 
		 * ascending order, having the words grow larger then the previous.
		 * Running time O(n^2)
		 */
		Collections.sort(values, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		
		/*
		 * Put values from the LinkedList into a LinkedHashSet, and then into an ArrayList: Removes duplicate values and keeps order.
		 * Running Time O(2n)
		 */
		LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(values);
		ArrayList<Integer> valuesNoDuplicates = new ArrayList<>(hashSet);
		
		//Runs if the user hasn't input the name and max words from the menu class.
		if(Menu.setVars < 2)
		{
			System.out.println("Enter the maximum number of words you would like to display:");
			Menu.maxWords = input.nextInt();
			
			if(Menu.maxWords > valuesNoDuplicates.size()) {
				System.out.println("Max words exceeds list of frequent words! Frequent word list size = " + valuesNoDuplicates.size());
				System.out.println("Setting max words = to list size.");
				Menu.maxWords = valuesNoDuplicates.size();
			}
			
			System.out.println("Enter the name of the image:(don't include .png)");
			Menu.imageName = input.next();
			Menu.imageName += ".png";
		}
		
		wordCloudGen g = new wordCloudGen();
		g.generator(frequency, valuesNoDuplicates);
	}
	
	/*
	 * Returns the key from the HashMap from a given value.
	 * Running Time: O(n)
	 */
	public <K, V> K getKey(Map<K, V> map, V value) {
	    for (Entry<K, V> entry : map.entrySet()) {
	        if (entry.getValue().equals(value)) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}
}
