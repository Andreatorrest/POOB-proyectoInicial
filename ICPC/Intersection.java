import java.util.ArrayList;
/**
 * Write a description of class Intersection here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Intersection
{
    // instance variables - replace the example below with your own
    private String color;
    private Circle intersection;

    /**
     * Constructor for objects of class Intersection
     */
    public Intersection(String color, int x, int y)
    {
        // initialise instance variables
        this.color = color;
        intersection = new Circle();
        intersection.changeSize(15);
        intersection.modifyCoordinates(x, y);
    }
    
    public int getCoordinatesX(){
        return intersection.getCoordinateX();
    }
    
    public int getCoordinatesY(){
        return intersection.getCoordinateY();
    }
    
    /**
     * Gets color of intersection. Used to identify the intersection
     * 
     * @return   The color of the intersection
     */
    public String getColor(){
        return this.color;
    }

}
