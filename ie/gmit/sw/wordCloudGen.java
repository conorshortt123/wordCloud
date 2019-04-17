package ie.gmit.sw;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class wordCloudGen{
	public void generator(Map<String, Integer> frequency, List<Integer> values) throws Exception{
		
		Font font;
		int i = 0;
		
		frequencyTable f = new frequencyTable();
		Random rand = new Random();
		BufferedImage image = new BufferedImage(1200, 600, BufferedImage.TYPE_3BYTE_BGR);
		Graphics graphics = image.getGraphics();
		
		//Image size is 1200 x 600
		int x = 10, y = 30, fontSize = 0;
		int maxXCoord = 1200, maxYCoord = 600;
		String word = null;
		int incrementX;
		int incrementY = 0;
		float r, g, b; // Values for red green and blue, make up a random color.
		int size = values.size();
		
		/*
		 * Loops through the ArrayList. Increments along the X axis as long as X is less than the maxXCoord, if X is greater
		 * than the maxXCoord then it ends the while and Y is incremented.
		 * Running Time: O(n^2)
		 */
		while(y < maxYCoord) {			
			while(x < maxXCoord) {
				
				if(i < size) {
					fontSize = values.get(i);
				}
				else {
					break;
				}
				if(fontSize < 13) {
					fontSize = 13; // Set to 10 as words with font size less than six are unreadable.
				}
				
				/*
				 * Included this if statement as Poblacht Na HEireann only has 8 words that have unique frequencies, if you take those
				 * frequencies and use them as the font size it'll print out 8 tiny words. So I check if the list size is less than
				 * 15, increase font size and increase the initial position on the Y axis to center it more.
				 */
				if(size < 15) {
					y += 40;
					fontSize = 100;
				}
		
				font = new Font(Font.SANS_SERIF, Font.BOLD, fontSize);
				
				//Setting random color: Generates a random float for each component of the color, red green and blue.
				r = rand.nextFloat();
				g = rand.nextFloat();
				b = rand.nextFloat();
				Color randomColor = new Color(r, g, b);
				
				//Getting the word using the current value, the word is retrieved from the HashMap in frequencyTable class.
				word = f.getKey(frequency, values.get(i));
				incrementX  = (int) ((fontSize * word.length()) * 0.75);
				incrementY = (int) (fontSize * 0.9);
				
				graphics.setColor(randomColor);
				graphics.setFont(font);
				graphics.drawString(word, x, y);
				
				x += incrementX;
				i++;
				if(i >= Menu.maxWords) {
					break;
				}
			}
			x = 10;
			y += incrementY;
		}
		
		graphics.dispose();
		ImageIO.write(image, "png", new File(Menu.imageName));
	}
}