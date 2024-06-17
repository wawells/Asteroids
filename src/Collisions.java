package src;

public abstract class Collisions
{
    protected int xPosition;
    protected int yPosition;
    protected int lives;
    protected int points;
    protected double speed;
    protected boolean isAlive;
    
    public int getXPos()
    {
        return this.xPosition;
    }
    
    public int getYPos()
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

    public boolean isAlive()
    {
        return this.isAlive;
    }

    public void setX(int x)
    {
        this.xPosition = x;
    }

    public void setY(int y)
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

    public void setAlive()
    {
        this.isAlive = true;
    }

    public void setDead()
    {
        this.isAlive = false;
    }

    public abstract boolean hasCollided();

}