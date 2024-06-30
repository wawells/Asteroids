package src;

/**
 * Base class to represent an Asteroid of various sizes
 * @author wellswa
 */
public abstract class Asteroid extends Collisions
{
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
    return GameDriver.GENERATOR.nextDouble(0, 2 * Math.PI);
  }

  public abstract Asteroid respawn();



}