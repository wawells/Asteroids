package src;

public class Ship extends Collisions
{
    private double speed;
    private int xPos;
    private int yPos;
    private int pointValue;
    private boolean isAlive;

    public Ship()
    {
        this.speed = 0.1;
        this.xPos = GameDriver.SCREEN_WIDTH;
        this.yPos = GameDriver.SCREEN_HEIGHT;
        this.pointValue = 0;
        this.isAlive = true;

    }

    @Override
    public boolean hasCollided() {
        // TODO Auto-generated method stub
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
        GameUtils.drawPoseAsTriangle()
    }


    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    

}