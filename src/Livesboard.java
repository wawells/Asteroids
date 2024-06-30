package src;

/**
 * Class to represent a scoreboard representing the current lives of the player.
 */
public class Livesboard extends Stationary
{

    private static final String BASE = "Lives: ";

    private String text;
    private int lives;

    /**
     * Default constructor to create a new scoreboard showing the desired number of lives.
     * @param lives int - the number of starting lives
     */
    public Livesboard(int lives)
    {
        this(60, GameDriver.SCREEN_HEIGHT - 20, lives);
    }

    /**
     * Three param constructor to create a new Scoreboard for the desired number of lives at the given x and y coordinates.
     * @param x double - the x coordinate
     * @param y double - the y coordinate
     * @param lives int - the desired starting number of lives
     */
    public Livesboard(double x, double y, int lives)
    {
        super(x,y);
        this.lives = lives;
        this.text = BASE + String.valueOf(lives);
    }

    /**
     * Gets the current text of the lifeboard.
     * @return String - the text of the board
     */
    private String getText()
    {
        return this.text;
    }

    /**
     * Gets the current lives of the lifeboard.
     * @return int - the current number of lives
     */
    private int getLives()
    {
        return this.lives;
    }

    /**
     * Sets the text of the lifeboard.
     * @param text the text to display
     */
    private void setText(String text)
    {
        if (text != null)
        {
            if (text.trim().length() > 0) this.text = text;
        }
    }

    /**
     * Reduces the number of lives on the lifeboard by 1.
     */
    public void reduce()
    {
        if (getLives() > 0) this.lives -= 1;
        setText(BASE + String.valueOf(getLives()));
    }

    /*
     * Sets the number of lives on the lifeboard to the desired number.
     * @param lives the number of lives to set the lifeboard to
     */
    public void setLives(int lives)
    {
        this.lives = lives;
    }

    @Override
    public void draw() {
        StdDraw.text(getX(), getY(), getText());
    }
    
}
