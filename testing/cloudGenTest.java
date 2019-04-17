package testing;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class cloudGenTest {

	public static void main(String[] args) throws Exception {
	
		BufferedImage image = new BufferedImage(600, 300, BufferedImage.TYPE_3BYTE_BGR);
		Graphics graphics = image.getGraphics();
		
		/*
		 * The position on the Y axis of the image is 72.5% of the font size. So if the font is
		 * 100 then subsequently the position of the word on the Y axis must be 72.5 
		 * (or 72 as java.graphics can't use integers).
		 */
		
		int y, x, i;
		int fontSize = 40;
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, fontSize);
		String str = "C";
		String s = "CON";
		
		y = (int) (fontSize * 0.8);
		x = (int) ((fontSize * s.length()) * 0.70);
		/*
		for(i=0;i<2;i++) {
			graphics.setColor(Color.green);
			graphics.setFont(font);
			graphics.drawString(s, x, 40);
			//y+=y;
			x+=x;
			graphics.setColor(Color.blue);
			graphics.drawString(s, x, 40);
		}*/
		String c = "CON";

		x = 0;
		graphics.setColor(Color.green);
		graphics.setFont(font);
		graphics.drawString(c, x, fontSize);
		graphics.setColor(Color.blue);
		graphics.setFont(font);
		graphics.drawString(c, x, fontSize);
		
		graphics.dispose();
		ImageIO.write(image, "png", new File("testImage.png"));
		}
}