import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public abstract class Shape {
	
	private int xLoc, yLoc, width, height, red, green, blue;
	private String xDirection = "", yDirection = "";
	
	//xDirection getter and setter
		public String getXDirection()
		{
			return xDirection;
		}
		
		public void setXDirection(String xDirection)
		{
			this.xDirection = xDirection;
		}

	//yDirection getter and setter
		public String getYDirection()
		{
			return yDirection;
		}
		
		public void setYDirection(String yDirection)
		{
			this.yDirection = yDirection;
		}

	
	
	//xLoc getter and setter:
		public int getX()
		{
			return xLoc;
		}
		
		public void setX(int x)
		{
			this.xLoc = x;
		}
	
	//yLoc getter and setter:
		public int getY()
		{
			return yLoc;
		}
		
		public void setY(int y)
		{
			this.yLoc = y;
		}		
		
		
	//width getter and setter:
		public int getWidth()
		{
			return width;
		}
		
		public void setWidth(int width)
		{
			this.width = width;
		}
		
	//height getter and setter:
		public int getHeight()
		{
			return height;
		}
		
		public void setHeight(int height)
		{
			this.height = height;
		}
		
	//red getter and setter:
		public int getRed()
		{
			return red;
		}
		
		public void setRed(int red)
		{
			this.red = red;
		}

	//green getter and setter:
		public int getGreen()
		{
			return green;
		}
		
		public void setGreen(int green)
		{
			this.green = green;
		}
			
	//blue getter and setter:
		public int getBlue()
		{
			return blue;
		}
		
		public void setBlue(int blue)
		{
			this.blue = blue;
		}

		
		
	public void move(int screenWidth, int screenHeight, int borderOffset)
	{	
		
		//First, set + or - motion direction for xLoc and yLoc if not done already:
		if (this.yDirection.equals(""))
		{
			this.yDirection = Randomize.motionDirection();
		}
		if (this.xDirection.equals(""))
		{
			this.xDirection = Randomize.motionDirection();
		}
		
		//Finally: move it within screen:.
		
		//If y direction = +
		if (this.yDirection.equals("+"))
		{
			//If at or past bottom edge of the screen:
			if (this.yLoc+this.height >= screenHeight-borderOffset)
			{
				this.yDirection = "-";
				//Force it inside screen:
				while (this.yLoc+this.height > screenHeight-borderOffset)
				{
					this.yLoc = screenHeight-borderOffset-this.height;
				}
			}
			//otherwise increment y:
			else
			{
				this.yLoc++;
			}
		}
		//If y direction = -
		else
		{
			//If at or past top edge of the screen:
			if (this.yLoc <= 0)
			{
				this.yDirection = "+";
				while (this.yLoc < 0)
				{
					this.yLoc = 0;
				}
			}
			//In case drawbox is traveling to the top edge and the bottom pushes it:
			else if (this.yLoc+this.height > screenHeight-borderOffset)
			{
				while (this.yLoc+this.height > screenHeight-borderOffset)
				{
					this.yLoc = screenHeight-borderOffset-this.height;
				}
			}
			//otherwise decrement y:
			else
			{
				this.yLoc--;
			}
		}
		
		//If x direction = +
		if (this.xDirection.equals("+"))
		{
			//If at or past bottom edge of the screen:
			if (this.xLoc+this.width >= screenWidth-borderOffset)
			{
				this.xDirection = "-";
				//Force it inside screen:
				while (this.xLoc+this.width > screenWidth-borderOffset)
				{
					this.xLoc = screenWidth-borderOffset-this.width;
				}
			}
			//otherwise increment y:
			else
			{
				this.xLoc++;
			}
		}
		//If x direction = -
		else
		{
			//If at or past top edge of the screen:
			if (this.xLoc <= 0)
			{
				this.xDirection = "+";
				while (this.xLoc < 0)
				{
					this.xLoc = 0;
				}
			}
			//In case drawbox is traveling to the top edge and the bottom pushes it:
			else if (this.xLoc+this.width > screenWidth-borderOffset)
			{
				while (this.xLoc+this.width > screenWidth-borderOffset)
				{
					this.xLoc = screenWidth-borderOffset-this.width;
				}
			}
			//otherwise decrement y:
			else
			{
				this.xLoc--;
			}
		}

		
	}

	//public abstract void draw(Circle circle, Graphics g);
	public abstract void draw(Object arrayItem, Graphics g, int screenWidth, int screenHeight, int borderoffset);

}
