import java.util.Scanner; // Must Import this Every time when i use Input from user

public class Circle {

	/*
	 * Class Author : Segev Kestenbaum
	 * Date : 13.11.2020 
	 * Description: 
	 * 				Class that will contain 1 method - main.
	 * 				The user will input 4 numbers which will represent the coordinates of 2 points of a given Rectangle;
	 * 				That Program will calculate the Area and Perimeter of the InCircle and ExCircle of the rectangle;
	 * 
	 * Calculations:
		 	Perimeter = 2 * π * Radius 
		 	Area = π * Radius ^ 2;
	 */
	
	public static void main(String[] args) {
		
		//initialize all variables in Program
		int leftUpX = 0, leftUpY = 0, rightBottomX = 0, rightBottomY = 0; 
		
		// Variables for Calculations
		double inRadius = 0, inArea = 0, inPerimeter = 0, exRadius = 0, exArea = 0, exPerimeter = 0;
		double rectangleDiagonal = 0, distanceXs = 0, distanceYs = 0;
		
		// PIE Constant
		final double PIE_VALUE = Math.PI;
		
		// Initiate a new instance of object from Scanner class - for use as input Object
		Scanner scan = new Scanner(System.in);

		// Message to Introduce the program
		System.out.println ("This program calculates the areas " +
							 "and the perimeters of the excircle and the incircle " +
							 "of a given rectangle \n ");
		
		// Message for first Input from user
		// Left Top Point ( leftUpX , leftUpY )
		System.out.print("Please enter the two coordinates of the " +
				 			"left-upper point of the rectangle : ");
		 leftUpX = scan.nextInt();
		 leftUpY = scan.nextInt();

		// Message for second Input from user
		// Right Bottom Point ( rightBottomX , rightBottomY )
		 System.out.print("Please enter the two coordinates of the " +
					 			"right-bottom point of the rectangle : ");	
		 rightBottomX = scan.nextInt();
		 rightBottomY = scan.nextInt();
		 
		 //Close scanner
		 scan.close();
		 
		 // Calculate Distances between coordinates
		 distanceXs = Math.abs(leftUpX-rightBottomX);
		 distanceYs = Math.abs(leftUpY-rightBottomY);
		 
		// Calculate rectangle Diagonal Line
		 rectangleDiagonal = Math.sqrt( Math.pow(distanceXs, 2) + Math.pow(distanceYs, 2));
		 
		 // Calculate INCIRCLE data
		 inRadius = (leftUpY - rightBottomY) / 2.0 ;
		 inArea = PIE_VALUE * Math.pow(inRadius, 2);
		 inPerimeter = 2 * PIE_VALUE * inRadius;
		 
		// Calculate EXCIRCLE data
		 exRadius = rectangleDiagonal / 2.0 ; 
		 exArea = PIE_VALUE * Math.pow(exRadius, 2);
		 exPerimeter = 2 * PIE_VALUE * exRadius;
		 
		 // Final Output of Program
		System.out.println("Incircle: Radius = "+inRadius + ", area = "+inArea+", perimeter = "+inPerimeter);	 
		System.out.println("Excircle: Radius = "+exRadius + ", area = "+exArea+", perimeter = "+exPerimeter);	 
			
	}	
}
