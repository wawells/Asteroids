package src;
import java.awt.Color;
import java.util.Random;

/**
 * Driver for game applications.
 * 
 * @author CS 159 Instructors
 * @version V1.0, 3/2021
 *
 */
public class GameDriver {

    public static final Color SCREEN_COLOR = new Color(0, 0, 0);
    public static final int DRAW_DELAY = 10; // In milliseconds.
    public static final int SCREEN_WIDTH = 480;
    public static final int SCREEN_HEIGHT = 480;

    // Game objects should use this random number generator rather
    // than using different generators across multiple classes. This approach
    // facilitates reproducible testing by setting an initial seed for this
    // generator.
    public static final Random GENERATOR = new Random();

    /**
     * Create a game object and a display screen and execute the main update
     * loop.
     * 
     * @param args - not used
     */
    public static void main(String[] args) {

        // Initialize the game screen
        StdDraw.setCanvasSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        StdDraw.setXscale(0, SCREEN_WIDTH);
        StdDraw.setYscale(0, SCREEN_HEIGHT);
        StdDraw.enableDoubleBuffering();
        

        // Create a game object
        Playable game;
        game = new AsteroidsGame();
        
        // Main game loop
        while (true) {
            StdDraw.clear(SCREEN_COLOR);
            game.update();
            game.draw();
            StdDraw.show();
            StdDraw.pause(DRAW_DELAY);
        }
    }

}
