import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

public class HourGlass extends Shape {
	
	//Star Constructor
	public HourGlass(int x, int y, int width, int height, int red, int green, int blue) 
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
		HourGlass hourGlass = (HourGlass) arrayItem;
		//should be .translate? instead of .move \/
		hourGlass.move(screenWidth, screenHeight, borderOffset);
		Graphics2D g2d = (Graphics2D)g;

		g2d.setColor(new Color(hourGlass.getRed(),hourGlass.getBlue(),hourGlass.getGreen()));
		
		//array for hour glass values:
		int xValues[] = {hourGlass.getX(),(hourGlass.getX()+hourGlass.getWidth()),hourGlass.getX(),(hourGlass.getX()+hourGlass.getWidth())};
		int yValues[] = {hourGlass.getY(),(hourGlass.getY()+hourGlass.getHeight()),(hourGlass.getY()+hourGlass.getHeight()),hourGlass.getY()};
			
		GeneralPath pen = new GeneralPath();
		
		//now we need to set the starting coordinates for our pen to draw the hour glass
		pen.moveTo(xValues[0],  yValues[0]);
		//now draw a line to the next set of coordinates till its done
		pen.lineTo(xValues[1],  yValues[1]);
		//and so on..
		pen.lineTo(xValues[2],  yValues[2]);
		pen.lineTo(xValues[3],  yValues[3]);
		//Then we need to close the path:
		pen.closePath(); // goes back to 0,0
			
		//This will fill that shape:
		g2d.fill(pen);
		//Now i will set the color to black
		g2d.setColor(Color.white);
				
		//and draw an outline of the same shape giving the hour glass a black border:
		g2d.draw(pen);
	}
	
/*	//Method to move:
	@Override
	public void move(int screenWidth, int screenHeight, int borderOffset)
	{
	
	
			//g2d.translate(arg0, arg1);
		
		
		

		// should use g2d.translate(#,#)
		 * 
		//set up a motion direction for x and y if not done already:
		if (this.yDirection.equals(""))
		{
			this.yDirection = Randomize.motionDirection();
		}
		if (this.xDirection.equals(""))
		{
			this.xDirection = Randomize.motionDirection();
		}
		
		//Determine what direction y is heading and act accordingly.
		if (this.yDirection.equals("+"))
		{
			if (this.y+this.height == screenHeight-borderOffset)
			{
				this.yDirection = "-";
				this.y--;
			}
			else if (this.y+this.height > screenHeight-borderOffset)
			{
				this.yDirection = "-";
				while (this.y+this.height > screenHeight-borderOffset)
				{
					this.y--;
				}
				this.y--;
			}
			else
			{
				this.y++;
			}
		}
		else
		{
			if (this.y == 0)
			{
				this.yDirection.equals("-");
				this.y--;
			}
			else if (this.y < 0)
			{
				this.yDirection = "+";
				while (this.y < 0)
				{
					this.y++;
				}
				this.y--;
			}
			else if (this.y+this.height > screenHeight-borderOffset)
			{
				while (this.y+this.height > screenHeight-borderOffset)
				{
					this.y--;
				}
				this.y--;
			}
			else
			{
				this.y--;
			}
			
		}
		
		//Determine what direction x is heading and act accordingly.
		if (this.xDirection.equals("+"))
		{
			if (this.x+this.width == screenWidth-borderOffset)
			{
				this.xDirection = "-";
				this.x--;
			}
			else if (this.x+this.width > screenWidth-borderOffset)
			{
				this.xDirection = "-";
				while (this.x+this.width > screenWidth-borderOffset)
				{
					this.x--;
				}
				this.x--;
			}

			else
			{
				this.x++;
			}
		}
		else
		{
			if (this.x == 0)
			{
				this.xDirection.equals("-");
				this.x--;
			}
			else if (this.x < 0)
			{
				this.xDirection = "+";
				while (this.x < 0)
				{
					this.x++;
				}
				this.x--;
			}
			else if (this.x+this.width > screenWidth-borderOffset)
			{
				while (this.x+this.width > screenWidth-borderOffset)
				{
					this.x--;
				}
				this.x--;
			}

			else
			{
				this.x--;
			}
			
		}		
		
	}
	*/

}
