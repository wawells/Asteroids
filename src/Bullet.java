package src;

import java.util.ArrayList;

/**
 * A class to represent a bullet in the asteroids game.
 * @author wellswa
 */
public class Bullet extends Collisions
{

    public static final double RADIUS = 1.5;
    private Ship source;
    private int stepCount;
    private boolean isAlive;

    /**
     * Constructor to create a new bullet at the source location.
     * @param source the Ship that is firing the bullet
     */
    public Bullet(Ship source)
    {
        this.source = source;
        setX(source.getXPos());
        setY(source.getYPos());
        setSpeed(20.0);
        //heading shouldn't matter here
        setPose(source.getPose());
        setVelocity(new Vector2D(getPose().getHeading(), getSpeed()));
        
        stepCount = 0;
        setPoints(0);
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
            stepCount++;
            this.wrapScreen();
        } else
        {
            source.stopFiring();
        }
    }

    @Override
    public void draw() 
    {
        StdDraw.setPenRadius(0.002);
        StdDraw.setPenColor(StdDraw.WHITE);
        if (isAlive()) StdDraw.filledCircle(getXPos(), getYPos(), RADIUS);
    }


    public boolean isAlive()
    {
        return !exceededSteps() && isAlive;
    }
    
    /**
     * Determines if the bullet has traveled the maximum number of steps.
     * @return true if the bullet has traveled at least 20 steps.
     */
    private boolean exceededSteps()
    {
        return this.stepCount >= 20;
    }

    /**
     * Destroys the object in game; stops updating and drawing.
     */
    @Override
    public void destroy()
    {
        this.isAlive = false;
    }


    /**
     * Determines if the ship has collided with any asteroid.
     * @param aList asteroids to check for collision
     * @return int index of the asteroid that has collided with the bullet, or -1 if no collision detected
     */
     public int hit (ArrayList<? extends Asteroid> aList)
    {
        int index = 0;
        boolean hit = false;

        if (aList.size() > 0)
        {
            for (int i = 0; i < aList.size() && !hit; i++)
            {
                index = i;
                hit = hasCollided(aList.get(i), aList.get(i).getRadius());
            }
        }

        if (!hit) index = -1;

        return index;
    }

    public boolean hit(Saucer saucer)
    {
        return hasCollided(saucer, 10);
    }

}
