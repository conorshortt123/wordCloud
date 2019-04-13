package testing;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class cloudGenTest {

	public static void main(String[] args) throws Exception {
	
		BufferedImage image = new BufferedImage(600, 300, BufferedImage.TYPE_3BYTE_BGR);
		Graphics graphics = image.getGraphics();
		
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 40);
		graphics.setColor(Color.green);
		graphics.setFont(font);
		graphics.drawString("Conor", 450, 200);
		font = new Font(Font.SANS_SERIF, Font.ITALIC, 30);
		graphics.setFont(font);
		graphics.setColor(Color.yellow);
		graphics.drawString("Conor", 10, 150);
		font = new Font(Font.MONOSPACED, Font.PLAIN, 100);
		graphics.setFont(font);
		graphics.setColor(Color.blue);
		graphics.drawString("Conor", 40, 180);
		graphics.dispose();
		ImageIO.write(image, "png", new File("image.png"));
		}
}