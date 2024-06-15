package src;

/**
 * The Playable interface defines the set of methods that must be implemented by
 * game classes in order to be playable using the GameDriver.
 * 
 * @author CS 159 Instructors
 * @version 3/28/2021
 *
 */
public interface Playable {

    /**
     * Change the state of the game appropriately for a single time step.
     */
    void update();

    /**
     * Draw the current state of the game.
     */
    void draw();

}
