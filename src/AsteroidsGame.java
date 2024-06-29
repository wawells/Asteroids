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
        

        //only draw the bullet if the ship has fired
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
        //check for ship collisions with all asteroids
        int size = -1;
        int smlHit = ship.hit(smallAs);
        int medHit = ship.hit(medAs);
        int lrgHit = ship.hit(lrgAs);

        //determine what size asteroid was hit
        if (smlHit > -1) size = 0;
        if (medHit > -1) size = 1;
        if (lrgHit > -1) size = 2;

        if (size != -1) //check for any collision
        {
            //either decrement lives and respawn or destroy the ship and end the game.
            if (ship.isAlive())
            {
                int lives = ship.getLives();
                ship = new Ship(lives - 1);
            } else
            {
                ship.destroy();
            }

            //destroy the asteroid that collided
            if (size == 0) smallAs[smlHit].destroy();
            else if (size == 1) medAs[medHit].destroy();
            else if (size == 2) lrgAs[lrgHit].destroy();
        }
    }
    
}



