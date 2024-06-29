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

        setPoints(200);
    }


    
    @Override
    public void draw() 
    {
        StdDraw.setPenRadius(0.002);
        StdDraw.circle(getXPos(), getYPos(), getRadius());
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
    public int getRadius() 
    {
        return RADIUS;
    }

    /**
     * Returns a new instance of a small asteroid.
     * @return SmallAsteroid at random location
     */
    public SmallAsteroid respawn()
    {
        return new SmallAsteroid();
    }
    
    /**
     * Generates a random heading in the range of 0 and 2 radians multiplied by pi.
     * @return double random heading
     */
    @Override
    public double getHeading()
    {
        return GameDriver.GENERATOR.nextDouble(0.5, 2 * Math.PI);
    }

    /**
     * Generates and returns an array of SmallAsteroids of size num.
     * @param num the number of small asteroids to create
     * @return an array of type SmallAsteroid
     */
    public static SmallAsteroid[] getAsteroids(int num)
    {
        SmallAsteroid[] smls = new SmallAsteroid[num];

        for (int i = 0; i < smls.length; i++)
        {
            smls[i] = new SmallAsteroid();
        }

        return smls;
    }
    
    @Override
    public void destroy()
    {
        System.out.println("destroying small");
    }
}
