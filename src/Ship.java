package src;

public class Ship extends Collisions
{
    
    public static final double WIDTH = 10.0;
    public static final double HEIGHT = 20.0;
    public static final double INIT_HEADING = 1.5708;

    private int numFired;
    private boolean canShoot;
    private boolean firing;
    private boolean hasLives;

    public Ship()
    {
        this(3);
    }

    public Ship(int lives)
    {
        setX(GameDriver.SCREEN_WIDTH/2);
        setY(GameDriver.SCREEN_HEIGHT/2);
        setSpeed(2.0);
        setPose(new Pose(getXPos(), getYPos(), INIT_HEADING));
        setVelocity(new Vector2D(this.pose.getHeading(), 0));
        
        setLives(lives);

        this.canShoot = false;
        this.firing = false;
        this.numFired = 0;
        this.hasLives = true;
    }

    @Override
    public void draw() {

        if (hasLives())
        {
            StdDraw.setPenRadius(0.002);
            StdDraw.setPenColor(StdDraw.WHITE);
            GameUtils.drawPoseAsTriangle(pose, WIDTH, HEIGHT);
        }
    }

    @Override
    public void update() {
        if (hasLives())
        {
            if (getLives() < 1) this.hasLives = false;
    
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
    
            this.checkOffscreen();

        }

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

    public boolean hasLives()
    {
        return this.hasLives;
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

    @Override
    public void destroy()
    {
        
    }


    public boolean hit (SmallAsteroid... sml)
    {
        boolean hit = false;
        if (sml.length > 1)
        {
            for (int i = 0; i < sml.length && !hit; i++)
            {
                hit = hasCollided(sml[i], SmallAsteroid.RADIUS);
            }
        } else if (sml.length == 1)
        {
            hit = hasCollided(sml[0], SmallAsteroid.RADIUS);
        }

        return hit;
    }

    public boolean hit(MediumAsteroid... med)
    {
        boolean hit = false;
        if (med.length > 1)
        {
            for (int i = 0; i < med.length && !hit; i++)
            {
                hit = hasCollided(med[i], MediumAsteroid.RADIUS);
            }
        } else if (med.length == 1)
        {
            hit = hasCollided(med[0], MediumAsteroid.RADIUS);
        }

        return hit;

    }

    public boolean hit(LargeAsteroid... lrg)
    {
        boolean hit = false;
        if (lrg.length > 1)
        {
            for (int i = 0; i < lrg.length && !hit; i++)
            {
                hit = hasCollided(lrg[i], LargeAsteroid.RADIUS);
            }
        } else if (lrg.length == 1)
        {
            hit = hasCollided(lrg[0], LargeAsteroid.RADIUS);
        }

        return hit;

    }

    



}