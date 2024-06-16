package src;

public class Ship extends Collisions
{
    private double speed;
    private int xPos;
    private int yPos;
    private int pointValue;
    private boolean isAlive;

    private Pose pose;
    private Vector2D velocity;

    
    public static final double WIDTH = 10.0;
    public static final double HEIGHT = 20.0;
    public static final double INIT_HEADING = 1.5708;

    public Ship()
    {
        this.speed = 1.0;
        this.xPos = GameDriver.SCREEN_WIDTH/2;
        this.yPos = GameDriver.SCREEN_HEIGHT/2;
        this.pose = new Pose(getXPos(), getYPos(), INIT_HEADING);
        this.pointValue = 0;
        this.isAlive = true;
        this.velocity = new Vector2D(this.pose.getHeading(), 0);

    }

    @Override
    public boolean hasCollided() {
        boolean coll = false;

        return coll; //TODO stub
    }

    @Override
    public int getXPos() {
        return this.xPos;
    }

    @Override
    public int getYPos() {
        return this.yPos;
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
            velocity = new Vector2D(pose.getHeading(), speed);
            pose = pose.move(velocity);
            
        } else 
        {
            
            velocity = velocity.newMagnitude(velocity.getMagnitude() * 0.99);
            pose = pose.move(velocity);
        
        }


    }
    

}