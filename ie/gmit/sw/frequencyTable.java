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
			
		for(i=0;i<text.size();i++) {
			
			key = text.get(i).toUpperCase();
			
			if(frequency.containsKey(key)) {
				frequency.put(key, frequency.get(key) + 1);
			} else {
				frequency.put(key, 1);
			}	
		}
		
		List<Integer> values = new LinkedList<Integer>(frequency.values());
		
		Collections.sort(values, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		
		System.out.println("Enter the maximum number of words you would like to display:");
		Menu.maxWords = input.nextInt();
		
		List<Integer> frequentValues = new LinkedList<Integer>();
		List<String> frequentKeys = new LinkedList<String>();
		String commonKey, prevKey = null;
		int commonValue, increment = 0;
		
		i = 1;
		/*
		 * - Values is a sorted list of all the values in the HashMap, sorted from lowest to highest, so I values.get(lastIndex - i)
		 * - getKey gets the key associated with that value.
		 * - i starts at 1, I get commonKey and commonValue and compare commonKey to the previous commonKey, which is initially null.
		 * - The IF statement fires if the commonKey isn't equal to the previous one.
		 */
		while(increment < Menu.maxWords) {	
			commonValue = values.get(frequency.size()-i);
			commonKey = getKey(frequency, commonValue);
			
			if(!(commonKey.equalsIgnoreCase(prevKey)))
			{
				frequentValues.add(commonValue); 
				frequentKeys.add(commonKey);
				increment++;
			}
			prevKey = commonKey;
			i++;
		}
		
		for(i=0;i<frequentKeys.size();i++) {
			System.out.println(frequentKeys.get(i) + " " + frequentValues.get(i));
		}

		/*for(i=0;i<frequentKeys.size();i++) {
			System.out.println(frequentKeys.get(i) + " was said " + frequentValues.get(i) + " times.");
		}*/
		
		/*wordCloudGen g = new wordCloudGen();
		g.generator(frequency);*/
		//list.size() - 1 for last index. Subtract -2 for second last and so on.
	}
	
	public <K, V> K getKey(Map<K, V> map, V value) {
	    for (Entry<K, V> entry : map.entrySet()) {
	        if (entry.getValue().equals(value)) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}
}
