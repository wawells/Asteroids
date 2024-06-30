package src;

/**
 * Abstract class to represent any stationary objects.
 * @author wellswa
 */
public abstract class Stationary
{
    protected double xPosition;
    protected double yPosition;

    public Stationary(double x, double y)
    {
        this.xPosition = x;
        this.yPosition = y;
    }

     /**
     * Gets the x coordinate of the object.
     * @return double x coordinate
     */
    protected double getX()
    {
        return this.xPosition;
    }

    /**
     * Gets the y coordinate of the object.
     * @return double y coordinate
     */
    protected double getY()
    {
        return this.yPosition;
    }

    /**
     * Sets the x coordinate of the stationary object.
     * @param x the x coordinate to set
     */
    protected void setX(double x)
    {
        this.xPosition = x;
    }

    /**
     * Sets the y coordinate of the stationary object.
     * @param y the y coordinate to set
     */
    protected void setY(double y)
    {
        this.yPosition = y;
    }

    

    public abstract void draw();
}