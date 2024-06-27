package src;

/**
 * A class to create a game of asteroids.
 * @author wellswa
 */
public class AsteroidsGame implements Playable
{

    private Ship ship;
    private SmallAsteroid a1, a2, a3, a4, a5, a6, a7;
    private MediumAsteroid a8, a9, a10, a11, a12;
    private LargeAsteroid a13, a14, a15, a16, a17;

    private Bullet b1, b2, b3;

    private int numFired;

    public AsteroidsGame()
    {

        numFired = 0;
        ship = new Ship();
        a1 = new SmallAsteroid();
        a2 = new SmallAsteroid();
        a3 = new SmallAsteroid();
        a4 = new SmallAsteroid();
        a5 = new SmallAsteroid();
        a6 = new SmallAsteroid();
        a7 = new SmallAsteroid();
        
        a8 = new MediumAsteroid();
        a9 = new MediumAsteroid();
        a10 = new MediumAsteroid();
        a11 = new MediumAsteroid();
        a12 = new MediumAsteroid();
        
        a13 = new LargeAsteroid();
        a14 = new LargeAsteroid();
        a15 = new LargeAsteroid();
        a16 = new LargeAsteroid();
        a17 = new LargeAsteroid();


    }

    
    /**
     * draws the game elements after they have been updated
     */
    @Override
    public void draw() {
        
        ship.draw();
        a1.draw();
        a2.draw();
        a3.draw();
        a4.draw();
        a5.draw();
        a6.draw();
        a7.draw();

        a8.draw();
        a9.draw();
        a10.draw();
        a11.draw();
        a12.draw();

        a13.draw();
        a14.draw();
        a15.draw();
        a16.draw();
        a17.draw();

        

        
        if (ship.firing())
        {
            b1.draw();
            // switch (numFired) {
            //     case 1:
            //         b1.draw();
            //         break;
            //     case 2:
            //         b2.draw();
            //         break;
            //     case 3:
            //         b3.draw();
            //         break;
            // }
            
        }

    }
    
    /**
     * Updates the state of all elements at each time step
     */
    @Override
    public void update() {

        

        ship.update();

        if (ship.canShoot())
        {
            b1 = new Bullet(ship);
            // numFired = ship.getNumFired();
            // switch (numFired) {
            //     case 1:
            //         b1 = new Bullet(ship);
            //         break;
            //     case 2:
            //         b2 = new Bullet(ship);
            //         break;
            //     case 3:
            //         b3 = new Bullet(ship);
            //     case 4:
            //         ship.setNumFired(1);
            //         break;
            // }
            
        }

        if (ship.firing())
        {
            b1.update();
            // switch (numFired) {
            //     case 1:
            //         b1.update();
            //         break;
            //     case 2:
            //         b2.update();
            //         break;
            //     case 3:
            //         b3.update();
            //         break;
            // }
            
        }
  
        a1.update();
        a2.update();
        a3.update();
        a4.update();
        a5.update();
        a6.update();
        a7.update();

        a8.update();
        a9.update();
        a10.update();
        a11.update();
        a12.update();

        a13.update();
        a14.update();
        a15.update();
        a16.update();
        a17.update();


        checkCollisions();
 
    }
    
    
    /**
     * Determines if the ship has collided with any asteroids or saucers. If so, destroys and respawns ship.
     */
    private void checkCollisions()
    {

        if (ship.hit(a1, a2, a3, a4, a5, a6, a7) || ship.hit(a8, a9, a10, a11, a12) || ship.hit(a13, a14, a15, a16, a17))
        {
            if (!ship.hasLives())
            {
                ship.destroy();

            } else
            {
                int lives = ship.getLives();
                System.out.println("Reducing Lives by one: " + lives);
                ship = new Ship(lives - 1);
                System.out.println("New Lives: " + ship.getLives());
            }
        }
    }
    
}












// private void checkCommands()
    // {
    //     if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_LEFT))
    //     {
    //         //pose = pose.newHeading(pose.getHeading() + 0.1);
    //         ship = ship.newHeading(ship.getHeading() + 0.1);

    //     }

    //     if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_RIGHT))
    //     {
    //         //pose = pose.newHeading(pose.getHeading() - 0.1);
    //         ship = ship.newHeading(ship.getHeading() - 0.1);
    //     }

    //     if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_UP))
    //     {            
    //         //velocity = new Vector2D(getHeading(), getSpeed());
    //         //pose = pose.move(velocity);

    //         ship.setVelocity(ship.getSpeed());
    //         ship.setMagnitude(ship.getVelocity().getMagnitude());
    //         ship = ship.move(ship.getVelocity());

    //     } else 
    //     {
    //         //velocity = velocity.newMagnitude(velocity.getMagnitude() * 0.99);
    //         //pose = pose.move(velocity);
    //         //ship.setVelocity(ship.getVelocity().getMagnitude() * 0.99);
            
    //         System.out.println("vel: " + ship.getVelocity().getMagnitude());
    //     }
    // }

    // private void checkShipPos()
    // {
    //     //check if the ship has gone offscreen and wrap
    //     // if (pose.getX() > GameDriver.SCREEN_WIDTH)
    //     // {
    //     //     setX(1);
    //     //     pose = pose.newX(getXPos());
    //     // } 
    
    //     // if (pose.getX() < 1)
    //     // {
    //     //     setX(GameDriver.SCREEN_WIDTH - 1);
    //     //     pose = pose.newX(getXPos());
    //     // } 


    //     // if (pose.getY() > GameDriver.SCREEN_HEIGHT) 
    //     // {
    //     //     setY(1);
    //     //     pose = pose.newY(getYPos());
    //     // }

    //     // if (pose.getY() < 1) 
    //     // {
    //     //     setY(GameDriver.SCREEN_HEIGHT - 1);
    //     //     pose = pose.newY(getYPos());
    //     // }
    // }
