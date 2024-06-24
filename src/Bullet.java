package src;

public class Bullet extends Collisions
{

    public static final double RADIUS = 1.5;
    private Ship source;
    private int stepCount;

    public Bullet(Ship source)
    {
        this.source = source;
        setX(source.getXPos());
        setY(source.getYPos());
        setSpeed(20.0);
        //heading shouldn't matter here
        setPose(source.getPose());
        setVelocity(new Vector2D(getPose().getHeading(), getSpeed()));
        
        stepCount = 0;
        setPoints(0);
    }

    @Override
    public void update() 
    {
        if (!exceededSteps())
        {
            setPose(pose.move(velocity));
            setX(getPose().getX());
            setY(getPose().getY());
            stepCount++;
            this.checkOffscreen();
        } else
        {
            source.stopFiring();
        }
    }

    @Override
    public void draw() 
    {
        StdDraw.setPenRadius(0.002);
        StdDraw.setPenColor(StdDraw.WHITE);
        if (!exceededSteps()) StdDraw.filledCircle(getXPos(), getYPos(), RADIUS);
    }
    
    public boolean exceededSteps()
    {
        return this.stepCount >= 20;
    }


    @Override
    public void destroy()
    {
        
    }

    





}
