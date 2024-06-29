package src;
import java.util.ArrayList;

/**
 * A class to create a game of asteroids.
 * @author wellswa
 */
public class AsteroidsGame implements Playable
{
    private Ship ship;

    private Star[] stars;
    private ArrayList<SmallAsteroid> smallAs;
    private ArrayList<MediumAsteroid> medAs;
    private ArrayList<LargeAsteroid> lrgAs;

    private Bullet b1;
    private int score;


    public AsteroidsGame()
    {

        //draw the stars
        stars = Star.getStars(100);

        ship = new Ship();
        
        //create Asteroids
        smallAs = SmallAsteroid.getAsteroids(5);
        medAs = MediumAsteroid.getAsteroids(5);
        lrgAs = LargeAsteroid.getAsteroids(5);

        this.score = 0;
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
        for (int i = 0; i < smallAs.size(); i++)
        {
            smallAs.get(i).draw();
        }

        //draw medium asteroids
        for (int i = 0; i < medAs.size(); i++)
        {
            medAs.get(i).draw();
        }

        //draw large asteroids
        for (int i = 0; i < lrgAs.size(); i++)
        {
            lrgAs.get(i).draw();
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
        for(int i = 0; i < smallAs.size(); i++)
        {
            smallAs.get(i).update();
        }

        //update medium asteroids
        for (int i = 0; i < medAs.size(); i++)
        {
            medAs.get(i).update();
        }

        //update large asteroids
        for (int i = 0; i < lrgAs.size(); i++)
        {
            lrgAs.get(i).update();
        }

        checkShipCollisions();
        if (ship.firing()) checkBulletCollisions();
    }
    
    
    /**
     * Determines if the ship has collided with any asteroids or saucers. If so, destroys and respawns ship.
     */
    private void checkShipCollisions()
    {
        //check for ship collisions with all asteroids
        int coll = -1;
        int smlHit = ship.hit((SmallAsteroid[])smallAs.toArray());
        int medHit = ship.hit((MediumAsteroid[])medAs.toArray());
        int lrgHit = ship.hit((LargeAsteroid[])lrgAs.toArray());

        //determine what size asteroid was hit
        if (smlHit > -1) coll = 0;
        if (medHit > -1) coll = 1;
        if (lrgHit > -1) coll = 2;

        if (coll != -1) //check for any collision
        {
            //either decrement lives and respawn or destroy the ship and end the game.
            if (ship.isAlive())
            {
                int lives = ship.getLives();
                ship = new Ship(lives - 1);
            }

            //destroy the asteroid that collided
            if (coll == 0) smallAs.get(smlHit).destroy();
            else if (coll == 1) medAs.get(medHit).destroy();
            else if (coll == 2) lrgAs.get(lrgHit).destroy();
        }
    }


    private void checkBulletCollisions()
    {
        //check for bullet collisions with all asteroids
        int coll = -1;
        int smlHit = ship.hit((SmallAsteroid[])smallAs.toArray());
        int medHit = ship.hit((MediumAsteroid[])medAs.toArray());
        int lrgHit = ship.hit((LargeAsteroid[])lrgAs.toArray());

        //determine what size asteroid was hit
        if (smlHit > -1) coll = 0;
        if (medHit > -1) coll = 1;
        if (lrgHit > -1) coll = 2;

        if (coll != -1) //check for any collision
        {
            b1.destroy();
            //destroy the asteroid that collided
            if (coll == 0) smallAs.get(smlHit).destroy();
            else if (coll == 1) medAs.get(medHit).destroy();
            else if (coll == 2) lrgAs.get(lrgHit).destroy();
        }
    }


    //TODO manually convert arraylists to arrays, or change the methods, and update the array objects upon collisions
    
}



