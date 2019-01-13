package lollipop;

public class TestMain2 {

	public static void main(String[] args) {
		/** This method tests the lollipop class by printing a line of lollipops, increasing in size.
		 * The method uses a for loop that passes different parameters to the drawLollipop() method with each iteration of the loop.
		 */
		int count; //The counter of the for loop.
		double x, y; //Used to keep track of the horizontal (x) and vertical (y) positions of the circle centres.
		double size; //The size of a circle.
		double stickHeight; //The height of the stick.
		double rightLeft;
		/* This variable records the horizontal coordinate of the right side of the previous circle, which will be the horizontal
		 * coordinate of the left side of the next circle. Keeping track of this value is necessary to prevent lollipops from overlapping.
		 */
		
		lollipop lollipopObj = new lollipop();
		
		//The starting values of the parameters for the first lollipop are set outside the loop.
		x = 5;
		y = 50;
		size = 10;
		stickHeight = 25;
		rightLeft = 0; //The left side of the first circle will be at coordinate 0.
		
		for (count = 1; count < 12; count++) { //The loop prints 12 lollipops.
			lollipopObj.drawLollipop(x, y, size, stickHeight);
			//The drawLollipop() method is passed the current value of the parameters.
			
			//Calculate new parameters for the next lollipop.
			rightLeft += size; /* The total size of all lollipops previously printed is the horizontal coordinate at which the left side of 
			 					* the next circle must be positioned.*/
			size += 10;
			stickHeight += 25; //These variables are incremented with each iteration of the loop to increase the size.
			
			y += 5; //This increment ensures that the top of the lollipops all line up along the y coordinate.
			x = rightLeft + (size / 2); //Half the size plus rightLeft is the horizontal coordinate of the centre of the next circle.
		}
	}

}
