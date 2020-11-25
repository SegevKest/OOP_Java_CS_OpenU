
/**
 * Compilation (only !) tester for Maman 12, 20441, 2021a
 * 
 * @author Course staff 
 * @version 2_1
 */
public class PointTester2
{
	
    public static void main(String[] args)
    {
        System.out.println("============ Testing class Point =============");
        Point p1 = new Point(3.0, 4.0);
        	System.out.println("After constructor P1 "+p1);
        Point p2 = new Point(p1);
        	System.out.println("After constructor P2 :"+ p2);
        double d1 = p1.getX();
        	System.out.println("X of p1:" +d1);	
        d1 = p1.getY();
    		System.out.println("Y of p1:"+d1);	

        if (!p1.equals(p2))
            System.out.println("Check your equals method in class Point");
        //p1.setX(0.0);
    		//System.out.println("After SetX:"+ p1);	

        p1.setY(0.0);
		System.out.println("After SetY:"+ p1);	

        boolean b1 = p1.isAbove(p2); 
		System.out.println("isAbove:"+ b1 +". Abs: "+Math.abs(p1.getY()-p2.getY()));	

        b1 = p1.isUnder(p2);
        System.out.println("isUnder:"+ b1);	
        b1 = p1.isLeft(p2);
        System.out.println("isLeft:"+ b1 +". Abs: "+Math.abs(p1.getX()-p2.getX()));	
        b1 = p1.isRight(p2);
        System.out.println("isRight:"+ b1 +" p1X :" +p1.getX()+", p2X: "+p2.getX());	
        
        d1 = p1.distance(p2);
        System.out.println("distance:"+ d1);	

        p1.move(1.0, 2.0);
    	System.out.println("After MOVE "+p1);

        if (p1.toString().indexOf('@') != -1)
            System.out.println("Check your toString method in class Point");
        System.out.println("============ Testing class Point Done =============");        
    }
}

