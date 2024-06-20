package src;

public class Bullet extends Collisions implements Playable 
{

    public static final double RADIUS = 1.5;

    private int stepCount;
    private boolean visible;

    public Bullet(double xPos, double yPos)
    {
        this(xPos, yPos, false);
        setX(xPos);
        setY(yPos);
    }

    public Bullet(double xPos, double yPos, boolean visible)
    {
        setX(xPos);
        setY(yPos);
        setSpeed(20.0);
        //heading shouldn't matter here
        setPose(new Pose(getXPos(), getYPos(), 1));
        setVelocity(new Vector2D(this.pose.getHeading(), getSpeed()));
        
        stepCount = 0;
        setCollided(false);
        setPoints(0);
        this.visible = visible;
    }

    @Override
    public void update() 
    {
        stepCount++;

        this.checkOffscreen();

    }

    @Override
    public void draw() 
    {
        StdDraw.setPenRadius(0.002);
        StdDraw.setPenColor(StdDraw.WHITE);
        if (!exceededSteps() && getVisible()) StdDraw.filledCircle(getXPos(), getYPos(), RADIUS);
    }

    public boolean getVisible()
    {
        return this.visible;
    }


    public boolean exceededSteps()
    {
        return this.stepCount >= 20;
    }

    public void setVisible()
    {
        this.visible = true;

    }

    public void setInvis()
    {
        this.visible = false;
    }





}
