import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Square extends Shape {
	
	//Square Constructor
	public Square(int x, int y, int dimensions, int red, int green, int blue) 
	{
		setX(x);
		setY(y);
		setWidth(dimensions);
		setHeight(dimensions);
		setRed(red);
		setGreen(green);
		setBlue(blue);
	}
	
	//Method to draw square:
	@Override
	public void draw(Object arrayItem, Graphics g, int screenWidth, int screenHeight, int borderOffset)
	{
		BufferedImage[] image = new BufferedImage[1];
		try {
			image[0]= ImageIO.read(getClass().getResource("/img/overlay.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Square square = (Square) arrayItem;
		square.move(screenWidth, screenHeight, borderOffset);
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(new Color(square.getRed(),square.getBlue(),square.getGreen()));
		g2d.fillRect(square.getX(),square.getY(),square.getWidth(),square.getHeight());

		TexturePaint p = new TexturePaint(image[0], new Rectangle(square.getX(), square.getY(), square.getWidth(), square.getHeight()));
		g2d.setPaint(p);
		g2d.fillRect(square.getX(), square.getY(), square.getWidth(), square.getHeight());


	}


}
