/**
 * Maman 12
 * Point Class - Question No.1
 * Date : 
 * @author Segev Kestenbaum
 *
*/
public class Point {

	
	private double _radius;
	private double _alpha;
	
	//Private Params
	private final byte Q1_DEFAULT_VAL = 0;
	private final int FIXED_ROUND_PARAM= 10000;
	private final int RIGHT_ANGLE_DEGREES = 90;

	private final double PIE_CONST = Math.PI;	
	private final double CONVERT_DEGREES_TO_RADIANS = PIE_CONST / 180 ;
	private final double CONVERT_RADIANS_TO_DEGREES = 1 / CONVERT_DEGREES_TO_RADIANS ;
	
	
	
	/**
	 * Construct a Point By 2 coordinates.
	 * If any parameter is negative, we will set it to 0 
	 * @param x coordinate
	 * @param y coordinate
	 */
	public Point (double x, double y) {
		
		boolean isValidXCoordinate =  x > Q1_DEFAULT_VAL;
		boolean isValidYCoordinate =  y > Q1_DEFAULT_VAL;
		
		x = isValidXCoordinate ? x : Q1_DEFAULT_VAL;
		y = isValidYCoordinate ? y : Q1_DEFAULT_VAL;
		
		setRadiusAndAlpha(x, y);
	}
	
	/**
	 * Copy Constructor for a Point by new Point Obj.
	 * @param pointObj The point object to create new copy from 
	 */
	public Point (Point other) {
		
		boolean validObj =  other != null ;
		
		if (validObj) {
			_radius = other._radius;
			_alpha = other._alpha;
		}
	}
	
	/**
	 * Private function that sets the Alpha and Radius By the Coordinates thats been given
	 * @param x  coordinate
	 * @param y  coordinate
	 */
	private void setRadiusAndAlpha(double x, double y) {
		
		double radiusCalculateInnerPhrase = 0, coordinatesRatio = 0;
		boolean isXEqualsZero =  x == Q1_DEFAULT_VAL;

		//alpha calculation
		if (! isXEqualsZero) {		
			coordinatesRatio = Math.atan( y / x );
			_alpha = CONVERT_RADIANS_TO_DEGREES * coordinatesRatio;
		}
		else
			_alpha = RIGHT_ANGLE_DEGREES;
				
		//radius calculation
		radiusCalculateInnerPhrase = Math.pow(x, 2) +  Math.pow(y, 2);
		_radius = Math.sqrt(radiusCalculateInnerPhrase);		
	}
	
	/**
	 * Return a number after round
	 * @param coordinate to round value
	 * @return Rounded number
	 */
	private double roundCoordinate(double coordinate) {
		
		return ( Math.round(coordinate * FIXED_ROUND_PARAM ) / (double)FIXED_ROUND_PARAM );
	}
	
	
	/**
	 * Returns the X coordinate of the Point
	 * @return the X coordinate
	 */
	public double getX() {
		
		double xCoordinate = 0, convertedAlpha = 0;
		
		convertedAlpha = CONVERT_DEGREES_TO_RADIANS * _alpha;
		xCoordinate = Math.cos(convertedAlpha) * _radius;
		
		return xCoordinate;
	}
	
	/**
	 * Returns the Y coordinate of the Point
	 * @return the Y coordinate
	 */
	public double getY() {
		
		double yCoordinate = 0, convertedAlpha = 0;
		
		convertedAlpha = CONVERT_DEGREES_TO_RADIANS * _alpha;
		yCoordinate = Math.sin(convertedAlpha) * _radius;
		
		return yCoordinate;
	}
	
	/**
	 * Sets the X Coordinate of the point
	 * if negative value is received, the X coordinate will not change
	 * @param num the new X Value to set
	 */
	public void setX(double num) {
		
		boolean isNumNegative =  num < Q1_DEFAULT_VAL;
		
		if (! isNumNegative ) {
			setRadiusAndAlpha(num, getY());
		}
		
	}
	
	/**
	 * Sets the Y Coordinate of the point
	 * if negative value is received, the Y coordinate will not change
	 * @param num the new Y Value to set
	 */
	public void setY(double num) {
		
		boolean isNumNegative =  num < Q1_DEFAULT_VAL;
		
		if (! isNumNegative ) {
			setRadiusAndAlpha(getX(), num);
		}
		
	}
	
	/**
	 * Return a string representing of the Point.
	 * @return String Represent the Point
	 */
	public String toString() {
	
		double xToPrint = roundCoordinate(getX());
		double yToPrint = roundCoordinate(getY());
		
		return "("+xToPrint+","+yToPrint+")";
		
	}
	
	/**
	 * Check if this point is equal to other.
	 * @param other new Point to compare with this point
	 * @return true is this point is equal to the other Point
	 */
	public boolean equals(Point other) {
		
		boolean areXValusMatch = getX() == other.getX();
		boolean areYValusMatch = getY() == other.getY();
		
		return areXValusMatch && areYValusMatch ;
	}
	
	/**
	 * Check if this point is above other point
	 * @param other point to compare with this point
	 * @return true if this point is above other point
	 */
	public boolean isAbove(Point other) {
		
		return getY() > other.getY();
	}
	
	/**
	 * Check if this point is Under other point
	 * @param other point to compare with this point
	 * @return true if this point is Under other point
	 */
	public boolean isUnder(Point other) {
		
		return other.isAbove(this);
	}
		
	/**
	 * Check if this point is to the left of other point
	 * @param other point to compare with this point
	 * @return true if this point is to the left of other point
	 */
	public boolean isLeft(Point other) {
		
		return getX() < other.getX();
	}

	/**
	 * Check if this point is to the right of other point
	 * @param other point to compare with this point
	 * @return true if this point is to the right of other point
	 */
	public boolean isRight(Point other) {
		
		return other.isLeft(this);
	}
	
	/**
	 * Calculate the distance between this point and other point
	 * @param p new point to calculate the distance from
	 * @return the distance between this and P Point
	 */
	public double distance(Point p) {
		
		double totalDistance = 0, xDistance = 0, yDistance = 0;
		
		xDistance = Math.pow( ( getX() - p.getX() ) , 2);
		yDistance = Math.pow( ( getY() - p.getY() ) , 2);
		
		totalDistance = Math.sqrt(yDistance + xDistance );
		
		return totalDistance;

	}
	
	/**
	 * Moves the X Coordinate By dX and Y Coordinate By dY.
	 * if movement moves the point outside of first quadrant, then the
	 * point will remain at the same place and will not move.
	 * @param dx the amount to move in the X direction
	 * @param dy the amount to move in the Y direction
	 */
	public void move(double dx, double dy) {
		
		double newXLocation = getX() + dx;
		double newYLocation = getY() + dy;
		
		boolean isXUnvalidAfterMove = newXLocation < Q1_DEFAULT_VAL;
		boolean isYUnvalidAfterMove = newYLocation < Q1_DEFAULT_VAL;
		
		boolean isUnvalidMove = isXUnvalidAfterMove || isYUnvalidAfterMove ;
		
		if ( ! isUnvalidMove )
			setRadiusAndAlpha( newXLocation, newYLocation );
		
	}
}
