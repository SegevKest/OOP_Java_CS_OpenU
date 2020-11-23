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
		
	}
	
	/**
	 * Copy Constructor for a Point by new Point Obj.
	 * @param pointObj The point object to create new copy from
	 */
	public Point (Point pointObj) {
		
		boolean validObj =  pointObj != null ;
		
		if (validObj) {
			_radius = pointObj._radius;
			_alpha = pointObj._alpha;
		}
	}
	
	public double getX() {
		
	}
	

	public double getY() {
		
	}
	

	public double setX(double num) {
		
	}
	

	public double setY(double num) {
		
	}
	
	public String toString() {
		
	}
	
	public boolean equals(Point other) {
		
	}
	

	public boolean isAbove(Point other) {
		
	}
	
	public boolean isUnder(Point other) {
		
		return other.isAbove(this);
	}
		
	public boolean isLeft(Point other) {
		
	}

	public boolean isRight(Point other) {
		
		return other.isLeft(this);
	}
	
	public double distance(Point p) {
		
	}
	
	public void move(double dx, double dy) {
		
		return other.isLeft(this);
	}
}
