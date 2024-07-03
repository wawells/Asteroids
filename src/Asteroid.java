package src;

/**
 * Base class to represent an Asteroid of various sizes
 * @author wellswa
 */
public abstract class Asteroid extends Collisions
{
  public static final double SPEED = 1.0;
  protected int radius;
  
  protected int getRadius()
  {
    return this.radius;
  }

  protected void setRadius(int radius)
  {
    this.radius = radius;
  }

  protected double getHeading()
  {
    return GameDriver.randomHeading();
  }

  public abstract Asteroid respawn();



}