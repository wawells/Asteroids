package src;

/**
 * A class to represent a saucer in the Asteroids game.
 */
public class Saucer extends Collisions
{

    public static final double WIDTH = 20;
    public static final double HEIGHT = 10;
    public static final double POINTS = 400;

    private double initHeading;
    private double initVel;

    /**
     * Default constructor to create a new Saucer at a random x and y position and heading a random direction.
     */
    public Saucer()
    {
        setX(GameDriver.GENERATOR.nextDouble(0, GameDriver.SCREEN_WIDTH));
        setY(GameDriver.GENERATOR.nextDouble(0, GameDriver.SCREEN_HEIGHT));
        setSpeed(4.0);
        setPoints(POINTS);

        this.initHeading = randomHeading();
        this.initVel = randomHeading();

        setPose(new Pose(getXPos(), getYPos(), initHeading));
        setVelocity(new Vector2D(this.pose.getHeading(), initVel));
        setLives(0); //start it with 0 lives until created

    }

    /**
     * Determines if the saucer still has lives.
     * @return true if the saucer has at least one life
     */
    public boolean isAlive()
    {
        return getLives() > 0;
    }


    @Override
    public void update() 
    {
        if (isAlive())
        {
            //5 percent chance to set a new random heading
            double dirProb = getRandom(0, 1);
            if (dirProb > 0.95)
            {
                setPose(getPose().newHeading(randomHeading()));
            }
            setPose(pose.move(velocity));
            setX(getPose().getX());
            setY(getPose().getY());

            if (this.offScreen()) setLives(0);
        }
    }

    @Override
    public void draw() 
    {
        if (isAlive())
        {
            StdDraw.setPenRadius(0.002);
            StdDraw.rectangle(getXPos(), getYPos(), WIDTH, HEIGHT);
        }
    }

    /**
     * Setter method to enable the saucer.
     */
    public void setAlive()
    {
        setLives(1);
    }

    @Override
    public void destroy() 
    {
        setLives(0);
    }


    /**
     * Gets a random double value between two bounds.
     * @param lBound double - the lower bound
     * @param uBound double - the upper bound
     * @return double - the random value
     */
    private double getRandom(double lBound, double uBound)
    {
        return GameDriver.GENERATOR.nextDouble(lBound, uBound);
    }

    /**
     * Gets a random double value to represent a heading in the bounds of 0 and 2 pi.
     * @return double - the random heading value in radians
     */
    private double randomHeading()
    {
        return getRandom(0, 2 * Math.PI);
    }
    
}
