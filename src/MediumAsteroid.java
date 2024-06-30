package src;

import java.util.ArrayList;

public class MediumAsteroid extends Asteroid
{
    public static final int POINTS = 100;
    public static final int RADIUS = 25;
    private boolean isAlive;

    public MediumAsteroid()
    {
        setX(GameDriver.GENERATOR.nextDouble(0, GameDriver.SCREEN_WIDTH));
        setY(GameDriver.GENERATOR.nextDouble(0, GameDriver.SCREEN_HEIGHT));
        setPoints(POINTS);
        setSpeed(1.0);
        setRadius(25);
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
