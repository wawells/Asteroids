package src;

public abstract class Collisions
{
    protected double xPosition;
    protected double yPosition;
    protected int lives;
    protected int points;
    protected double speed;
    protected Pose pose;
    protected Vector2D velocity;
    protected boolean collided;

    public double getXPos()
    {
        return this.xPosition;
    }
    
    public double getYPos()
    {
        return this.yPosition;
    }

    public int getLives()
    {
        return this.lives;
    }

    public int getPoints()
    {
        return this.points;
    }

    public double getSpeed()
    {
        return this.speed;
    }

    public Pose getPose()
    {
        return this.pose;
    }

    public Vector2D getVelocity()
    {
        return this.velocity;
    }

    public boolean hasCollided()
    {
        return this.collided;
    }

    public void setX(double x)
    {
        this.xPosition = x;
    }

    public void setY(double y)
    {
        this.yPosition = y;
    }

    public void setLives(int value)
    {
        this.lives = value;
    }

    public void setPoints(int value)
    {
        this.points = value;
    }

    public void setSpeed(double value)
    {
        this.speed = value;
    } 


    public void setPose(Pose pose)
    {
        this.pose = pose;
    }
    
    public void setVelocity(Vector2D velocity)
    {
        this.velocity = velocity;
    }

    public void setCollided(boolean value)
    {
        this.collided = value;
    }










    public void checkOffscreen()
    {
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