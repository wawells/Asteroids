package src;

public class AsteroidsGame implements Playable
{

    private Ship playerShip;

    public AsteroidsGame()
    {
        playerShip = new Ship();
 
    }

    /**
     * Updates the state of all elements at each time step
     */
    @Override
    public void update() {
        playerShip.update();
    }

    /**
     * draws the game elements after they have been updated
     */
    @Override
    public void draw() {
        playerShip.draw();
    }
}

