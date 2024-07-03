package src;
import java.awt.Color;
import java.awt.geom.GeneralPath;
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
        Playable game = new AsteroidsGame();
        
        // Main game loop
        while (true) {
            StdDraw.clear(SCREEN_COLOR);
            game.update();
            game.draw();
            StdDraw.show();
            StdDraw.pause(DRAW_DELAY);
        }
    }


        /**
     * Gets a random double value between two bounds.
     * @param lBound double - the lower bound
     * @param uBound double - the upper bound
     * @return double - the random value
     */
    public static double getRandom(double lBound, double uBound)
    {
        return GameDriver.GENERATOR.nextDouble(lBound, uBound);
    }

    /**
     * Gets a random double value to represent a heading in the bounds of 0 and 2 pi.
     * @return double - the random heading value in radians
     */
    public static double randomHeading()
    {
        return getRandom(0, 2 * Math.PI);
    }

    public static double getRandomWExclusion(double lBound, double uBound, double excludeL, double excludeH)
    {
        double rand;
        do 
        {
            rand = GENERATOR.nextDouble(lBound, uBound);

        } while (rand >= excludeL && rand <= excludeH);


        return rand;
    }


    public static double getRandomExcludeStart(String xOrY)
    {
        Double ret = -1.0;
        if (xOrY.equals("x")) ret = getRandomWExclusion(0, SCREEN_WIDTH, (SCREEN_WIDTH / 2) - 20, (SCREEN_WIDTH / 2) + 20);
        else if (xOrY.equals("y")) ret = getRandomWExclusion(0, SCREEN_HEIGHT, (SCREEN_HEIGHT / 2) - 20, (SCREEN_HEIGHT / 2) + 20);
        return ret;
    }


    


}
