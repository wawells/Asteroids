package src;

/**
 * Bouncy ball to illustrate how we can make a game object using StdDraw.
 * 
 * @author CS 159 Instructors
 * @version 3/2021
 *
 */
public class Ball {

    public static final int RADIUS = 50;
    public static final double GRAVITY = .1;
    public static final double INITIAL_SPEED = 3.0;
    public static final double DOWN = 3.0 * Math.PI / 2.0;
    public static final double UP = Math.PI / 2.0;

    private Point position;
    private Vector2D velocity;
    private Vector2D acceleration;

    /**
     * Initialize the ball in the middle of the screen.
     */
    public Ball() {

        this.position = new Point(GameDriver.SCREEN_WIDTH / 2,
                GameDriver.SCREEN_HEIGHT / 2);
        this.velocity = new Vector2D(UP, INITIAL_SPEED);
        this.acceleration = new Vector2D(DOWN, GRAVITY);
    }

    /**
     * Draw the ball as a filled circle in the currently selected pen color.
     */
    public void draw() {
        StdDraw.filledCircle(position.getX(), position.getY(), RADIUS);
    }

    /**
     * Update the ball's velocity and position.
     */
    public void update() {
        if (position.getY() < RADIUS) {
            velocity = velocity.newHeading(UP);
        } else {
            velocity = velocity.add(acceleration);
        }
        position = position.move(velocity);
    }

}
