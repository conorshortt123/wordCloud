package ie.gmit.sw;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class wordCloudGen{
	public void generator(Map<String, Integer> frequency) throws Exception{
		
		Menu m = new Menu();
		Scanner input = new Scanner(System.in);
		Font font;
		int i;
		
		for(i=0;i<m.maxWords;i++) {
			//font = new Font(Font.SANS_SERIF, Font.BOLD, frequency frequency.size());
		}
		
		font = new Font(Font.SANS_SERIF, Font.BOLD, 40);
		BufferedImage image = new BufferedImage(600, 300, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.green);
		graphics.setFont(font);
		graphics.drawString("Conor", 0, 100);
		font = new Font(Font.SANS_SERIF, Font.ITALIC, 10);
		graphics.setFont(font);
		graphics.setColor(Color.yellow);
		graphics.drawString("Conor", 10, 150);
		font = new Font(Font.MONOSPACED, Font.PLAIN, 20);
		graphics.setFont(font);
		graphics.setColor(Color.blue);
		graphics.drawString("Conor", 40, 180);
		graphics.dispose();
		ImageIO.write(image, "png", new File(m.imageName));
	}
}