package src;

import java.util.ArrayList;

/**
 * A class to represent a large asteroid.
 * @author wellswa
 */
public class LargeAsteroid extends Asteroid 
{
    public static final int POINTS = 50;
    public static final int RADIUS = 40;
    private boolean isAlive;

    /**
     * Default constructor to create a large asteroid at a random location in the game.
     */
    public LargeAsteroid()
    {

        setX(GameDriver.getRandomExcludeStart("x"));
        setY(GameDriver.getRandomExcludeStart("y"));
        setPoints(POINTS);
        setSpeed(Asteroid.SPEED);
        setRadius(40);
        setPose(new Pose(getXPos(), getYPos(), getHeading()));
        setVelocity(new Vector2D(getHeading(), getSpeed()));
        this.isAlive = true;
    }

    
    @Override
    public void update() 
    {
        if (isAlive())
        {
            setPose(pose.move(velocity));
            setX(getPose().getX());
            setY(getPose().getY());
            
            this.wrapScreen();
        }

    }

    @Override
    public void draw() 
    {
        if (isAlive())
        {
            StdDraw.setPenRadius(0.002);
            StdDraw.circle(getXPos(), getYPos(), getRadius());
        }
        
    }

    public boolean isAlive()
    {
        return this.isAlive;
    }

    /**
     * Returns a new instance of a large asteroid. Used when an asteroid has collided with another unit.
     */
    public LargeAsteroid respawn()
    {
        return new LargeAsteroid();
    }

    /**
     * Generates and returns an array of LargeAsteroid of size num.
     * @param num the number of LargeAsteroid to create
     * @return an array of type LargeAsteroid
     */
    public static ArrayList<LargeAsteroid> getAsteroids(int num)
    {
        ArrayList<LargeAsteroid> lrgs = new ArrayList<>();

        for (int i = 0; i < num; i++)
        {
            lrgs.add(new LargeAsteroid());
        }

        return lrgs;
    }

    @Override
    public void destroy()
    {
        this.isAlive = false;
    }
    
}
