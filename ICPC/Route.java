import java.util.ArrayList;
import java.util.HashMap;
/**
 * Write a description of class Route here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Route
{
    // instance variables - replace the example below with your own
    private HashMap<String, Intersection> intersections = new HashMap<String, Intersection>();
    private int velocidad;
    private Rectangle route;
    private Sign señal;

    /**
     * Constructor for objects of class Route
     */
    public Route(Intersection A, Intersection B)
    {
        this.route = new Rectangle();
        this.intersections.put(A.getColor(),A);
        this.intersections.put(B.getColor(),B);
        route.modifyCoordinates(A.getCoordinatesX(), A.getCoordinatesY());
        route.changeSize((B.getCoordinatesY() - A.getCoordinatesY()), 10);
        this.velocidad = 0;
        
        
    }
    
    public void addSignal(){
        señal = new Sign(this.velocidad);
    }
    
    public void modifyVelocity(int velocity){
        this.velocidad = velocity;
    }
    
    public HashMap<String, Intersection> getIntersections(){
        return this.intersections;
    }
}
