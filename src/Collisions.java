package src;

public abstract class Collisions implements Playable
{
    //private int lives;
    private double speed;
    private int xPosition;
    private int yPosition;
    private boolean collision;
    
    //TODO add point value to this

    public Collisions(){;}

    public abstract boolean hasCollided();

    public abstract int getXPos();

    public abstract int getYPos();

    public abstract void draw();


}