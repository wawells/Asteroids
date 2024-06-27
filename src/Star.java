package src;

/**
 * An class to represent a star: drawn objects in the background of the asteroids game.
 * @author wellswa
 */
public class Star
{
    private final int radius = 1;

    private double xPos;
    private double yPos;

    /**
     * Default constructor creating a new star at random x and y coordinates.
     */
    public Star()
    {
        this(GameDriver.GENERATOR.nextDouble(1, GameDriver.SCREEN_WIDTH - 1), GameDriver.GENERATOR.nextDouble(1, GameDriver.SCREEN_HEIGHT - 1));
    }

    /**
     * Constructor to create a star at designated x and y coordinates.
     * @param x double x coordinate
     * @param y double y coordinate
     */
    public Star(double x, double y)
    {
        this.xPos = x;
        this.yPos = y;
    }

    /**
     * Gets the radius of the star.
     * @return int the radius
     */
    private int getRadius()
    {
        return this.radius;
    }

    /**
     * Gets the x coordinate of the star.
     * @return double x coordinate
     */
    public double getX()
    {
        return this.xPos;
    }

    /**
     * Gets the y coordinate of the star.
     * @return double y coordinate
     */
    public double getY()
    {
        return this.yPos;
    }

    /**
     * Generates an array of 100 stars with random x and y positions.
     * @param count the number of stars to create 
     * @return Star array of random stars
     */
    public static Star[] getStars(int num)
    {
        Star[] stars = new Star[num];

        for (int i = 0; i < stars.length; i++)
        {
            stars[i] = new Star();
        }

        return stars;
    }


    /**
     * Draws the star at current x and y coordinates.
     */
    public void draw()
    {
        StdDraw.setPenRadius(0.002);
        StdDraw.filledCircle(getX(), getY(), getRadius());
    }


}



