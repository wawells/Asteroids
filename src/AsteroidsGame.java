package src;

/**
 * A class to create a game of asteroids.
 * @author wellswa
 */
public class AsteroidsGame implements Playable
{
    private Ship ship;

    private Star[] stars;
    private SmallAsteroid[] smallAs;
    private MediumAsteroid[] medAs;
    private LargeAsteroid[] lrgAs;

    private Bullet b1;


    public AsteroidsGame()
    {

        //draw the stars
        stars = Star.getStars(100);

        ship = new Ship();
        
        //create Asteroids
        smallAs = SmallAsteroid.getAsteroids(5);
        medAs = MediumAsteroid.getAsteroids(5);
        lrgAs = LargeAsteroid.getAsteroids(5);
    }

    
    /**
     * draws the game elements after they have been updated
     */
    @Override
    public void draw() {

        //draw stars
        for (int i = 0; i < stars.length; i++)
        {
            stars[i].draw();
        }

        ship.draw();

        //draw small asteroids
        for (int i = 0; i < smallAs.length; i++)
        {
            smallAs[i].draw();
        }

        //draw medium asteroids
        for (int i = 0; i < medAs.length; i++)
        {
            medAs[i].draw();
        }

        //draw large asteroids
        for (int i = 0; i < lrgAs.length; i++)
        {
            lrgAs[i].draw();
        }
        

        //only draw the bullet if the ship has fired.
        if (ship.firing()) b1.draw();

    }
    
    /**
     * Updates the state of all elements at each time step
     */
    @Override
    public void update() {


        ship.update();

        if (ship.canShoot()) b1 = new Bullet(ship);

        //only update the bullet if the ship has fired.
        if (ship.firing()) b1.update();
  
        //update small asteroids
        for(int i = 0; i < smallAs.length; i++)
        {
            smallAs[i].update();
        }

        //update medium asteroids
        for (int i = 0; i < medAs.length; i++)
        {
            medAs[i].update();
        }

        //update large asteroids
        for (int i = 0; i < lrgAs.length; i++)
        {
            lrgAs[i].update();
        }

        checkCollisions();
    }
    
    
    /**
     * Determines if the ship has collided with any asteroids or saucers. If so, destroys and respawns ship.
     */
    private void checkCollisions()
    {

        if (ship.hit(smallAs) || ship.hit(medAs) || ship.hit(lrgAs))
        {
            if (!ship.hasLives())
            {
                ship.destroy();

            } else
            {
                int lives = ship.getLives();
                ship = new Ship(lives - 1);
            }
        }
    }
    
}



