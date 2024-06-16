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
        // TODO Auto-generated method stub
        playerShip.update();
    }

    /**
     * draws the game elements after they have been updated
     */
    @Override
    public void draw() {
        // TODO Auto-generated method stub
        playerShip.draw();
    }
}

