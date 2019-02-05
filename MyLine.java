import java.awt.Color;
import java.awt.Graphics;
/**
 * Author: Jun Hao Zhang
 * 
 * Description:
 * This class tracks the data of the shape line. It extends from the abstract class
 * MyShape.
 * 
 *  Date: January 15, 2016
 */
public class MyLine extends MyShape
{
     // A no parameter constructor
     public MyLine()
    {
       // Calls the Parent class constructor
       super();
    }
    // constructor with input values
    public MyLine( int x1, int y1, int x2, int y2, Color color )
    {
        super(x1,y1,x2,y2,color);
    } // end MyLine constructor
     
    // Actually draws the line
    public void draw( Graphics g )
    {
        // Sets the colour and draws it
        g.setColor( super.getColor() );
        g.drawLine( super.getx1(), super.gety1(), super.getx2(), super.gety2() );
    } // end method draw
} // end class MyLine