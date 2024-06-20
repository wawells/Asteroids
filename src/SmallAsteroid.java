package src;

public class SmallAsteroid extends Collisions implements Asteroid 
{

    public static int RADIUS = 10;

    public SmallAsteroid()
    {
        this.setX(GameDriver.GENERATOR.nextDouble(20, GameDriver.SCREEN_WIDTH - 20));
        this.setY(GameDriver.GENERATOR.nextDouble(20, GameDriver.SCREEN_HEIGHT - 20));
        setSpeed(1.0);
        //the heading of a circle shouldn't matter... Right guys?
        setPose(new Pose(getXPos(), getYPos(), this.getHeading()));
        setVelocity(new Vector2D(this.pose.getHeading(), getSpeed()));

        setCollided(false);
        setPoints(200);
    }


    
    @Override
    public void draw() 
    {
        StdDraw.setPenRadius(0.002);
        if (!hasCollided()) StdDraw.circle(getXPos(), getYPos(), getRadius());
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
    public int getRadius() 
    {
        return RADIUS;
    }
    
    @Override
    public double getHeading()
    {
        return GameDriver.GENERATOR.nextDouble(0.5, 2 * Math.PI);
    }
    
}
