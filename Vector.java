import java.util.Arrays;

/**
 * Write a description of class Vector here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Vector
{
    private double[] components;
    private double magnitude;
    private double bearing;
    
    public Vector() {
        components = new double[2];
        bearing = 0;
    }
    public double[] getComponents() {
        return components;
    }
    public double getBearing() {
        return bearing;
    }
    public void setMagnitude() {
        magnitude = Math.sqrt(components[0] * components[0] + 
            components[1] * components[1]);
    }
    public void setXComp(double deltaX) {
        components[0] = deltaX;
        setMagnitude();
    }
    public void setYComp(double deltaY) {
        components[1] = deltaY;
        setMagnitude();
    }
    public void setBearing(double bear) {
        if (bear < -360 || bear > 360) {
            throw new IllegalArgumentException();
        } else {
            bearing = bear;
        }
    }
    public void reset() {
        Arrays.fill(components, 0);
        magnitude = 0;
        bearing = 0;
    }
}
