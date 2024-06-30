package src;

/**
 * Class to represent a scoreboard.
 * @author wellswa
 */
public class Scoreboard extends Stationary
{
    private static final String BASE = " Score: ";
    private double score;
    private String text;

    //Default constructor to place the scoreboard in the middle of the screen and 20px from top of screen.
    public Scoreboard()
    {
        this(GameDriver.SCREEN_WIDTH / 2, GameDriver.SCREEN_HEIGHT - 20);
    }

    /**
     * Constructor to place the scoreboard at the given x and y coordinates.
     * @param x double - the x coordinate
     * @param y double - the y coordinate
     */
    public Scoreboard(double x, double y)
    {
        super(x,y);
        this.score = 0.0;
        this.text = BASE + "0";

    }

    /**
     * Getter method for the current score of the scoreboard.
     * @return double - the current score value
     */
    private double getScore()
    {
        return this.score;
    }

    /**
     * Getter method for the current text of the scoreboard.
     * @return String - the current text
     */
    private String getText()
    {
        return this.text;
    }

    /**
     * Sets the text of the scoreboard.
     * @param text String - the text to set
     */
    private void setText(String text)
    {
        if (text != null)
        {
            if (text.trim().length() > 0) this.text = text;
        }
    }

    /**
     * Updates the score by the given value.
     * @param value double - the value to sum to the score
     */
    public void add(double value)
    {
        this.score += value;
        setText(BASE + String.valueOf(getScore()));
    }

    @Override
    public void draw() {
        StdDraw.text(getX(), getY(), getText());
    }
    
}
