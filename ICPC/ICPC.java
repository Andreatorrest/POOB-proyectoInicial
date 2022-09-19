import java.util.ArrayList;
/**
 * Write a description of class ICPC here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ICPC
{
    private int Length;
    private int Width;
    private boolean ok;
    private ArrayList<Route> Routes = new ArrayList<Route>();
    private ArrayList<Intersection> Intersections = new ArrayList<Intersection>();
    private ArrayList<Sign> Signs = new ArrayList<Sign>();

    /**
     * Constructor for objects of class ICPC
     */
    public ICPC(int length, int width)
    {
        this.Length = length;
        this.Width = width;
    }

    private Intersection findIntersection(String inter){
        Intersection iA = null;
        for (Intersection i : this.Intersections){
            if (i.getColor() == inter){
                iA = i;
            }
        }
        
        return iA == null ? null : iA;
    }
    /**
     * Adds a new intersection
     * 
     * @param  color  Used to identify the intersection
     * @param x  coordinate in the x axis
     * @param y  coordinate in the y axis
     */
    public void addIntersection(String color, int x, int y){
        Intersection i = new Intersection(color, x, y);
        this.Intersections.add(i);
        this.ok = true;
    }
    
    /**
     * Adds new route that connects intersectionA and intersectionB. This route is bidirectional
     * 
     * @param  intersectionA  First intersection
     * @param  intersectionA  Second intersection
     */
    public void addRoute(String intersectionA, String intersectionB){
        Intersection iA = this.findIntersection(intersectionA);
        Intersection iB = this.findIntersection(intersectionB);
        
        if (iA == null || iB == null){
            this.ok = false;
            return;
        }
        
        iA.newRoute(iB);
        iB.newRoute(iA);
        
        this.ok = true;
    }
    
    /**
     * Adds new sign to a road that connects intersectionA and intersectionB. The sign has the specifie speedLimit
     * 
     * @param  intersectionA  First intersection
     * @param  intersectionA  Second intersection
     * @param  speedLimit     The speed limit of the route
     */
    public void putSign(String intersectionA, String intersectionB, int speedLimit){
        Intersection iA = this.findIntersection(intersectionA);
        Intersection iB = this.findIntersection(intersectionB);
        
        if (iA == null || iB == null){
            this.ok = false;
            return;
        }
        
        // See if the two intersections are connected
        if (!iA.isConnected(iB)){
            this.ok = false;
            return;
        }
        
        iA.addSpeedLimit(iB, speedLimit);
        this.ok = true;
    }
    
    /**
     * Deletes an intersection identified by its color
     * 
     * @param  color  The color of the intersection to be deleted
     */
    public void delIntersection(String color){
        int index = this.Intersections.indexOf(this.findIntersection(color));
        
        if (index == -1){
            this.ok = false;
            return;
        }
        
        this.Intersections.remove(index);
        this.ok = true;
    }
    
    /**
     * Deletes the route that connects locationA and locationB
     * 
     * @param  locationA  First intersection
     * @param  locationB  Second intersection
     */
    public void delRoute(String locationA, String locationB){
        Intersection iA = this.findIntersection(locationA);
        Intersection iB = this.findIntersection(locationB);
        
        Route r = iA.findRoute(iB);
        
        if (r == null || iA == null || iB == null){
            this.ok = false;
            return;
        }
        
        boolean deleted_from_iA = iA.deleteRoute(r);
        boolean deleted_from_iB = iB.deleteRoute(r);
        
        this.ok = deleted_from_iA && deleted_from_iA ? true : false;
        
    }
    
    /**
     * Removes a sign of the road that connects intersectionA and intersectionB
     * 
     * @param  intersectionA  First intersection
     * @param  intersectionA  Second intersection
     */
    public void removeSign(String intersectionA, String intersectionB){
        
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
}
