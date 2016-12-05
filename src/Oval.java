import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

public class Oval extends Shape {
	
	//Oval Constructor
	public Oval(int x, int y, int width, int height, int red, int green, int blue) 
	{
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		setRed(red);
		setGreen(green);
		setBlue(blue);
	}

	//Method to draw oval:
	@Override
	public void draw(Object arrayItem, Graphics g, int screenWidth, int screenHeight, int borderOffset)
	{
		Oval oval = (Oval) arrayItem;
		oval.move(screenWidth, screenHeight, borderOffset);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(new Color(oval.getRed(),oval.getBlue(),oval.getGreen()));
		g2d.fillOval(oval.getX(),oval.getY(),oval.getWidth(),oval.getHeight());
		
		//Add Gradient
		Paint p;
		p = new GradientPaint(oval.getX()+oval.getWidth(), oval.getY()+oval.getHeight(), new Color(0.0f,0.0f,0.0f,0.8f), oval.getX(), oval.getY(), new Color(0.0f,0.0f,0.0f,0.0f));
		g2d.setPaint(p);
		g2d.fillOval(oval.getX(), oval.getY(), oval.getWidth(), oval.getHeight());


	}

}
