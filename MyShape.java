import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
/**
 * Author: Jun Hao Zhang
 * 
 * Description:
 * This is an abstract class that  contains methods to determine the 
 * right coordinates to draw the shape.
 * 
 *  Date: January 15, 2016
 */

abstract class MyShape extends JPanel
{
    // Creating variables for the coordinates and colour
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private Color color;
    
    // A no parameter constructor
    public MyShape()
    {
       // Sets the colour to black, and values to 0
       color = Color.BLACK;
       x1 = 0;
       x2 = 0;
       y1 = 0;
       y2 = 0;
    }
    
    // A constructor with parameters
    public  MyShape(int x1,int x2,int y1,int y2, Color color)
    {
        // Define each coordinates with the parameters
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        // Sets the colour
        this.color = color;
    }
    
    // Mutator that allows them to set the x1 value
    public void setx1(int x1)
    {
        this.x1 = x1;
    }
    
    // Mutator that allows them to set the x2 value
    public void setx2(int x2)
    {
        this.x2 = x2;
    }
    
    // Mutator that allows them to set the y1 value
    public void sety1(int y1)
    {
        this.y1 = y1;
    }
    
    // Mutator that allows them to set the y2 value
    public void sety2(int y2)
    {
        this.y2 = y2;
    }
    
    // Mutator that allows them to set the colour
    public void setColor(Color color)
    {
        this.color = color;
    }
    
    // An accessor method that returns the x1 value
    public int getx1()
    {
        return x1;
    }
    
    // An accessor method that returns the x2 value
    public int getx2()
    {
        return x2;
    }
    
    // An accessor method that returns the y1 value
    public int gety1()
    {
        return y1;
    }
    
    // An accessor method that returns the y2 value
    public int gety2()
    {
        return y2;
    }
    
    // An accessor method that returns the colour
    public Color getColor()
    {
        return color;
    }
    
    // An abstract class
    abstract public void draw( Graphics g );
}