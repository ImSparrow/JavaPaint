import java.awt.Color;
import java.awt.Graphics;
/**
 * Author: Jun Hao Zhang
 * 
 * Description:
 * This is an abstract class that extends from the MyShape class. Contains methods to determine the 
 * right coordinates to draw the shape.
 * 
 *  Date: January 15, 2016
 */


abstract class MyBoundedShape extends MyShape
{
    // Variable that will determine if the shape will be filled or not
    private boolean filled;
    
    // A no parameter constructor
    public MyBoundedShape()
    {
        // Calls the parent's no parameter constructor
        super();
    }
    
    // A constructor
    public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, boolean filled)
    {
        // Calls the parent constructor
        super(x1,y1,x2,y2,color);
        
        // Determine if the shape should be filled or not
        this.filled = filled;
    }

    // Determine the top left x coordinate
    public int getUpperLeftX(){
        
        // If x1 is less than x2 then return x1 vice versa
        if (super.getx1() < super.getx2()){
            return super.getx1();
        }else{
            return super.getx2();
        }
    }
    
    // Determine the top left y coordinate
    public int getUpperLeftY(){
        
        // If y1 is less than y2 then return y1 vice versa
        if (super.gety1() < super.gety2()){
            return super.gety1();
        }else{
            return super.gety2();
        }
    }
    
    // Determine the width of the shape
    public int getWidth(){
        
        int width;
        
        // Width is determined by subtracting x1 by x2
        width = super.getx1()-super.getx2();
        
        // Getting the absolute value of the width
        if (width < 0 ){
            width = width * -1;
            return width;
        }else{
            return width;
        }
    }
    
    // Determine the height of the shape
    public int getHeight(){
        
        int height;
        
        // Height is determined by subtracting y1 by y2
        height = super.gety1()-super.gety2();
        
        // Getting the absolute value of height
        if (height < 0 ){
            height = height * -1;
            return height;
        }else{
            return height;
        }
    }
    
    // A mutator method that allows the user to determine if the shape should be filled or not
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    
    // Return a boolean variable about the shape fill
    public boolean getFilled(){
        return filled;
    }
    
    // An abstract method
    abstract public void draw( Graphics g );
    }