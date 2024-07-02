package src;
import java.util.ArrayList;

/**
 * A class to create a game of asteroids.
 * @author wellswa
 */
public class AsteroidsGame implements Playable
{
    private Ship ship;
    private Saucer saucer;
    private Scoreboard sBoard;
    private Livesboard lBoard;

    private Star[] stars;
    private ArrayList<SmallAsteroid> smlAs;
    private ArrayList<MediumAsteroid> medAs;
    private ArrayList<LargeAsteroid> lrgAs;

    private Bullet b1;

    private int initAsts;
    private int levelCount;


    public AsteroidsGame()
    {
        initAsts = 15;
        levelCount = 1;

        //draw the stars
        stars = Star.getStars(100);
        
        ship = new Ship();
        saucer = new Saucer();
        sBoard = new Scoreboard();
        lBoard = new Livesboard(ship.getLives());

        
        //create Asteroids
        createAsteroids(initAsts);

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

        lBoard.draw();
        sBoard.draw();
        ship.draw();
        
        //only draw the saucer if it is created
        if (saucer.isAlive()) saucer.draw();

        //draw small asteroids
        for (int i = 0; i < smlAs.size(); i++)
        {
            smlAs.get(i).draw();
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
        double curScore = sBoard.getScore();

        //create more asteroids if reaching target score
        if (curScore / levelCount > 1000 && Math.round(curScore / 1000) == levelCount) //TODO how to get asteroids to only spawn once every thousand points
        {
            initAsts += 9;
            levelCount++;
            createAsteroids(initAsts);
            updateALists();
        }

        //create a saucer with .002 probability if it is not alive
        if (!saucer.isAlive())
        {
            double saucerProb = GameDriver.GENERATOR.nextDouble(0, 1);
            if (saucerProb > 0.998)
            {
                saucer.setAlive();
                System.out.println("Spawning saucer!");
            } 

        }

        if (saucer.isAlive()) saucer.update();

        if (ship.canShoot()) b1 = new Bullet(ship);

        //only update the bullet if the ship has fired.
        if (ship.firing()) b1.update();
  
        //update small asteroids
        for (SmallAsteroid sm: smlAs)
        {
            sm.update();
        }

        //update medium asteroids
        for (MediumAsteroid med: medAs)
        {
            med.update();
        }

        //update large asteroids
        for (LargeAsteroid lrg: lrgAs)
        {
            lrg.update();
        }

        checkShipCollisions();
        if (ship.firing()) checkBulletCollisions();
        updateALists();
    }
    
    
    /**
     * Determines if the ship has collided with any asteroids or saucers. If so, destroys both objects.
     */
    private void checkShipCollisions()
    {
        //check for ship collisions with all asteroids
        int coll = -1;
        int smlHit = ship.hit(smlAs);
        int medHit = ship.hit(medAs);
        int lrgHit = ship.hit(lrgAs);

        //determine what was hit
        if (smlHit > -1) coll = 0;
        if (medHit > -1) coll = 1;
        if (lrgHit > -1) coll = 2;
        if (ship.hit(saucer)) coll = 3;

        if (coll != -1) //check for any asteroid collision
        {
            //either decrement lives and respawn or destroy the ship and end the game.
            if (ship.isAlive())
            {
                int lives = ship.getLives();
                ship = new Ship(lives - 1);
                lBoard.reduce();
            }

            //destroy the asteroid that collided
            if (coll == 0) smlAs.get(smlHit).destroy();
            else if (coll == 1) medAs.get(medHit).destroy();
            else if (coll == 2) lrgAs.get(lrgHit).destroy();
            else if (coll == 3) saucer.destroy();
        }
    }


    /**
     * Determines if the bullet has collided with any asteroids or saucers. If so, destroys both objects.
     */
    private void checkBulletCollisions()
    {
        //check for bullet collisions with all asteroids
        int coll = -1;
        int smlHit = b1.hit(smlAs);
        int medHit = b1.hit(medAs);
        int lrgHit = b1.hit(lrgAs);

        //determine what size asteroid was hit
        if (smlHit > -1) coll = 0;
        if (medHit > -1) coll = 1;
        if (lrgHit > -1) coll = 2;
        if (b1.hit(saucer)) coll = 3;


        if (coll != -1) //check for any collision
        {
            //destroy the bullet
            b1.destroy();

            //destroy the asteroid that collided and update score
            if (coll == 0)
            {
                smlAs.get(smlHit).destroy();
                sBoard.add(SmallAsteroid.POINTS);

            } else if (coll == 1)
            {
                medAs.get(medHit).destroy();
                sBoard.add(MediumAsteroid.POINTS);

            } else if (coll == 2)
            {
                lrgAs.get(lrgHit).destroy();
                sBoard.add(LargeAsteroid.POINTS);
            } else if (coll == 3)
            {
                saucer.destroy();
                sBoard.add(Saucer.POINTS);
            }
        }
    }

    /**
     * Checks all asteroid lists and removes any destroyed asteroids.
     */
    private void updateALists()
    {
        for (int i = 0; i < smlAs.size(); i++)
        {
            if (!smlAs.get(i).isAlive()) smlAs.remove(i);
        }

        for (int i = 0; i < medAs.size(); i++)
        {
            if (!medAs.get(i).isAlive()) medAs.remove(i);
        }

        for (int i = 0; i < lrgAs.size(); i++)
        {
            if (!lrgAs.get(i).isAlive()) lrgAs.remove(i);
        }
    }

    /**
     * Creates equal number of all sizes of asteorids.
     * @param numAsteroids - int total number of asteroids to create
     */
    private void createAsteroids(int numAsteroids)
    {
        int numSize = numAsteroids / 3;

        smlAs = SmallAsteroid.getAsteroids(numSize);
        medAs = MediumAsteroid.getAsteroids(numSize);
        lrgAs = LargeAsteroid.getAsteroids(numSize);


    }
    
}



