import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rect extends Shape {
	
	//Rect Constructor
	public Rect(int x, int y, int width, int height, int red, int green, int blue) 
	{
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		setRed(red);
		setGreen(green);
		setBlue(blue);
	}

	//Method to draw rectangle:
	@Override
	public void draw(Object arrayItem, Graphics g, int screenWidth, int screenHeight, int borderOffset)
	{
		Rect rect = (Rect) arrayItem;
		rect.move(screenWidth, screenHeight, borderOffset);
		Graphics2D g2d = (Graphics2D)g;

		g2d.setColor(new Color(rect.getRed(),rect.getBlue(),rect.getGreen()));
		g2d.fillRect(rect.getX(),rect.getY(),rect.getWidth(),rect.getHeight());

	}

}
