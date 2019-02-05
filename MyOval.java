import java.awt.Color;
import java.awt.Graphics;
/**
 * Author: Jun Hao Zhang
 * 
 * Description:
 * This class tracks the data of the shape Ovals. It extends from the abstract class
 * MyOval.
 * 
 *  Date: January 15, 2016
 */


public class MyOval extends MyBoundedShape
{

    // A no parameter constructor
    public MyOval()
    {
       // Calls the Parent class constructor 
       super();
    }
    // constructor with input values
    public MyOval(int x1, int x2, int y1, int y2, boolean filled,Color color)
    {
        super(x1,y1,x2,y2,color,filled);
            
    }
    
    // Actually Draws the shape
    public void draw( Graphics g )
    {
        // Set the color of the shape
        g.setColor( super.getColor());
        
        // If the shape is filled it will draw a filled shape vice versa
        if (super.getFilled()){
        // Draws the oval, recieve the values from its parents class
        g.fillOval(super.getUpperLeftX(),super.getUpperLeftY(),super.getWidth(),super.getHeight());
        }else{
        g.drawOval(super.getUpperLeftX(),super.getUpperLeftY(),super.getWidth(),super.getHeight());
        }
    }

}