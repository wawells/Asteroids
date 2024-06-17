package src;

public class Ship extends Collisions implements Playable
{

    private Pose pose;
    private Vector2D velocity;
    
    public static final double WIDTH = 10.0;
    public static final double HEIGHT = 20.0;
    public static final double INIT_HEADING = 1.5708;

    public Ship()
    {
        this.speed = 1.0;
        setX(GameDriver.SCREEN_WIDTH/2);
        setY(GameDriver.SCREEN_HEIGHT/2);
        this.pose = new Pose(getXPos(), getYPos(), INIT_HEADING);
        this.isAlive = true;
        this.velocity = new Vector2D(this.pose.getHeading(), 0);
        setSpeed(2.0);
        setAlive();
    }

    @Override
    public boolean hasCollided() {
        boolean coll = false;

        return coll; //TODO stub
    }

    @Override
    public void draw() {

        StdDraw.setPenRadius(0.002);
        StdDraw.setPenColor(StdDraw.WHITE);
        GameUtils.drawPoseAsTriangle(pose, WIDTH, HEIGHT);
    }


    @Override
    public void update() {
        
        if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_LEFT))
        {
            pose = pose.newHeading(pose.getHeading() + 0.1);
        }

        if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_RIGHT))
        {
            pose = pose.newHeading(pose.getHeading() - 0.1);
        }

        if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_UP))
        {            
            velocity = new Vector2D(pose.getHeading(), getSpeed());
            pose = pose.move(velocity);
        } else 
        {
            velocity = velocity.newMagnitude(velocity.getMagnitude() * 0.99);
            pose = pose.move(velocity);
        }

        //check if the ship has gone offscreen and wrap
        if (pose.getX() > GameDriver.SCREEN_WIDTH)
        {
            setX(1);
            pose = pose.newX(getXPos());
        } 
    
        if (pose.getX() < 1)
        {
            setX(GameDriver.SCREEN_WIDTH - 1);
            pose = pose.newX(getXPos());
        } 


        if (pose.getY() > GameDriver.SCREEN_HEIGHT) 
        {
            setY(1);
            pose = pose.newY(getYPos());
        }

        if (pose.getY() < 1) 
        {
            setY(GameDriver.SCREEN_HEIGHT - 1);
            pose = pose.newY(getYPos());
        }

    }
    

}