package src;

public class Ship extends Collisions implements Playable
{
    
    public static final double WIDTH = 10.0;
    public static final double HEIGHT = 20.0;
    public static final double INIT_HEADING = 1.5708;

    private int numFired;
    private boolean canShoot, firing;

    public Ship()
    {
        setX(GameDriver.SCREEN_WIDTH/2);
        setY(GameDriver.SCREEN_HEIGHT/2);
        setSpeed(2.0);
        setPose(new Pose(getXPos(), getYPos(), INIT_HEADING));
        setVelocity(new Vector2D(this.pose.getHeading(), 0));
        
        setCollided(false);

        this.canShoot = false;
        this.firing = false;
        this.numFired = 1;
    }

    @Override
    public void draw() {

        StdDraw.setPenRadius(0.002);
        StdDraw.setPenColor(StdDraw.WHITE);
        GameUtils.drawPoseAsTriangle(pose, WIDTH, HEIGHT);
    }

    @Override
    public void update() {
        
        this.canShoot = false;

        if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_LEFT))
        {
            setPose(pose.newHeading(pose.getHeading() + 0.1));
        }

        if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_RIGHT))
        {
            setPose(pose.newHeading(pose.getHeading() - 0.1));
        }

        
        if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_UP))
        {            
            setVelocity(new Vector2D(pose.getHeading(), getSpeed()));
            setPose(pose.move(velocity));
        } else 
        {
            setVelocity(velocity.newMagnitude(velocity.getMagnitude() * 0.99));
            setPose(pose.move(velocity));
        }
        
        if (StdDraw.hasNextKeyTyped())
        {
            char key = StdDraw.nextKeyTyped();

            if (key == ' ')
            {
                this.canShoot = true;
                this.firing = true;
                addFired();
            }
        }

        
        this.checkOffscreen();

    }

    public int getNumFired()
    {
        return this.numFired;
    }

    public boolean canShoot()
    {
        return this.canShoot;
    }

    public boolean firing()
    {
        return this.firing;
    }

    public void stopFiring()
    {
        this.firing = false;
    }
    public void addFired()
    {
        this.numFired++;
    }

    public void setNumFired(int num)
    {
        this.numFired = num;
    }

    public void removeFired()
    {
        if (numFired > 0) this.numFired--;
    }

}