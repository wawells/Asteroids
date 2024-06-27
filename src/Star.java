package src;

/**
 * An enumeration of stars: drawn objects in the background of the asteroids game.
 * @author wellswa
 */
public enum Star
{
    SMALL(1);
    //MEDIUM(GameDriver.GENERATOR.nextDouble(1, GameDriver.SCREEN_WIDTH - 1), GameDriver.GENERATOR.nextDouble(1, GameDriver.SCREEN_HEIGHT - 1), 2),
    //LARGE(GameDriver.GENERATOR.nextDouble(1, GameDriver.SCREEN_WIDTH - 1), GameDriver.GENERATOR.nextDouble(1, GameDriver.SCREEN_HEIGHT - 1), 3);


    private final int radius;

    Star(int radius)
    {
        this.radius = radius;
    }

    public int getRadius()
    {
        return radius;
    }

    // public static Star[] getStars()
    // {
    //     Star[] stars = new Star[50];

    //     for (int i = 0; i < stars.length; i++)
    //     {
    //         stars[i] = Star.SMALL;
    //     }

    //     return stars;
    // }


    public void draw()
    {
        double curX = getXPos();
        double curY = getYPos();

        StdDraw.setPenRadius(0.001);
        StdDraw.filledCircle(curX, curY, getRadius());
    }

    private double getXPos()
    {
        return GameDriver.GENERATOR.nextDouble(1, GameDriver.SCREEN_WIDTH - 1);
    }

    private double getYPos()
    {
        return GameDriver.GENERATOR.nextDouble(1, GameDriver.SCREEN_HEIGHT - 1);
    }

}



