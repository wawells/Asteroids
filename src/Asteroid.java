package src;

/**
 * Interface with the methods required for all sizes of asteroids.
 * @author wellswa
 */
public interface Asteroid extends Playable
{
  public int getRadius();

  public double getHeading();

  public Asteroid respawn();

}
