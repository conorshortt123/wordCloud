package ie.gmit.sw;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.Scanner;

public class wordCloudGen{
	public static void main(String args[]) throws Exception{
		
		String[] word = new String[3];
		int[] userFont = new int[3];
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the first word:");
		word[0] = input.nextLine();
		System.out.println("Enter the second word:");
		word[1] = input.nextLine();
		System.out.println("Enter the third word:");
		word[2] = input.nextLine();
		
		System.out.println("Enter font size (0-100) for font 1:");
		userFont[0] = input.nextInt();
		System.out.println("Enter font size (0-100) for font 2:");
		userFont[1] = input.nextInt();
		System.out.println("Enter font size (0-100) for font 3:");
		userFont[2] = input.nextInt();
		

		Font font = new Font(Font.SANS_SERIF, Font.BOLD, userFont[0]);
		BufferedImage image = new BufferedImage(600, 300, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.green);
		graphics.setFont(font);
		graphics.drawString(word[0], 0, 100);
		font = new Font(Font.SANS_SERIF, Font.ITALIC, userFont[1]);
		graphics.setFont(font);
		graphics.setColor(Color.yellow);
		graphics.drawString(word[1], 10, 150);
		font = new Font(Font.MONOSPACED, Font.PLAIN, userFont[2]);
		graphics.setFont(font);
		graphics.setColor(Color.blue);
		graphics.drawString(word[2], 40, 180);
		graphics.dispose();
		ImageIO.write(image, "png", new File("image.png"));
	}
}