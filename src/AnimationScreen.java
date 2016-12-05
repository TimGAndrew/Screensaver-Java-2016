import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationScreen extends JPanel {
	
	//timer:
	private Timer timer = new Timer(1, new TimerAction());
	
	//Screen Dimensions variables
	private static int screenWidth = 0;
	private static int screenHeight = 0;
	private static int borderOffset = 9; // this is an offset needed to keep shape inside the screen.
	
	//A list to hold all of the created shapes to be displayed on the screen:
	static List<Object> shapesArray = new ArrayList<Object>();

	@Override
	public void paintComponent(Graphics g)
	{
		setScreenDimensions();
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		
		//On startup, add 4 shapes into the shapesArray:
		if(shapesArray.size() == 0)
		{
			for(int i=1; i <= 4; i++)
				{
					addShape();
				}
		}
	
		//Move and Draw each element:
		for (int i=0; i < shapesArray.size(); i++)
		{
			//cast selected shape as a generic shape:
			Shape shape = (Shape) shapesArray.get(i);
			
			//set its boundaries as a rectangle:				
			Rectangle shapeRect = new Rectangle(shape.getX(),shape.getY(),shape.getWidth(),shape.getHeight());

			//iterate through shapesArray and see if each item intersects
			for (int j=0; j < shapesArray.size(); j++)
			{
				//if array item is the item being checked, skip it:
				if (i == j)
				{
					continue;
				}
				//otherwise check to see if it's intersecting:
				else
				{
					Shape checkShape = (Shape) shapesArray.get(j);
					Rectangle checkRect = new Rectangle (checkShape.getX(),checkShape.getY(),checkShape.getWidth(),checkShape.getHeight());
					//If rectangles intersect:
					if (shapeRect.intersects(checkRect))
					{
						//if collision is in increasing x axis
						if (shape.getX()+shape.getWidth()-1 == checkShape.getX())
						{
							shape.setXDirection("-");
							//
							if (checkShape.getXDirection().equals("-"))
							{
								checkShape.setXDirection("+");
								//checkShape.setX(x);
							}
							else if (checkShape.getXDirection().equals("+"))
							{
								checkShape.setXDirection("-");
							}
						}
						//if collision is in decreasing x axis:
						else if (shape.getX()+1 == checkShape.getX()+checkShape.getWidth())
						{
							shape.setXDirection("+");
							if (checkShape.getXDirection().equals("-"))
							{
								checkShape.setXDirection("+");
							}
							else if (checkShape.getXDirection().equals("+"))
							{
								checkShape.setXDirection("-");
							}

						}
						
						//if collision is in increasing y axis
						if (shape.getY()+shape.getHeight()-1 == checkShape.getY())
						{
							shape.setYDirection("-");
							if (checkShape.getYDirection().equals("-"))
							{
								checkShape.setYDirection("+");
							}
							else if (checkShape.getYDirection().equals("+"))
							{
								checkShape.setYDirection("-");
							}
						}
						//if collision is in decreasing y axis:
						else if (shape.getY()+1 == checkShape.getY()+checkShape.getHeight())
						{
							shape.setYDirection("+");
							if (checkShape.getYDirection().equals("-"))
							{
								checkShape.setYDirection("+");
							}
							else if (checkShape.getYDirection().equals("+"))
							{
								checkShape.setYDirection("-");
							}

						}
					}
				}
			}
			
					
			//get substring of i (to @) to determine Shape of object (only way knew how):
			String classChecker = shapesArray.get(i).toString().substring(0, (shapesArray.get(i).toString()).indexOf("@"));
			
			//If element is a Circle class:
			if (classChecker.equalsIgnoreCase("circle"))
			{
				//cast it as its type
				Circle circle = (Circle) shapesArray.get(i);
				circle.draw(shapesArray.get(i), g2d, screenWidth, screenHeight, borderOffset);
			}
			
			//If element is a Oval class:
			if (classChecker.equalsIgnoreCase("oval"))
			{
				Oval oval = (Oval) shapesArray.get(i);
				oval.draw(shapesArray.get(i), g2d, screenWidth, screenHeight, borderOffset);
			}
			
			//If element is a Square class:
			if (classChecker.equalsIgnoreCase("square"))
			{
				Square square = (Square) shapesArray.get(i);
				square.draw(shapesArray.get(i), g2d, screenWidth, screenHeight, borderOffset);
			}
			
			//If element is a Rect class:
			if (classChecker.equalsIgnoreCase("rect"))
			{
				Rect rectangle = (Rect) shapesArray.get(i);
				rectangle.draw(shapesArray.get(i), g2d, screenWidth, screenHeight, borderOffset);
			}
			
			//If element is a Star class:
			if (classChecker.equalsIgnoreCase("hourglass"))
			{
				HourGlass hourGlass = (HourGlass) shapesArray.get(i);
				hourGlass.draw(shapesArray.get(i), g2d, screenWidth, screenHeight, borderOffset);
			}
			
			timer.start();
		}
	}

	
	private void setScreenDimensions()
	{
		Rectangle screenDimensions = MainWindow.contentPane.getBounds();
		screenWidth = (int) screenDimensions.getWidth();
		screenHeight = (int) screenDimensions.getHeight();

	}

	//This method will add a random shape:
	public static void addShape()
	{
		int shapeToAdd = Randomize.shape();
		
		switch (shapeToAdd){
		//if case is 0, add a circle:
		case 0:	Circle circle = addCircle();
				shapesArray.add(circle);
				break;
		//if case is 1, add a oval:		
		case 1:	Oval oval = addOval();
				shapesArray.add(oval);
				break;
		//if case is 2, add a square:
		case 2:	Square square = addSquare();
				shapesArray.add(square);
				break;
		//if case is 3, add a rectangle:				
		case 3:	Rect rectangle = addRectangle();
				shapesArray.add(rectangle);
				break;
		//if case is 4, add a hourglass:				
		case 4:	HourGlass hourGlass = addHourGlass();
				shapesArray.add(hourGlass);
				break;
		}

	}

	//Create a new circle:
	private static Circle addCircle()
	{
		Circle circle = new Circle(Randomize.coordinates(screenWidth), 
				   Randomize.coordinates(screenHeight),
				   Randomize.dimensions(),
				   Randomize.rgb(),
				   Randomize.rgb(),
				   Randomize.rgb()								   
				   );

		//if created with a mouse click set x/y:
		if (MainWindow.mouseXClick >= 0 && MainWindow.mouseYClick >= 0)
		{
			circle.setX(MainWindow.mouseXClick-(circle.getWidth()/2));
			circle.setY(MainWindow.mouseYClick-(circle.getHeight()/2));
		}
	
		//make it fit on screen:
		while ((circle.getX()+circle.getWidth()) >= screenWidth-borderOffset)
		{
			circle.setX(circle.getX()-1);
		}
		while ((circle.getY()+circle.getHeight()) >= screenHeight-borderOffset)
		{
			circle.setY(circle.getY()-1);
		}
		return circle;
	}
	
	private static Oval addOval()
	{
		Oval oval = new Oval(Randomize.coordinates(screenWidth), 
				   Randomize.coordinates(screenHeight),
				   Randomize.dimensions(),
				   Randomize.dimensions(),
				   Randomize.rgb(),
				   Randomize.rgb(),
				   Randomize.rgb()								   
				   );
		
		//if created with a mouse click set x/y:
		if (MainWindow.mouseXClick >= 0 && MainWindow.mouseYClick >= 0)
		{
			oval.setX(MainWindow.mouseXClick-(oval.getWidth()/2));
			oval.setY(MainWindow.mouseYClick-(oval.getHeight()/2));
		}
	
		//make it fit on screen:
		while ((oval.getX()+oval.getWidth()) >= screenWidth-borderOffset)
		{
			oval.setX(oval.getX()-1);
		}
		while ((oval.getY()+oval.getHeight()) >= screenHeight-borderOffset)
		{
			oval.setY(oval.getY()-1);
		}
		return oval;
	}
	
	private static Square addSquare()
	{
		Square square = new Square(Randomize.coordinates(screenWidth), 
				   Randomize.coordinates(screenHeight),
				   Randomize.dimensions(),
				   Randomize.rgb(),
				   Randomize.rgb(),
				   Randomize.rgb()								   
				   );
		
		//if created with a mouse click set x/y:
		if (MainWindow.mouseXClick >= 0 && MainWindow.mouseYClick >= 0)
		{
			square.setX(MainWindow.mouseXClick-(square.getWidth()/2));
			square.setY(MainWindow.mouseYClick-(square.getHeight()/2));
		}

		//make it fit on screen:
		while ((square.getX()+square.getWidth()) >= screenWidth-borderOffset)
		{
			square.setX(square.getX()-1);
		}
		while ((square.getY()+square.getHeight()) >= screenHeight-borderOffset)
		{
			square.setY(square.getY()-1);
		}
		return square;
	}
	
	private static Rect addRectangle()
	{
		Rect rect = new Rect(Randomize.coordinates(screenWidth), 
				   Randomize.coordinates(screenHeight),
				   Randomize.dimensions(),
				   Randomize.dimensions(),
				   Randomize.rgb(),
				   Randomize.rgb(),
				   Randomize.rgb()								   
				   );
		
		//if created with a mouse click set x/y:
		if (MainWindow.mouseXClick >= 0 && MainWindow.mouseYClick >= 0)
		{
			rect.setX(MainWindow.mouseXClick-(rect.getWidth()/2));
			rect.setY(MainWindow.mouseYClick-(rect.getHeight()/2));
		}

		
		//make it fit on screen:
		while ((rect.getX()+rect.getWidth()) >= screenWidth-borderOffset)
		{
			rect.setX(rect.getX()-1);
		}
		while ((rect.getY()+rect.getHeight()) >= screenHeight-borderOffset)
		{
			rect.setY(rect.getY()-1);
		}
		return rect;
	}
	
	private static HourGlass addHourGlass()
	{
		HourGlass hourGlass = new HourGlass(Randomize.coordinates(screenWidth), 
				   Randomize.coordinates(screenHeight),
				   Randomize.dimensions(),
				   Randomize.dimensions(),
				   Randomize.rgb(),
				   Randomize.rgb(),
				   Randomize.rgb()								   
				   );
		
		//if created with a mouse click set x/y:
		if (MainWindow.mouseXClick >= 0 && MainWindow.mouseYClick >= 0)
		{
			hourGlass.setX(MainWindow.mouseXClick-(hourGlass.getWidth()/2));
			hourGlass.setY(MainWindow.mouseYClick-(hourGlass.getHeight()/2));
		}

		
		
		//make it fit on screen:
		while ((hourGlass.getX()+hourGlass.getWidth()) >= screenWidth-borderOffset)
		{
			hourGlass.setX(hourGlass.getX()-1);
		}
		while ((hourGlass.getY()+hourGlass.getHeight()) >= screenHeight-borderOffset)
		{
			hourGlass.setY(hourGlass.getY()-1);
		}
		return hourGlass;
	}


	private class TimerAction implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			AnimationScreen.this.repaint();
		}
		
	}

}
