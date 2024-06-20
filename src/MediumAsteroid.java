package src;

public class MediumAsteroid extends Collisions implements Asteroid 
{

    public static int RADIUS = 25;

    public MediumAsteroid()
    {
        setX(GameDriver.GENERATOR.nextDouble(0, GameDriver.SCREEN_WIDTH));
        setY(GameDriver.GENERATOR.nextDouble(0, GameDriver.SCREEN_HEIGHT));
        setPoints(200);
        setSpeed(1.0);
        //the heading of a circle shouldn't matter... Right guys?
        setPose(new Pose(getXPos(), getYPos(), getHeading()));
        setVelocity(new Vector2D(getHeading(), getSpeed()));
        setCollided(false);
    }


    @Override
    public void update() 
    {
        setPose(pose.move(velocity));
        setX(getPose().getX());
        setY(getPose().getY());

        //check if the ship has gone offscreen and wrap
        this.checkOffscreen();

    }

    @Override
    public void draw() 
    {
        StdDraw.setPenRadius(0.002);
        if (!hasCollided()) StdDraw.circle(getXPos(), getYPos(), getRadius());
    }

    @Override
    public int getRadius() 
    {
        return RADIUS;
    }

    @Override
    public double getHeading() 
    {
        return GameDriver.GENERATOR.nextDouble(0, 2 * Math.PI);

    }


    
}
