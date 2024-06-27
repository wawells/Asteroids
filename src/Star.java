package src;

/**
 * An enumeration of stars: drawn objects in the background of the asteroids game.
 * @author wellswa
 */
public enum Star
{
    SMALL(5),
    MEDIUM(10),
    LARGE(15);


    private final int radius;

    Star(int radius)
    {
        this.radius = radius;
    }

    public int getRadius()
    {
        return radius;
    }

}



