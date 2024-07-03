package src;

import java.util.ArrayList;

/**
 * A class representing a ship in the game Asteroids.
 * @author wellswa
 */
public class Ship extends Collisions
{
    
    public static final double WIDTH = 10.0;
    public static final double HEIGHT = 20.0;
    public static final double INIT_HEADING = 1.5708;
    public static final double SPEED = 2.0;

    private int numFired;
    private boolean canShoot;
    private boolean firing;
    private boolean alive;

    /**
     * Default constructor to create a ship with 3 lives.
     */
    public Ship()
    {
        this(3);
    }

    /**
     * Single param constructor to create a ship with a specified number of lives in the middle of the screen.
     * @param lives an int number of lives the ship has
     */
    public Ship(int lives)
    {
        setX(GameDriver.SCREEN_WIDTH/2);
        setY(GameDriver.SCREEN_HEIGHT/2);
        setSpeed(SPEED);
        setPose(new Pose(getXPos(), getYPos(), INIT_HEADING));
        setVelocity(new Vector2D(this.pose.getHeading(), 0));
        
        setLives(lives);

        this.canShoot = false;
        this.firing = false;
        this.numFired = 0;
        this.alive = true;
    }

    @Override
    public void draw() {

        if (isAlive())
        {
            StdDraw.setPenRadius(0.002);
            StdDraw.setPenColor(StdDraw.WHITE);
            GameUtils.drawPoseAsTriangle(pose, WIDTH, HEIGHT);
        }
    }

    @Override
    public void update() {
        
        if (isAlive())
        {
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
                setX(getPose().getX());
                setY(getPose().getY());
            } else 
            {
                setVelocity(velocity.newMagnitude(velocity.getMagnitude() * 0.99));
                setPose(pose.move(velocity));
                setX(getPose().getX());
                setY(getPose().getY());
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
    
            this.wrapScreen();

        }

    }

    /**
     * Gets the number of shots fired.
     * @return int number of shots currently fired.
     */
    public int getNumFired()
    {
        return this.numFired;
    }

    /**
     * Determines if the ship is able to shoot.
     * @return true if the ship can shoot
     */
    public boolean canShoot()
    {
        return this.canShoot;
    }

    /**
     * Determines if the ship is currently firing a bullet.
     * @return true if the ship is currently firing
     */
    public boolean firing()
    {
        return this.firing;
    }

    /**
     * Determines if the ship currently has lives.
     * @return true if the ship has at least one life
     */
    public boolean isAlive()
    {
        return getLives() > 0;
    }

    /**
     * Setter method to tell the ship to stop firing.
     */
    public void stopFiring()
    {
        this.firing = false;
    }
    
    /**
     * Setter method to increment the current number of shots fired by the ship.
     */
    public void addFired()
    {
        this.numFired++;
    }

    /**
     * Setter method to set the numbe rof shots fired by the ship.
     * @param num the number of shots the ship has fired
     */
    public void setNumFired(int num)
    {
        this.numFired = num;
    }

    /**
     * Setter method to decrement the number of shots the ship has fired.
     */
    public void removeFired()
    {
        if (numFired > 0) this.numFired--;
    }

    /**
     * Destroys the ship.
     */
    @Override
    public void destroy()
    {
        System.out.println("Destroying the ship"); //TODO unused
    }


    /**
     * Determines if the ship has collided with any asteroids.
     * @param aList list of asteroids to check
     * @return int index of the asteroid that has collided with the ship, or -1 if no collision detected
     */
    public int hit (ArrayList<? extends Asteroid> aList)
    {
        int index = 0;
        boolean hit = false;

        if (aList.size() > 0)
        {
            for (int i = 0; i < aList.size() && !hit; i++)
            {
                index = i;
                hit = hasCollided(aList.get(i), aList.get(i).getRadius());
            }
        }

        if (!hit) index = -1;

        return index;
    }

    public boolean hit (Saucer saucer)
    {
        return hasCollided(saucer, 10);
    }
}