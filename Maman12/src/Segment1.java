
public class Segment1 {

	
	
	private Point _poLeft;
	private Point _poRight;
	
	public Segment1 (Point left, Point right) {
		
		boolean isParallelXaxis = left.getY() == right.getY();
		
		_poLeft = new Point(left);
		
		if ( isParallelXaxis )
			_poRight = new Point(right);
		else
			_poRight = new Point(right.getX() , left.getY());
	}	
	
	
	public Segment1 (double leftX ,double leftY, double rightX ,double rightY) {
	
		boolean isParallelXaxis = leftY == rightY;
		
		_poLeft = new Point (leftX , leftY);
		
		if( isParallelXaxis ) 
			_poRight = new Point (rightX , rightY);
		else
			_poRight = new Point (rightX , leftY);
	}
	
	public Segment1 (Segment1 other) {
		
		boolean validObj =  other != null ;
		
		if (validObj) {
				_poLeft = new Point(other._poLeft);
				_poRight = new Point(other._poRight);
		}
	}
	
	public Point getPoLeft() {
		
		return _poLeft;
	}
	

	public Point getPoRight() {
		
		return _poRight;
	}
	
	public double getLength() {
		
		return _poLeft.distance(_poRight);
	}
}
