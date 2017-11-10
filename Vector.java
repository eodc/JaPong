
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
    private double angle;
    
    public Vector() {
        components = new double[2];
    }
    public double[] getComponents() {
        return components;
    }
    public double getMagnitude() {
        return magnitude;
    }
    public double getAngle() {
        return angle;
    }
    public void setIComponent(double i) {
        components[0] = i;
        angle = Math.toDegrees(Math.atan(components[1] / i));
        magnitude = Math.sqrt(Math.pow(i, 2) + Math.pow(components[1], 2));
    }
    public void setJComponent(double j) {
        components[1] = j;
        angle = Math.toDegrees(Math.atan(j / components[0]));
        magnitude = Math.sqrt(Math.pow(components[0], 2) + Math.pow(j, 2));
    }
}
