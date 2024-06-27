package src;

/**
 * A class experimenting with a child of a Pose object to reduce code duplication. No longer in use.
 * @author wellswa
 */
public class Destructible extends Pose {

    protected int lives;
    protected double points;
    protected double speed;
    protected Vector2D velocity;
    protected double magnitude;

    public Destructible(double xPosition, double yPosition, double heading, int lives, double speed, double magnitude) {
        super(xPosition, yPosition, heading);
        this.lives = lives;
        this.speed = speed;
        this.points = 0;
        this.magnitude = magnitude;
        this.velocity = new Vector2D(getHeading(), magnitude);
    }

    public Destructible(double xPosition, double yPosition, double heading, double speed, double points, double magnitude)
    {
        this(xPosition, yPosition, heading, 1, speed, magnitude);
        this.points = points;
    }
    

    public int getLives()
    {
        return this.lives;
    }

    public double getPoints()
    {
        return this.points;
    }

    public Vector2D getVelocity()
    {
        return this.velocity;
    }
    public double getSpeed()
    {
        return this.speed;
    }

    public double getMagnitude()
    {
        return this.magnitude;
    }

    public void setLives(int lives)
    {
        this.lives = lives;
    }

    public void setPoints(double points)
    {
        this.points = points;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public void setVelocity(double velocity)
    {
        this.velocity = new Vector2D(getHeading(), velocity);
    }

    public void setMagnitude(double magnitude)
    {
        this.magnitude = magnitude;
    }

    //return new Destructible(getX(), getY(), heading, getLives(), getSpeed());
    

    

}
