package src;

import java.util.ArrayList;

/**
 * A class to represent a large asteroid.
 * @author wellswa
 */
public class LargeAsteroid extends Collisions implements Asteroid 
{

    public static int RADIUS = 40;
    private boolean isAlive;

    /**
     * Default constructor to create a large asteroid at a random location in the game.
     */
    public LargeAsteroid()
    {

        setX(GameDriver.GENERATOR.nextDouble(0, GameDriver.SCREEN_WIDTH));
        setY(GameDriver.GENERATOR.nextDouble(0, GameDriver.SCREEN_HEIGHT));
        setPoints(200);
        setSpeed(1.0);
        //the heading of a circle shouldn't matter... Right guys?
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
            
            this.checkOffscreen();
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

    /**
     * Gets the radius of the asteroid.
     */
    @Override
    public int getRadius() 
    {
        return RADIUS;

    }

    public boolean isAlive()
    {
        return this.isAlive;
    }


    /**
     * Generates a random heading in the range of 0 and 2 radians multiplied by pi.
     * @return double random heading
     */
    @Override
    public double getHeading() 
    {
        return GameDriver.GENERATOR.nextDouble(0, 2 * Math.PI);

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
