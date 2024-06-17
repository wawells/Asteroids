package src;

public class SmallAsteroid extends Collisions implements Asteroid {

    public static int RADIUS = 10;
    private Pose pose;
    private Vector2D velocity;

    public SmallAsteroid()
    {
        setPoints(200);
        setSpeed(1.0);
        setXY();
        //the heading here shouldn't matter... Right guys?
        this.pose = new Pose(getXPos(), getYPos(), 1);
        this.velocity = new Vector2D(getHeading(), getSpeed());
    }


    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void draw() {
        StdDraw.setPenRadius(0.002);
        StdDraw.circle(getXPos(), getYPos(), getRadius());
    }

    @Override
    public double getHeading()
    {
        return GameDriver.GENERATOR.nextDouble(0, 2 * Math.PI);
    }

    @Override
    public int getRadius() {
        return RADIUS;
    }

    @Override
    public boolean hasCollided() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasCollided'");
    }


    private void setXY()
    {

    }
    
}
