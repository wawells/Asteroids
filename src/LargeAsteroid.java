package src;

public class LargeAsteroid extends Collisions implements Asteroid 
{

    public static int RADIUS = 40;

    public LargeAsteroid()
    {

        setX(GameDriver.GENERATOR.nextDouble(0, GameDriver.SCREEN_WIDTH));
        setY(GameDriver.GENERATOR.nextDouble(0, GameDriver.SCREEN_HEIGHT));
        setPoints(200);
        setSpeed(1.0);
        //the heading of a circle shouldn't matter... Right guys?
        setPose(new Pose(getXPos(), getYPos(), getHeading()));
        setVelocity(new Vector2D(getHeading(), getSpeed()));
    }

    
    @Override
    public void update() 
    {
        setPose(pose.move(velocity));
        setX(getPose().getX());
        setY(getPose().getY());
        
        this.checkOffscreen();

    }

    @Override
    public void draw() 
    {
        StdDraw.setPenRadius(0.002);
        StdDraw.circle(getXPos(), getYPos(), getRadius());
        
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

    public boolean collided(Collisions other)
    {
        return getXPos() == other.getXPos() && getYPos() == other.getYPos();
    }

    @Override
    public void destroy()
    {
        
    }
    
}
