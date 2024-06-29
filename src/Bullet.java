package src;

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
            this.checkOffscreen();
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
     * Determines if the ship has collided with any small asteroid.
     * @param sml at least one SmallAsteroid to check for collision
     * @return int index of the asteroid that has collided with the ship, or -1 if no collision detected
     */
    public int hit (SmallAsteroid... sml)
    {
        int index = 0;
        boolean hit = false;

        if (sml.length > 1)
        {
            for (int i = 0; i < sml.length && !hit; i++)
            {
                index = i;
                if (sml[i].isAlive()) hit = hasCollided(sml[i], SmallAsteroid.RADIUS);
            }
        } else if (sml.length == 1)
        {
            if (sml[0].isAlive()) hit = hasCollided(sml[0], SmallAsteroid.RADIUS);
        }

        if (!hit) index = -1;

        return index;
    }

    /**
     * Determines if the ship has collided with any medium asteroid.
     * @param med at least one MediumAsteroid to check for collision
     * @return int index of the asteroid that has collided with the ship, or -1 if no collision detected
     */
    public int hit(MediumAsteroid... med)
    {
        int index = 0;
        boolean hit = false;
        if (med.length > 1)
        {
            for (int i = 0; i < med.length && !hit; i++)
            {
                index = i;
                if (med[i].isAlive()) hit = hasCollided(med[i], SmallAsteroid.RADIUS);
            }
        } else if (med.length == 1)
        {
            if (med[0].isAlive()) hit = hasCollided(med[0], SmallAsteroid.RADIUS);
        }

        if (!hit) index = -1;
        return index;

    }

    /**
     * Determines if the ship has collided with any large asteroid.
     * @param lrg at least one LargeAsteroid to check for collision
     * @return int index of the asteroid that has collided with the ship, or -1 if no collision detected
     */
    public int hit(LargeAsteroid... lrg)
    {
        int index = 0;
        boolean hit = false;
        if (lrg.length > 1)
        {
            for (int i = 0; i < lrg.length && !hit; i++)
            {
                index = i;
                if (lrg[i].isAlive()) hit = hasCollided(lrg[i], SmallAsteroid.RADIUS);
            }
        } else if (lrg.length == 1)
        {
            if (lrg[0].isAlive()) hit = hasCollided(lrg[0], SmallAsteroid.RADIUS);
        }

        if (!hit) index = -1;

        return index;

    }

    





}
