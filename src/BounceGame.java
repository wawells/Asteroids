package src;
import java.awt.Color;

/**
 * A simple non-interactive "game" designed to illustrate a sample
 * implementation of the Playable interface. The game will display a large
 * bouncing ball.
 * 
 * @author CS 159 Instructors
 * @version 1.0, 3/28/2021
 *
 */
public class BounceGame implements Playable {

    private Ball ball;

    /**
     * Set up the game to contain a single bouncy ball.
     */
    public BounceGame() {
        ball = new Ball();
    }

    /**
     * Update the state of all game objects. (In this case, just a single ball.)
     */
    public void update() {
        ball.update();
    }

    /**
     * Draw all game objects. (In this case, just a single ball.)
     */
    public void draw() {
        // Set the pen color to white. (For this game we want all objects to be
        // white.)
        StdDraw.setPenColor(Color.WHITE);

        ball.draw();
    }

}
