import java.util.ArrayList;
/**
 * Write a description of class Route here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Route
{
    // instance variables - replace the example below with your own
    private ArrayList<Sign> signs;
    private Intersection[] intersections;

    /**
     * Constructor for objects of class Route
     */
    public Route(Intersection iA, Intersection iB)
    {
        this.intersections[0] = iA;
        this.intersections[1] = iB;
    }

    
    /**
     * Adds a new sign to the route
     * 
     * @param  s  The sign to be added
     */
    public void newSign(Sign s){
        this.signs.add(s);
    }
    
    /**
     * Returns the intersections that are connected by the route
     * 
     */
    public Intersection[] getIntersections(){
        return this.intersections;
    }
    
    /**
     * Returns the sign that specifies the speed limit of the route
     * 
     */
    public ArrayList<Sign> getSigns(){
        return this.signs;
    }
    
    /**
     * Adds a sign to the route. The sign specifies the speed limit of the route
     * @param speedLimit  The speed limit that the sign specifies
     */
    public void addSign(int speedLimit){
        this.signs.add(new Sign(speedLimit));
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
}
