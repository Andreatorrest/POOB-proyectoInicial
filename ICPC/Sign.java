
/**
 * Write a description of class Sign here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sign
{
    // instance variables - replace the example below with your own
    private int speedLimit;
    private Triangle señal;

    /**
     * Constructor for objects of class Sign
     */
    public Sign(int speedLimit)
    {
        this.speedLimit = speedLimit;
        señal = new Triangle();
        señal.changeSize(5, 5);
        señal.changeColor("red");
    }

}
