import java.util.ArrayList;
import java.util.HashMap;
/**
 * @author Miguel Angel Gonzalez Mahecha - Andrea Valentina Torres Tobar
 * @version 18/09/22
 */

public class ICPC
{
    private int Length;
    private int Width;
    private boolean ok;
    private ArrayList<Route> routes = new ArrayList<Route>();
    private HashMap<String, Intersection> intersections = new HashMap<String, Intersection>();
    private ArrayList<Sign> signs = new ArrayList<Sign>();

    /**
     * Constructor for objects of class ICPC
     */
    public ICPC(int length, int width)
    {
        this.Length = length;
        this.Width = width;
    }
    
    /**
     * Adds a new route to the intersection
     * 
     * @param  intersectionA  The first intersection
     * intersectionB The second intersection
     */
    public void newRoute(String intersectionA, String intersectionB){
        Route r = new Route(findIntersection(intersectionA), findIntersection(intersectionB));
        this.routes.add(r);
    }
    
    /**
     * Find an intersection
     * 
     * @param  A  intersections color
     * @return iA intersection founded
     */
    private Intersection findIntersection(String A){
        Intersection iA = intersections.get(A);
        return iA;
    }
    
    /**
     * Delete a route
     * 
     * @param  r  route that will be delete
     * @return boolean if route was deleted
     */
    public boolean deleteRoute(Route r){
        boolean d = false;
        int index = routes.indexOf(r);
        if (index == -1){
            d = false;
        }
        else{
            routes.remove(index);
            d = true;
        }
        return d;
    }
    
    
    public boolean isConnected(String intersection){
        boolean c = false;
        for (Route r : this.routes){
            if (r.getIntersections().get(intersection) != null){
                c = true;
            }
        }
        return c;
    }
    
    public Route findRoute(Intersection locationB){
        for (Route r : this.routes){
            if (r.getIntersections()[1] == locationB){
                return r;
            }
        }
        return null;
    }
    
    public void addSpeedLimit(String iB, int speedLimit){
        for (Route r : this.routes){
            if (r.getIntersections().get(intersection) != null){
                r.addSign(speedLimit);
            }
        }
    }
    /**
     * Adds a sign to the route. The sign specifies the speed limit of the route
     * @param speedLimit  The speed limit that the sign specifies
     */
    public void addSign(int speedLimit){
        this.signs.add(new Sign(speedLimit));
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
        this.intersections.put(color, i);
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

}
