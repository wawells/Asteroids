package src;

/**
 * A class to represent a saucer in the Asteroids game.
 */
public class Saucer extends Collisions
{

    public static final double WIDTH = 20;
    public static final double HEIGHT = 10;
    public static final double POINTS = 400;
    public static final double SPEED = 1.0;

    private double initHeading;
    private double initVel;

    /**
     * Default constructor to create a new Saucer at a random x and y position and heading a random direction.
     */
    public Saucer()
    {
        setX(GameDriver.GENERATOR.nextDouble(0, GameDriver.SCREEN_WIDTH));
        setY(GameDriver.GENERATOR.nextDouble(0, GameDriver.SCREEN_HEIGHT));
        setSpeed(SPEED);
        setPoints(POINTS);

        this.initHeading = GameDriver.randomHeading();
        this.initVel = GameDriver.randomHeading();

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
            double dirProb = GameDriver.getRandom(0, 1);
            if (dirProb >= 0.95)
            {
                setPose(getPose().newHeading(GameDriver.randomHeading()));
            }
            setVelocity(getVelocity().newHeading(getPose().getHeading()));
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



}
