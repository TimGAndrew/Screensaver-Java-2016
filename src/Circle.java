import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.geom.Point2D;

public class Circle extends Shape {
	
	
	//Circle Constructor
	public Circle(int x, int y, int dimensions, int red, int green, int blue) 
	{
		setX(x);
		setY(y);
		setWidth(dimensions);
		setHeight(dimensions);
		setRed(red);
		setGreen(green);
		setBlue(blue);
	}
	
	//Method to draw circle:
	@Override
	public void draw(Object arrayItem, Graphics g, int screenWidth, int screenHeight, int borderOffset)
	{
		Circle circle = (Circle) arrayItem;
		circle.move(screenWidth, screenHeight, borderOffset);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(new Color(circle.getRed(),circle.getBlue(),circle.getGreen()));
		g2d.fillOval(circle.getX(),circle.getY(),circle.getWidth(),circle.getHeight());
		//add Gradient:
		Paint p;
		p = new GradientPaint(circle.getX(), circle.getY(), new Color(0.0f,0.0f,0.0f,0.8f), circle.getX()+circle.getWidth(), circle.getY()+circle.getHeight(), new Color(0.0f,0.0f,0.0f,0.0f));
		g2d.setPaint(p);
		g2d.fillOval(circle.getX(), circle.getY(), circle.getWidth(), circle.getHeight());

	}
	

}
