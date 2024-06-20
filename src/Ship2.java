package src;

public class Ship2 extends Destructible implements Playable
{

    public static final double WIDTH = 10.0;
    public static final double HEIGHT = 20.0;
    public static final double INIT_HEADING = 1.5708;
    public static final double INIT_X = GameDriver.SCREEN_WIDTH / 2;
    public static final double INIT_Y = GameDriver.SCREEN_HEIGHT / 2;

    
    public Ship2(double x, double y, double heading, int lives, double speed, double magnitude)
    {
        super(x, y, heading, 3, 2.0, magnitude);
        setVelocity(magnitude * 0.99);

    }


    public Ship2()
    {
        this(INIT_X, INIT_Y, INIT_HEADING, 3, 2.0, 0);
    }
    

    @Override
    public void draw() {

        StdDraw.setPenRadius(0.002);
        StdDraw.setPenColor(StdDraw.WHITE);
        GameUtils.drawPoseAsTriangle(this, WIDTH, HEIGHT);
    }




    @Override
    public void update() {

    }
    

    public Ship2 newHeading(double heading)
    {
        return new Ship2(getX(), getY(), heading, getLives(), getSpeed(), getMagnitude());
    }

    public Ship2 move(Vector2D vector)
    {
        return new Ship2(getX() + vector.getX(), getY() + vector.getY(), getHeading(), getLives(), getSpeed(), 0.99 * getMagnitude());
    }


}