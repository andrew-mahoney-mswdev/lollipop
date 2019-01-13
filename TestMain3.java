package lollipop;

import java.math.*; //Allows generation of random numbers

public class TestMain3 {
	/** This program tests the lollipop class by drawing 100 lollipops on the screen, with random positions, sizes and colours.
	 * The program determines the limitations for the positions of the lollipops dynamically, based upon their randomly determined size.
	 * This allows for small lollipops to have centre positions that are closer to the edge of the window than large lollipops,
	 * as small lollipops are capable of appearing closer to the edge without overlapping it.*/

	//Declaration of constant variables
	public static final int maxSize = 200; //The maximum size of a circle.
	public static final int maxstickHeight = 300; //The maximum height of a stick.
	public static final int screenWidth = 600; //By default, the UI window is about 600 pixels wide,
	public static final int screenHeight = 470; //and about 470 pixels high.
	
	public static double getRandom(double min, double max) {
		/** This method returns a random number between a minimum and a maximum value.*/ 
		return Math.random() * (max - min) + min;
	}
	
	public static double getRandom() {
		/** For the sake of consistency, this method allows a random value to be generated with a method call similar to the one above.*/
		return Math.random();
	}
	
	public static void main(String[] args) {
		/** This method tests the lollipop class by drawing 100 lollipops with random parameters.
		 * It calculates each lollipop's dimensions and determines the range within which a lollipop can appear without overlapping the edge
		 * of the screen.
		 */
		int count; //The counter of a for loop.
		double size; //Records a random size.
		double halfSize; //Calculating half of this size is required to calculate the lollipop's dimensions.
		double stickHeight; //Records a random stick height.
		double x, y; //Records a random location for the centre of the lollipop.
		double xLimit, yLimit;
		/* These variables are used in calculating the right and lower most positions at which a lollipop of a given size can be drawn
		 * without overlapping the edge of the window.*/
		
		lollipop lollipopObj = new lollipop();

		for (count = 0; count < 100; count++) {
			//We randomly generate the properties of a lollipop.
			size = getRandom(0, maxSize); //A random size is generated up to a predefined maximum.
			halfSize = size / 2;
			stickHeight = getRandom(halfSize + 1, maxstickHeight);
			/* Half of the circle will cover the stick. So to ensure that the lollipop's stick is partly visible, the minimum size of the
			 * stick must be greater than half the size of the circle.*/
			
			xLimit = screenWidth - halfSize; //The right most position of any circle centre is the window width, less half the size.
			x = getRandom(halfSize, xLimit);
			/* The left most position of a lollipop is half the size. A random x value between halfSize and xLimit prevents the lollipop
			 * from overlapping the window's edges.*/
			
			yLimit = screenHeight - stickHeight; //The bottom most position of the lollipop stick is the window height, less the stick height.
			y = getRandom(halfSize, yLimit);
			/* As above, this range prevents the lollipop from overlapping the edge of the screen.*/
			
			lollipopObj.drawLollipop(x, y, size, stickHeight, getRandom(), getRandom(), getRandom());
			/* A lollipop is drawn according to the above random properties. The last three parameters of this method call provide
			* random values for the colour of the circle.*/
		}
	}
/* Limitation: Occasionally, this code may draw a lollipop that has a stick which overlaps the bottom of the UI window by a few pixels.
 * In testing, I discovered that this would not occur if the UI.setLineWidth() method call is removed from the lollipop class.
 * This limitation is therefore an unintended effect of the setLineWidth() method from the UI library, not an error with the math used above.
 */
}
