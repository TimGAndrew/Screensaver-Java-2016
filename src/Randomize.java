import java.util.Random;

public class Randomize {
	
	//Define number of shapes (this number should be the number of shape classes created):
	private final static int numberOfShapeClasses = 5;
	//Define max. and min. dimensions:
	private final static int maxDimension = (140 + 1); //Dimension adds 1 so that dimension can be used.
	private final static int minDimension = 4;
	//Define Randomizer:
	private static Random randomize = new Random();
	
	
	//static method to pick a random shape:
	public static int shape()
	{
		
		return randomize.nextInt(numberOfShapeClasses - 0);
	}
	
	
	
	//static method to pick a random RGB value between 0-255:
	public static int rgb()
	{
		return randomize.nextInt(256 - 100);
	}
	
	
	
	//static method to pick a random shape width or height dimension:
	public static int dimensions()
	{
		int returnDimension = randomize.nextInt(maxDimension - minDimension);
		if (returnDimension < 4)
		{
			return 4;
		}
		else
		{
			return returnDimension;
		}
	}
	
	
	
	//static method to return a random x or y coordinates, gets values from window size.
	public static int coordinates(int screenDimension)
	{
		return randomize.nextInt(screenDimension - 0);
	}
	
	//static method to return a random motion direction.
	public static String motionDirection()
	{
		String direction = "";
		int directionPicker = randomize.nextInt(2 - 0);
		if (directionPicker == 0)
		{
			direction = "+";
		}
		else
		{
			direction = "-";
		}
		return direction;
	}
	
	

}
