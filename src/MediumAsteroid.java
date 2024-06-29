package src;

import java.util.ArrayList;

public class MediumAsteroid extends Collisions implements Asteroid 
{

    public static int RADIUS = 25;
    private boolean isAlive;

    public MediumAsteroid()
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
     * Returns a new instance of the medium asteroid.
     */
    public MediumAsteroid respawn()
    {
        return new MediumAsteroid();
    }

    /**
     * Generates and returns an array of MediumAsteroid of size num.
     * @param num the number of MediumAsteroid to create
     * @return an array of type MediumAsteroid
     */
    public static ArrayList<MediumAsteroid> getAsteroids(int num)
    {
        ArrayList<MediumAsteroid> mdms = new ArrayList<>();

        for (int i = 0; i < num; i++)
        {
            mdms.add(new MediumAsteroid());
        }

        return mdms;
    }

    @Override
    public void destroy()
    {
        this.isAlive = false;

    }



    
}
