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
    private int[] Coordinates;
    private ArrayList<Route> routes;

    /**
     * Constructor for objects of class Intersection
     */
    public Intersection(String color, int x, int y)
    {
        // initialise instance variables
        this.color = color;
        this.Coordinates[0] = x;
        this.Coordinates[1] = y;
    }
    
    /**
     * Adds a new route to the intersection
     * 
     * @param  destiny  The route to be added
     */
    public void newRoute(Intersection destiny){
        Route r = new Route(this, destiny);
        this.routes.add(r);
    }
    
    public boolean deleteRoute(Route r){
        int index = this.getRoutes().indexOf(r);
        if (index == -1){
            return false;
        }
        
        this.getRoutes().remove(index);
        return true;
    }
    
    public boolean isConnected(Intersection iB){
        for (Route r : this.routes){
            if (r.getIntersections()[1] == iB){
                return true;
            }
        }
        
        return false;
    }
    
    public void addSpeedLimit(Intersection iB, int speedLimit){
        for (Route r : this.routes){
            if (r.getIntersections()[1] == iB){
                r.addSign(speedLimit);
            }
        }
    }
    
    public Route findRoute(Intersection locationB){
        for (Route r : this.routes){
            if (r.getIntersections()[1] == locationB){
                return r;
            }
        }
        return null;
    }
    
    /**
     * Gets color of intersection. Used to identify the intersection
     * 
     * @return   The color of the intersection
     */
    public String getColor(){
        return this.color;
    }
    
    
    /**
     * Gets all the routes of the intersection
     * 
     * @return   The routes that belong to this intersection
     */
    public ArrayList<Route> getRoutes(){
        return this.routes;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
}
