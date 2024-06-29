package src;

/**
 * An abstract class to represent all objects in a game of Asteroids that can collide with one another.
 * @author wellswa
 */
public abstract class Collisions implements Playable
{
    protected double xPosition;
    protected double yPosition;
    protected int lives;
    protected int points;
    protected double speed;
    protected Pose pose;
    protected Vector2D velocity;
    
    /**
     * Gets the x coordinate of the object.
     * @return double x coordinate
     */
    public double getXPos()
    {
        return this.xPosition;
    }
    
    /**
     * Gets the y coordinate of the object.
     * @return double y coordinate
     */
    public double getYPos()
    {
        return this.yPosition;
    }

    /**
     * Gets the current number of lives of the object.
     * @return int number of lives
     */
    public int getLives()
    {
        return this.lives;
    }

    /**
     * Gets the point value of the object.
     * @return int number of points
     */
    public int getPoints()
    {
        return this.points;
    }

    /**
     * Gets the current speed of the object.
     * @return double speed of object
     */
    public double getSpeed()
    {
        return this.speed;
    }

    /**
     * Gets the Pose used by the object.
     * @return Pose
     */
    public Pose getPose()
    {
        return this.pose;
    }

    /**
     * Gets the Vector2D used by the object for movement.
     * @return Vector2D movement vector
     */
    public Vector2D getVelocity()
    {
        return this.velocity;
    }

    /**
     * Determines if this object has collded with another within a margin.
     * @param other the other object to check for collision
     * @param distance the margin for how close the two objects can be
     * @return true if the two objects share x and y coordinates within the margin of error
     */
    public boolean hasCollided(Collisions other, double distance)
    {
        return Math.abs(getPose().getX() - other.getPose().getX()) < distance && Math.abs(getPose().getY() - other.getPose().getY()) < distance;
    }

    /**
     * Sets the x coordinate of the object to the desired value.
     * @param x double the desired x coordinate value
     */
    public void setX(double x)
    {
        this.xPosition = x;
    }

    /**
     * Sets the y coordinate of the object to the desired value.
     * @param y double the desired y coordinate value
     */
    public void setY(double y)
    {
        this.yPosition = y;
    }

    /**
     * Sets the number of lives of the object.
     * @param lives the number of lives to set the current object to
     */
    public void setLives(int value)
    {
        this.lives = value;
    }

    /**
     * Sets the point value of the object.
     * @param value the point value associated with the collidable object
     */
    public void setPoints(int value)
    {
        this.points = value;
    }

    /**
     * Sets the speed of the current object to the desired value.
     * @param value the desired speed of the object
     */
    public void setSpeed(double value)
    {
        this.speed = value;
    } 

    /**
     * Sets the pose of the object.
     * @param pose the pose for the direction and xy position
     */
    public void setPose(Pose pose)
    {
        this.pose = pose;
    }
    
    /**
     * Sets the velocity of the object.
     * @param velocity the Vector2D for the speed and direction of travel
     */
    public void setVelocity(Vector2D velocity)
    {
        this.velocity = velocity;
    }

    public abstract void destroy();

    /**
     * Determines if the pose object is off of the screen and wraps to the appropriate side.
     */
    public void checkOffscreen()
    {
        if (pose.getX() > GameDriver.SCREEN_WIDTH)
        {
            setX(1);
            pose = pose.newX(getXPos());
        } 
    
        if (pose.getX() < 1)
        {
            setX(GameDriver.SCREEN_WIDTH - 1);
            pose = pose.newX(getXPos());
        } 


        if (pose.getY() > GameDriver.SCREEN_HEIGHT) 
        {
            setY(1);
            pose = pose.newY(getYPos());
        }

        if (pose.getY() < 1) 
        {
            setY(GameDriver.SCREEN_HEIGHT - 1);
            pose = pose.newY(getYPos());
        }
    }
}